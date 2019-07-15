package gennerator.example.demo.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 代码生成工具类
 * Created by wangqichang on 2018/5/30.
 */
@Slf4j
public class FreeMarkerGeneratorUtil {


    private final static String targetPath = FreeMarkerGeneratorUtil.class.getResource("/").getPath();
    //StrUtil.sub(str,startIndex,endIndex)
    private final static String path = StrUtil.sub(targetPath, 1, targetPath.indexOf("/target"));

    private final static String templatePath = path + "/src/main/resources/template";

    /**
     * 主方法
     * @param driver
     * @param url
     * @param user
     * @param pwd
     */
    public static void generatorMvcCode(String driver, String url, String user, String pwd, String SQLtableName
                                        , String databaseName, String tablePrefix,String beanPackage
                                        , String daoPackage, String mapperPackage, String servicePackage, String serviceImplPackage,
                                        String controllerPackage,String basePackage) throws IOException, TemplateException {

        //获取tableModel
        List<EntityDataModel> dataModelList = getDataModel(driver, url, user, pwd, databaseName, basePackage, tablePrefix, SQLtableName);
        //包名
        List<PackageDataModel> dirPackage = new ArrayList<>();
        dirPackage.add(new PackageDataModel(basePackage+beanPackage,"Do") );
        dirPackage.add(new PackageDataModel(basePackage+daoPackage, "Dao") );
        dirPackage.add(new PackageDataModel(basePackage+mapperPackage, "Mapper") );
        dirPackage.add(new PackageDataModel(basePackage+servicePackage, "Service") );
        dirPackage.add(new PackageDataModel(basePackage+serviceImplPackage, "ServiceImpl") );
        dirPackage.add(new PackageDataModel(basePackage+controllerPackage, "Controller") );

        for(PackageDataModel item : dirPackage){
            createDir(item.getPackageName());
            for(EntityDataModel entityDataModel :dataModelList){
                createFile(entityDataModel, item);
            }
        };
    }

    /**
     * 从数据库获取table信息
     *
     * @param driver
     * @param url
     * @param user
     * @param pwd
     * @param databaseName
     * @return
     */
    public static List<EntityDataModel> getDataModel(String driver, String url, String user, String pwd, String databaseName
                                                    ,String basePackage, String tablePrefix,String SQLtableName) {
        List<EntityDataModel> dataModelList = new ArrayList<>();
        Connection con = null;
        //注册驱动
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            log.error("获取数据连接失败，{}", e.getMessage());
            return null;
        }

        //查询数据库下所有表
        String sql = "select table_name,table_comment from information_schema.tables where table_schema='" + databaseName + "'";

        if(StrUtil.isNotBlank(SQLtableName)){
            sql += " and table_name in ( '"+SQLtableName+"' )";
        }

        log.info(" SQL {}",sql);
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                    String tableName = rs.getString(1);
                    String tableComment = rs.getString(2);
                    //dataModel.setTableName(rs.getString(1));
                    //dataModel.setTableComment(rs.getString(2));
                    EntityDataModel dataModel = getEntityModel(con, tableName, tableComment, basePackage, tablePrefix);
                    dataModelList.add(dataModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataModelList;
    }

    /**
     * 获得表里的属性
     * @param con
     * @param tableName
     * @param tableComment
     * @param basePackage
     * @param tablePrefix
     * @return
     * @throws Exception
     */
    private static EntityDataModel getEntityModel(Connection con, String tableName,String tableComment, String basePackage, String tablePrefix)
            throws Exception {

        //查询表属性,格式化生成实体所需属性
        String sql = "SELECT table_name, column_name, column_comment, column_type, column_key, column_default "
                + "FROM INFORMATION_SCHEMA. COLUMNS " + "WHERE table_name = '" + tableName + "' ";

        log.info("sql {}",sql);

        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<Column> columns = new ArrayList<>();
        while (rs.next()) {
            Column col = new Column();
            String name = rs.getString("column_name");
            String type = rs.getString("column_type");
            String comment = rs.getString("column_comment");
            String annotation = null;

            col.setName(name);
            col.setType(type);
            col.setAnnotation(annotation);
            col.setComment(comment);
            columns.add(col);
        }
        EntityDataModel dataModel = new EntityDataModel();
        dataModel.setBasePackage(basePackage);
        dataModel.setCreateTime(new Date().toString());
        if (StrUtil.isNotBlank(tablePrefix)) {
            dataModel.setEntityName(StrUtil.upperFirst(StrUtil.toCamelCase(StrUtil.removePrefix(tableName, tablePrefix))));
        } else {
            dataModel.setEntityName(StrUtil.upperFirst(StrUtil.toCamelCase(tableName)));
        }
        dataModel.setTableName(tableName);
        dataModel.setColumns(columns);
        dataModel.setTableComment(tableComment);
        return dataModel;
    }

    /**
     * 创建文件夹目录
     * @param dirPackage
     */
    public static void createDir(String dirPackage) {
        try {
            String dir = null;

            if (StrUtil.isBlank(dir)) {
                dir = path + "/src/main/java/" +dirPackage.replace(".", "/");
            }

            log.info("dir: {}",dir);
            if (!FileUtil.exist(dir)) {
                FileUtil.mkdir(dir);
                log.info("创建目录：{} 成功！ ", dir);
            }
        }catch (Exception e){
            log.info("创建目录错误：{}",e.getMessage());
        }
    }

    /**
     * 创建文件
     * @param entityModel
     * @param packageDataModel
     * @throws IOException
     * @throws TemplateException
     */
    public static void createFile(EntityDataModel entityModel, PackageDataModel packageDataModel) throws IOException, TemplateException {
        //生成每个表实体
        String temporaryPath = null;
        //根据实体包名创建目录
        temporaryPath = path + "/src/main/java/" + packageDataModel.getPackageName().replace(".", "/");
        if (!FileUtil.exist(temporaryPath)) {
            FileUtil.mkdir(temporaryPath);
            log.info("创建目录：{} 成功！ ",temporaryPath);
        }
        generateCode(entityModel, packageDataModel);
    }

    /**
     * 渲染模板
     * @param dataModel*
     * @param packageDataModel
     * @throws IOException
     * @throws TemplateException
     */
    private static void generateCode(EntityDataModel dataModel, PackageDataModel packageDataModel)
            throws IOException, TemplateException {
        //获取文件绝对路径
        String file = path+ "/src/main/java/"+packageDataModel.getPackageName().replace(".","/") +"/"+dataModel.getEntityName()+packageDataModel.getFileSuffix();
        if("Mapper".equals(packageDataModel.getFileSuffix())){
            file = file + ".xml";
        }else{
            file = file + dataModel.getFileSuffix();
        }
        if (FileUtil.exist(file)){
            log.info("文件：{} 已存在，如需覆盖请先对该文件进行");
            return;
        }
        //获取模板对象
        Configuration conf = new Configuration();
        File temp = new File(templatePath);
        conf.setDirectoryForTemplateLoading(temp);
        Template template = conf.getTemplate(packageDataModel.getTemplateName());
        Writer writer = new FileWriter(file);
        //填充数据模型
        template.process(dataModel, writer);
        writer.close();
        log.info("代码生成成功，文件位置：{}",file);
    }

}


package com.example.demo.util;

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

    /**
     * 生成三层代码 包含 仅生成dao层 （包含实体Entity及mapper接口及xml） 生成service层 （包含service接口及impl） 生成controller层
     *
     * @param driver
     * @param url
     * @param user
     * @param pwd
     */
    public static void generatorMvcCode(String driver, String url, String user, String pwd, String tableName
                                        , String databaseName, String tablePrefix, int generateLevel,String beanPackage
                                        , String daoPackage, String xmlDir, String servicePackage, String serviceImplPackage,
                                        String controllerPackage,String basePackage) {

        //获取当前项目路径
        String path = FreeMarkerGeneratorUtil.class.getResource("/").getPath();
        path = StrUtil.sub(path, 1, path.indexOf("/target"));

        log.info("当前项目路径为：{}", path);
        String parentProjectPath = StrUtil.sub(path, 0, path.lastIndexOf("/"));
        //获取模板路径
        String templatePath = path + "/src/main/resources/template";
        log.info("当前模板路径为：{}", templatePath);

        boolean onlySingleTable = StrUtil.isNotBlank(tableName);

        //获取tableModel
        List<EntityDataModel> dataModelList = getDataModel(driver, url, user, pwd, databaseName, onlySingleTable);
        //包名
        List<String> dirPackage = new ArrayList<>();
        dirPackage.add(beanPackage);
        dirPackage.add(daoPackage);
        dirPackage.add(xmlDir);
        dirPackage.add(serviceImplPackage);
        dirPackage.add(controllerPackage);

        for(String item : dirPackage){
            createFile(parentProjectPath,path,basePackage,item);
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
     * @param onlySingleTable
     * @return
     */
    public static List<EntityDataModel> getDataModel(String driver, String url, String user, String pwd, String databaseName, boolean onlySingleTable) {
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

        //查询dbName所有表
        String sql = "select table_name,table_comment from information_schema.tables where table_schema='" + databaseName + "'";

        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (!onlySingleTable) {
                    EntityDataModel dataModel = new EntityDataModel();
                    dataModel.setTableName(rs.getString(1));
                    dataModel.setTableComment(rs.getString(2));
                    dataModelList.add(dataModel);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataModelList;
    }

    public static void createFile(String parentProjectPath, String path, String basePackage, String dirPackage) {
        try {
            String dir = null;
            //根据实体包名创建目录
            File[] ls = FileUtil.ls(parentProjectPath);
            for (File f : ls) {
                String currModule = f.toString();
                //boolean matches = currModule.matches("(.*?pojo.*?)|(.*?domain.*?)|(.*?entity.*?)");
                if (f.isDirectory()) {
                    dir = f.toString() + "/src/main/java/" + basePackage+dirPackage.replace(".", "/");
                    break;
                }
            }
            if (StrUtil.isBlank(dir)) {
                dir = path + "/src/main/java/" + basePackage+dirPackage.replace(".", "/");
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
}
            //EntityDataModel entityModel = getEntityModel(con, tableName,tableComment, basePackage, tablePrefix,packageName);
            //生成每个表实体
            //generateCode(entityModel, templatePath, "Entity.ftl", entityDir,"");
//
//                //创建dao 和mapper.xml文件
//                String mapperxmlPath = null;
//                //根据实体包名创建目录
//                if (StrUtil.isNotBlank(daoPackage)) {
//                    mapperxmlPath = path + "/src/main/java/" + daoPackage.replace(".", "/");
//                    if (!FileUtil.exist(mapperxmlPath)) {
//                        FileUtil.mkdir(mapperxmlPath);
//                        log.info("创建目录：{} 成功！ ",daoPackage);
//                    }
//                } else {
//                    mapperxmlPath = entityDir;
//                }
//                generateCode(entityModel,templatePath,"Dao.ftl",mapperxmlPath,"Dao");
//
//                //创建mapper包名
//                String xmlPath = null;
//                //根据实体包名创建目录
//                if (StrUtil.isNotBlank(xmlDir)) {
//                    xmlPath = path + "/src/main/resources/" + xmlDir.replace(".", "/");
//                    if (!FileUtil.exist(xmlPath)) {
//                        FileUtil.mkdir(xmlPath);
//                        log.info("创建目录：{} 成功！ ",xmlDir);
//                    }
//                } else {
//                    xmlPath = entityDir;
//                }
//                generateCode(entityModel,templatePath,"Mapper.ftl",xmlPath,"Mapper");
//
//
//                //创建service包名
//                String servicePath = null;
//                //根据实体包名创建目录
//                if (StrUtil.isNotBlank(servicePackage)) {
//                    servicePath = path + "/src/main/java/" + servicePackage.replace(".", "/");
//                    if (!FileUtil.exist(servicePath)) {
//                        FileUtil.mkdir(servicePath);
//                        log.info("创建目录：{} 成功！ ",servicePackage);
//                    }
//                } else {
//                    servicePath = entityDir;
//                }
//                generateCode(entityModel,templatePath,"Service.ftl",servicePath,"Service");
//
//                //创建serviceImpl包名
//                String serviceImplPath = null;
//                //根据实体包名创建目录
//                if (StrUtil.isNotBlank(serviceImplPackage)) {
//                    serviceImplPath = path + "/src/main/java/" + serviceImplPackage.replace(".", "/");
//                    if (!FileUtil.exist(serviceImplPath)) {
//                        FileUtil.mkdir(serviceImplPath);
//                        log.info("创建目录：{} 成功！ ",serviceImplPackage);
//                    }
//                } else {
//                    serviceImplPath = entityDir;
//                }
//                generateCode(entityModel,templatePath,"ServiceImpl.ftl",serviceImplPath,"ServiceImpl");
//                //创建controller包名
//                String controllerPath = null;
//                //根据实体包名创建目录
//                if (StrUtil.isNotBlank(controllerPackage)) {
//                    controllerPath = path + "/src/main/java/" + controllerPackage.replace(".", "/");
//                    if (!FileUtil.exist(controllerPath)) {
//                        FileUtil.mkdir(controllerPath);
//                        log.info("创建目录：{} 成功！ ",controllerPackage);
//                    }
//                } else {
//                    controllerPath = entityDir;
//                }
//                generateCode(entityModel,templatePath,"Controller.ftl",controllerPath,"Controller");
//            }
//
//        } catch (Exception e) {
//            log.error("代码生成出错 {}", e.getMessage());
//        }
//
//    }
//
//    private static EntityDataModel getEntityModel(Connection con, String tableName,String tableComment, String basePackage, String tablePrefix,String packageName)
//            throws Exception {
//        //查询表属性,格式化生成实体所需属性
//        String sql = "SELECT table_name, column_name, column_comment, column_type, column_key, column_default "
//                + "FROM INFORMATION_SCHEMA. COLUMNS " + "WHERE table_name = '" + tableName + "' ";
//                //+ "AND table_schema = 'kichun_dev'";
//
//        PreparedStatement ps = con.prepareStatement(sql);
//        ResultSet rs = ps.executeQuery();
//
//        List<Column> columns = new ArrayList<>();
//        while (rs.next()) {
//            Column col = new Column();
//            String name = rs.getString("column_name");
//            String type = rs.getString("column_type");
//            String comment = rs.getString("column_comment");
//            String annotation = null;
//
//            col.setName(name);
//            col.setType(type);
//            col.setAnnotation(annotation);
//            col.setComment(comment);
//            columns.add(col);
//        }
//        EntityDataModel dataModel = new EntityDataModel();
//        dataModel.setPackageName(packageName);
//        dataModel.setEntityPackage(basePackage);
//        dataModel.setCreateTime(new Date().toString());
//        if (StrUtil.isNotBlank(tablePrefix)) {
//            dataModel.setEntityName(StrUtil.upperFirst(StrUtil.toCamelCase(StrUtil.removePrefix(tableName, tablePrefix))));
//        } else {
//            dataModel.setEntityName(StrUtil.upperFirst(StrUtil.toCamelCase(tableName)));
//        }
//        dataModel.setTableName(tableName);
//        dataModel.setColumns(columns);
//        dataModel.setTableComment(tableComment);
//        return dataModel;
//    }
//
//    private static void generateCode(EntityDataModel dataModel, String templatePath, String templateName, String outDir,String typeName)
//            throws IOException, TemplateException {
//        String file = "";
//        if("Mapper".equals(typeName)){
//            file = outDir +"/"+ dataModel.getEntityName()+ typeName + ".xml";
//        }else{
//            file = outDir +"/"+ dataModel.getEntityName()+ typeName + dataModel.getFileSuffix();
//        }
//
//
//        System.out.println(file);
//        if (FileUtil.exist(file)){
//            log.info("文件：{} 已存在，如需覆盖请先对该文件进行");
//            return;
//        }
//        //获取模板对象
//        Configuration conf = new Configuration();
//        File temp = new File(templatePath);
//        conf.setDirectoryForTemplateLoading(temp);
//        Template template = conf.getTemplate(templateName);
//        Writer writer = new FileWriter(file);
//        //填充数据模型
//        template.process(dataModel, writer);
//        writer.close();
//        log.info("代码生成成功，文件位置：{}",file);
//    }
//}

package generator.example.demo;

import generator.example.demo.util.FreeMarkerGeneratorUtil;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@PropertySource("classpath:jdbc.properties")
@SpringBootTest
@Slf4j
public class codeGenerator {

    /**
     * 数据库驱动
     */
    //@Value("${driverClassName}")
    private String driverClassName = "com.mysql.cj.jdbc.Driver";

    /**
     * 数据库Url
     */
    //@Value("${url}")
    private String url = "jdbc:mysql://192.168.60.205/questionnaire?useUnicode=true&characterEncoding=UTF-8";

    /**
     * 账号
     */
    //@Value("${username}")
    private String username = "root";

    /**
     * 密码
     */
    //@Value("${password}")
    private String password = "123456";

    /**
     * 数据库名称
     */
    private String databaseName = "questionnaire";

    /**
     * 表名（非必需）
     */
    private String tableName = "admin";

    /**
     * 表前缀
     */
    private String tablePrefix = "";

    /**
     * 生成级别
     * 1.dao
     * 2.service
     * 3.controller
     */
    private int genneratorLevel = 1;

    private String basePackage = "com.dm.example";

    /**
     * 实体类包名
     */
    private String beanPackage= ".bean";

    /**
     * dao接口包名 无则使用基本包名
     */
    private String daoPackage = ".dao";

    /**
     * mapper.xml 生成路径 无则使用基本包名
     */
    private String xmlDir = ".mapper";

    /**
     * servcie包名 impl也在此包路径下 无则使用基本包名
     */
    private String servicePackage = ".service";

    private String serviceImplPackage = ".service.impl";

    /**
     * controller包名 无则使用基本包名
     */
    private String controllerPackage = ".controller";


    @Test
    public void freeMarkerTest() throws IOException, TemplateException {
        FreeMarkerGeneratorUtil.generatorMvcCode(
                driverClassName,
                url,
                username,
                password,
                tableName,
                databaseName,
                tablePrefix,
                beanPackage,
                daoPackage,
                xmlDir,
                servicePackage,
                serviceImplPackage,
                controllerPackage,
                basePackage
        );
    }



}

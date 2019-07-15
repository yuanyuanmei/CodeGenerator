package generator.example.demo.util;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class EntityDataModel {

//    /**
//     * packgaeName
//     */
//    private String packageName;
    /**
     * base package
     */
    private String basePackage;
    /**
     * 文件名后缀
     */
    private String fileSuffix = ".java";

    /**
     * 实体名
     */
    private String entityName;

    /**
     * 作者 默认
     */
    private String author="WangGM";

    /**
     * 创建时间
     */
    private String createTime = new Date().toString();

    /**
     * 表名
     */
    private String tableName;

    /**
     * 表注释
     */
    private String tableComment;

    /**
     * 字段集合
     */
    private List<Column> columns;

}

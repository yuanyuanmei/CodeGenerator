package com.example.demo.util;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Column {

    // 名称
    private String name ;

    // 类型
    private String type ;

    // 属性注解
    private String annotation;

    //属性注释
    private String comment;

    //实体类类型;
    private String beanType;

    //实体类列名;
    private String beanName;

    public String getBeanType(){
        if (type.contains("varchar")) {
            beanType = "String";
        } else if (type.contains("datetime") || type.contains("date")) {
            beanType = "Date";
        } else if (type.contains("int") || type.contains("INT UNSIGNED")) {
            beanType = "Integer";
        }else if (type.contains("DECIMAL")) {
                beanType = "BigDecimal";
        } else {
            beanType = "String";
        }
        return beanType;
    }

    public String getBeanName(){

        if(("is").equals(name.substring(0,2))){
            beanName = name.substring(3,name.length())+"Status";
        }else{
            beanName = StrUtil.toCamelCase(name);
        }
        return beanName;
    }
}

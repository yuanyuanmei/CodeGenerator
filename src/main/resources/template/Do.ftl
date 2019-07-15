package ${basePackage}.bean;

import ${basePackage}.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


/**
* ${entityName} 实体类
* Created by ${author} on ${createTime}.
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ${entityName}Do extends BaseEntity{
<#list columns as column>
    <#if column.name != 'id' && column.name != 'is_delete' && column.name != 'create_time' && column.name != 'update_time' >
        <#if column.comment != ''>
        /**
        * ${(column.comment)!}
        */
        </#if>
        private ${column.beanType} ${column.beanName};
    </#if>
</#list>
}

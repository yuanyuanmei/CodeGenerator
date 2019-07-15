<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${basePackage}.dao.${entityName}Dao">
    <resultMap id="BaseMap" type="${basePackage}.bean.${entityName}">
    </resultMap>

    <sql id="BaseColumns">
        <#list columns as column>${column.name}<#if column_has_next>,</#if></#list>
    </sql>

    <select id="selectByPrimaryKey" resultMap="BaseMap" parameterType="java.lang.Integer">
        select
        <include refid="BaseColumns"/>
        from ${tableName}
        <where>
            id = <#noparse>#</#noparse>{id}
        </where>
    </select>

    <select id="list" resultMap="BaseMap" parameterType="${entityName}">
        select
        <include refid="BaseColumns"/>
        from ${tableName}
    </select>

    <insert id="insert" parameterType="${entityName}" keyProperty="id" useGeneratedKeys="true">
        insert into ${tableName}
        <trim prefix="(" suffix=")" suffixOverrides="," >
        <#list columns as column>
            <if test="${column.beanName} != null">
                ${column.name},
            </if>
        </#list>
        </trim>
        values
        <trim prefix="(" suffix=")" suffixOverrides="," >
        <#list columns as column>
            <if test="${column.beanName} != null">
                <#noparse>#</#noparse>{${column.beanName}},
            </if>
        </#list>
        </trim>
    </insert>

    <update id="update" parameterType="${entityName}">
        update ${tableName}
        <set>
            <#list columns as column>
            <if test="${column.beanName} != null">
                ${column.name} = <#noparse>#</#noparse>{${column.beanName}},
            </if>
            </#list>
        </set>
        where id = <#noparse>#</#noparse>{id}
    </update>

    <update id="delete" parameterType="java.lang.Long">
        update ${tableName} set is_delete = 2
        <where>
            id = <#noparse>#</#noparse>{id}
        </where>
    </update>
</mapper>

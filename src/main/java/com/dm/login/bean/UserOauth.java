package com.dm.login.bean;

import com.dm.login.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


/**
* UserOauth 实体类
* Created by auto generator on Sun May 12 19:52:32 CST 2019.
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserOauth extends BaseEntity{
        /**
        * 名称
        */
        private String name;
        /**
        * 接口验证ID
        */
        private String appId;
        /**
        * 接口验证key
        */
        private String appKey;
        /**
        * 验证码
        */
        private String code;
}
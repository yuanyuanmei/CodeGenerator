package com.dm.login.bean;

import com.dm.login.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


/**
* UserAccount 实体类
* Created by auto generator on Sun May 12 19:52:32 CST 2019.
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserAccount extends BaseEntity{
        /**
        * 关联用户ID
        */
        private Integer usrId;
        /**
        * 账号
        */
        private String account;
        /**
        * 密码
        */
        private String password;
        /**
        * 加盐次数
        */
        private String salt;
        /**
        * 明文密码
        */
        private String openPwd;
        /**
        * 最后一次登录IP
        */
        private String lastLoginIp;
        /**
        * 最后一次登录时间
        */
        private Date lastLoginTime;
}
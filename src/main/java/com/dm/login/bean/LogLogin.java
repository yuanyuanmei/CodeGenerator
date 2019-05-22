package com.dm.login.bean;

import com.dm.login.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


/**
* LogLogin 实体类
* Created by auto generator on Sun May 12 19:52:32 CST 2019.
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LogLogin extends BaseEntity{
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
        * 登录时间
        */
        private Date loginTime;
        /**
        * 登录IP
        */
        private String loginIp;
        /**
        * 登录类型
        */
        private Integer loginType;
        /**
        * 登录状态(1.成功,2.失败)
        */
        private Integer successStatus;
        /**
        * 备注
        */
        private String note;
}
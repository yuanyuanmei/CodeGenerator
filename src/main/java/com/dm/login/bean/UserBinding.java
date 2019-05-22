package com.dm.login.bean;

import com.dm.login.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


/**
* UserBinding 实体类
* Created by auto generator on Sun May 12 19:52:32 CST 2019.
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserBinding extends BaseEntity{
        private Integer usrId;
        private Integer oauthId;
        /**
        * 第三方唯一ID
        */
        private String openid;
        /**
        * 第三方昵称
        */
        private String openname;
        /**
        * 公众号ID
        */
        private String unionId;
        private String lastLoginIp;
        private Date lastLoginTime;
}
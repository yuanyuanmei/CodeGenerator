package com.dm.login.bean;

import com.dm.login.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


/**
* SendMsg 实体类
* Created by auto generator on Sun May 12 19:52:32 CST 2019.
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SendMsg extends BaseEntity{
        private Integer usrId;
        /**
        * 发送对象(手机号码或邮箱)
        */
        private String item;
        /**
        * 对象类型
        */
        private Integer type;
        /**
        * 发送信息
        */
        private String msg;
        /**
        * 验证码
        */
        private String code;
        /**
        * 过期时间
        */
        private Date expiresTime;
        /**
        * 发送状态(1.成功2.失败)
        */
        private Integer successStatus;
        /**
        * 备注
        */
        private String note;
}
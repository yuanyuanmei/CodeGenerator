package com.dm.login.bean;

import com.dm.login.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


/**
* UserSecurity 实体类
* Created by auto generator on Sun May 12 19:52:32 CST 2019.
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserSecurity extends BaseEntity{
        /**
        * 关联用户ID
        */
        private Integer usrId;
        /**
        * 第一个问题
        */
        private String questionFirst;
        /**
        * 第一个答案
        */
        private String answerFirst;
        /**
        * 第二个问题
        */
        private String questionSecond;
        /**
        * 第二个答案
        */
        private String answerSecond;
        /**
        * 第三个问题
        */
        private String questionThird;
        /**
        * 第三个答案
        */
        private String answerThird;
}
package com.dm.login.bean;

import com.dm.login.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


/**
* UserPersonal 实体类
* Created by auto generator on Sun May 12 19:52:32 CST 2019.
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserPersonal extends BaseEntity{
        /**
        * 关联用户ID
        */
        private Integer usrId;
        /**
        * 姓名
        */
        private String name;
        /**
        * 性别 1.男 2.女
        */
        private Integer sex;
        /**
        * 生日
        */
        private Date birth;
        /**
        * 毕业院校
        */
        private String school;
        /**
        * 学历 1.高中 2.中专 3.大专 4.本科 5.

硕士 6.博士
        */
        private Integer education;
        /**
        * 籍贯
        */
        private String nativePlace;
        /**
        * 现居地
        */
        private String nowIn;
        /**
        * 意向工作
        */
        private String intentionJob;
        /**
        * 意向地区
        */
        private String 
intentionArea;
        /**
        * 期望薪资
        */
        private String 
intentionSalary;
        /**
        * 自我介绍
        */
        private String introduce;
        /**
        * 所属公司
        */
        private String companyName;
        /**
        * 职位名称
        */
        private String position;
        /**
        * 工作描述
        */
        private String jobDescription;
        /**
        * 职位薪资
        */
        private String jobSalary;
        /**
        * 在职时间
        */
        private Date jobTime;
}
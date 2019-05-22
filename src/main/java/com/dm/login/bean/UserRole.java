package com.dm.login.bean;

import com.dm.login.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


/**
* UserRole 实体类
* Created by auto generator on Sun May 12 19:52:32 CST 2019.
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRole extends BaseEntity{
        private Integer uid;
        private Integer roleId;
}
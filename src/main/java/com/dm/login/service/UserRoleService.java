package com.dm.login.service;

import com.dm.login.bean.UserRole;
import com.alibaba.fastjson.JSONObject;

public interface UserRoleService{
    JSONObject selectByPrimaryKey(Integer id);

    JSONObject delete(Integer id);

    JSONObject insert(UserRole t);

    JSONObject update(UserRole t);

    JSONObject list(UserRole t);

    JSONObject getCount(UserRole t);
}
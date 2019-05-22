package com.dm.login.service;

import com.dm.login.bean.UserSecurity;
import com.alibaba.fastjson.JSONObject;

public interface UserSecurityService{
    JSONObject selectByPrimaryKey(Integer id);

    JSONObject delete(Integer id);

    JSONObject insert(UserSecurity t);

    JSONObject update(UserSecurity t);

    JSONObject list(UserSecurity t);

    JSONObject getCount(UserSecurity t);
}
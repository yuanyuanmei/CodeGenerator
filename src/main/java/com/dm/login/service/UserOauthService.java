package com.dm.login.service;

import com.dm.login.bean.UserOauth;
import com.alibaba.fastjson.JSONObject;

public interface UserOauthService{
    JSONObject selectByPrimaryKey(Integer id);

    JSONObject delete(Integer id);

    JSONObject insert(UserOauth t);

    JSONObject update(UserOauth t);

    JSONObject list(UserOauth t);

    JSONObject getCount(UserOauth t);
}
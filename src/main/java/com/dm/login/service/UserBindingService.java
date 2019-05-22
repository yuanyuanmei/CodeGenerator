package com.dm.login.service;

import com.dm.login.bean.UserBinding;
import com.alibaba.fastjson.JSONObject;

public interface UserBindingService{
    JSONObject selectByPrimaryKey(Integer id);

    JSONObject delete(Integer id);

    JSONObject insert(UserBinding t);

    JSONObject update(UserBinding t);

    JSONObject list(UserBinding t);

    JSONObject getCount(UserBinding t);
}
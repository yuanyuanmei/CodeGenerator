package com.dm.login.service;

import com.dm.login.bean.LogLogin;
import com.alibaba.fastjson.JSONObject;

public interface LogLoginService{
    JSONObject selectByPrimaryKey(Integer id);

    JSONObject delete(Integer id);

    JSONObject insert(LogLogin t);

    JSONObject update(LogLogin t);

    JSONObject list(LogLogin t);

    JSONObject getCount(LogLogin t);
}
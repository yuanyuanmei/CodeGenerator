package com.dm.login.service;

import com.dm.login.bean.SendMsg;
import com.alibaba.fastjson.JSONObject;

public interface SendMsgService{
    JSONObject selectByPrimaryKey(Integer id);

    JSONObject delete(Integer id);

    JSONObject insert(SendMsg t);

    JSONObject update(SendMsg t);

    JSONObject list(SendMsg t);

    JSONObject getCount(SendMsg t);
}
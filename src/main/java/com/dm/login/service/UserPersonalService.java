package com.dm.login.service;

import com.dm.login.bean.UserPersonal;
import com.alibaba.fastjson.JSONObject;

public interface UserPersonalService{
    JSONObject selectByPrimaryKey(Integer id);

    JSONObject delete(Integer id);

    JSONObject insert(UserPersonal t);

    JSONObject update(UserPersonal t);

    JSONObject list(UserPersonal t);

    JSONObject getCount(UserPersonal t);
}
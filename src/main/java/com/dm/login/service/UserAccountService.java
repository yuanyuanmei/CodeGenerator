package com.dm.login.service;

import com.dm.login.bean.UserAccount;
import com.alibaba.fastjson.JSONObject;

public interface UserAccountService{
    JSONObject selectByPrimaryKey(Integer id);

    JSONObject delete(Integer id);

    JSONObject insert(UserAccount t);

    JSONObject update(UserAccount t);

    JSONObject list(UserAccount t);

    JSONObject getCount(UserAccount t);
}
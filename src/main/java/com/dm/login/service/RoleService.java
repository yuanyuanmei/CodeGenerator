package com.dm.login.service;

import com.dm.login.bean.Role;
import com.alibaba.fastjson.JSONObject;

public interface RoleService{
    JSONObject selectByPrimaryKey(Integer id);

    JSONObject delete(Integer id);

    JSONObject insert(Role t);

    JSONObject update(Role t);

    JSONObject list(Role t);

    JSONObject getCount(Role t);
}
package com.dm.login.service;

import com.dm.login.bean.Permission;
import com.alibaba.fastjson.JSONObject;

public interface PermissionService{
    JSONObject selectByPrimaryKey(Integer id);

    JSONObject delete(Integer id);

    JSONObject insert(Permission t);

    JSONObject update(Permission t);

    JSONObject list(Permission t);

    JSONObject getCount(Permission t);
}
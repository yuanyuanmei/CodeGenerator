package com.dm.login.base;

import com.alibaba.fastjson.JSONObject;

public interface BaseService<T> {
    JSONObject selectByPrimaryKey(Integer id);

    JSONObject delete(Integer id);

    JSONObject insert(T t);

    JSONObject update(T t);

    JSONObject list(T t);

    JSONObject getCount(T t);
}

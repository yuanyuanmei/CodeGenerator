package com.example.demo.base;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BaseService<T> {
    JSONObject selectByPrimaryKey(Integer id);

    JSONObject delete(Integer id);

    JSONObject insert(T t);

    JSONObject update(T t);

    JSONObject list(T t);

    JSONObject getCount(T t);
}

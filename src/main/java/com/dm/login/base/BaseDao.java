package com.dm.login.base;

import java.util.List;

public interface BaseDao<T> {

    T selectByPrimaryKey(Integer id);

    Integer delete(Integer id);

    Integer insert(T t);

    Integer update(T t);

    List<T> list(T t);

    int getCount(T t);

}

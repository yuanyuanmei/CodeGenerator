package com.example.demo.base;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private BaseDao<T> baseDao;

    @Override
    public JSONObject selectByPrimaryKey(Integer id){
        JSONObject jsonObject = new JSONObject();
        if(baseDao.selectByPrimaryKey(id) != null){
            jsonObject.put("msg","查询成功");
            jsonObject.put("info",baseDao.selectByPrimaryKey(id));
            return jsonObject;
        }
        return null;
    }

    @Override
    public JSONObject delete(Integer id){
        if(baseDao.delete(id)>0){
            return JSONObject.parseObject("删除成功");
        }
        return JSONObject.parseObject("删除失败");
    }

    @Override
    public JSONObject insert(T t){
        JSONObject jsonObject = new JSONObject();
        if(baseDao.insert(t)>0){
            jsonObject.put("msg","新增成功");
            jsonObject.put("info",t);
            return jsonObject;
        }
        return JSONObject.parseObject("新增失败");
    }

    @Override
    public JSONObject update(T t){
        JSONObject jsonObject = new JSONObject();
        if(baseDao.update(t)>0){
            jsonObject.put("msg","更新成功");
            jsonObject.put("info",t);
            return jsonObject;
        }
        return JSONObject.parseObject("更新失败");
    }

    @Override
    public JSONObject list(T t){
        JSONObject jsonObject = new JSONObject();
        if(baseDao.list(t) != null){
            jsonObject.put("msg","查询成功");
            jsonObject.put("info",baseDao.list(t));
            return jsonObject;
        }
        return null;
    }

    @Override
    public JSONObject getCount(T t){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg","查询成功");
        jsonObject.put("info",baseDao.getCount(t));
        return jsonObject;
    }

}

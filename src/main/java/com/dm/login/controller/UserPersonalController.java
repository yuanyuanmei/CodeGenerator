package com.dm.login.controller;
import com.dm.login.bean.UserPersonal;
import com.dm.login.service.UserPersonalService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "UserPersonal",description = "个人信息表")
@RestController
@RequestMapping("/UserPersonal")
public class UserPersonalController{

    @Autowired
    private UserPersonalService UserPersonalService;

    @ApiOperation(value = "个人信息表集合",notes = "可添加筛选条件")
    @GetMapping("/list")
    public JSONObject list(String jsonInfo){
    JSONObject jsonObject = JSONObject.parseObject(jsonInfo);
    return UserPersonalService.list(JSON.toJavaObject(jsonObject,UserPersonal.class));
    }

    @ApiOperation(value = "根据个人信息表ID查询")
    @ApiImplicitParam(name = "id",value = "id",required = true,dataType = "Integer",paramType = "path")
    @GetMapping("/{id}")
    public JSONObject get(@PathVariable(name = "id") Integer id){
    return UserPersonalService.selectByPrimaryKey(Integer.valueOf(id));
    }

    @ApiOperation(value = "根据个人信息表ID删除")
    @ApiImplicitParam(name = "id",value = "id",required = true,dataType = "Integer",paramType = "path")
    @DeleteMapping("/{id}")
    public JSONObject delete(@PathVariable(name = "id") Integer id){
    return UserPersonalService.delete(Integer.valueOf(id));
    }

    @ApiOperation(value = "添加记录")
    @ApiImplicitParam(name = "jsonInfo",value = "个人信息表json对象",required = true,dataType = "json",paramType = "path")
    @PostMapping("/add")
    public JSONObject add(String jsonInfo){
    JSONObject jsonObject = JSONObject.parseObject(jsonInfo);
    return UserPersonalService.insert(JSON.toJavaObject(jsonObject,UserPersonal.class));
    }

    @ApiOperation(value = "修改记录")
    @ApiImplicitParam(name = "jsonInfo",value = "个人信息表json对象",required = true,dataType = "json",paramType = "path")
    @PutMapping("/upd")
    public JSONObject upd(String jsonInfo){
    JSONObject jsonObject = JSONObject.parseObject(jsonInfo);
    return UserPersonalService.update(JSON.toJavaObject(jsonObject,UserPersonal.class));
    }


}

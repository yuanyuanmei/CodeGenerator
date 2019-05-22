package com.dm.login.controller;
import com.dm.login.bean.UserOauth;
import com.dm.login.service.UserOauthService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "UserOauth",description = "用户授权表")
@RestController
@RequestMapping("/UserOauth")
public class UserOauthController{

    @Autowired
    private UserOauthService UserOauthService;

    @ApiOperation(value = "用户授权表集合",notes = "可添加筛选条件")
    @GetMapping("/list")
    public JSONObject list(String jsonInfo){
    JSONObject jsonObject = JSONObject.parseObject(jsonInfo);
    return UserOauthService.list(JSON.toJavaObject(jsonObject,UserOauth.class));
    }

    @ApiOperation(value = "根据用户授权表ID查询")
    @ApiImplicitParam(name = "id",value = "id",required = true,dataType = "Integer",paramType = "path")
    @GetMapping("/{id}")
    public JSONObject get(@PathVariable(name = "id") Integer id){
    return UserOauthService.selectByPrimaryKey(Integer.valueOf(id));
    }

    @ApiOperation(value = "根据用户授权表ID删除")
    @ApiImplicitParam(name = "id",value = "id",required = true,dataType = "Integer",paramType = "path")
    @DeleteMapping("/{id}")
    public JSONObject delete(@PathVariable(name = "id") Integer id){
    return UserOauthService.delete(Integer.valueOf(id));
    }

    @ApiOperation(value = "添加记录")
    @ApiImplicitParam(name = "jsonInfo",value = "用户授权表json对象",required = true,dataType = "json",paramType = "path")
    @PostMapping("/add")
    public JSONObject add(String jsonInfo){
    JSONObject jsonObject = JSONObject.parseObject(jsonInfo);
    return UserOauthService.insert(JSON.toJavaObject(jsonObject,UserOauth.class));
    }

    @ApiOperation(value = "修改记录")
    @ApiImplicitParam(name = "jsonInfo",value = "用户授权表json对象",required = true,dataType = "json",paramType = "path")
    @PutMapping("/upd")
    public JSONObject upd(String jsonInfo){
    JSONObject jsonObject = JSONObject.parseObject(jsonInfo);
    return UserOauthService.update(JSON.toJavaObject(jsonObject,UserOauth.class));
    }


}

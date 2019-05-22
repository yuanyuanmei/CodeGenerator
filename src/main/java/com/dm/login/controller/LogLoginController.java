package com.dm.login.controller;
import com.dm.login.bean.LogLogin;
import com.dm.login.service.LogLoginService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "LogLogin",description = "")
@RestController
@RequestMapping("/LogLogin")
public class LogLoginController{

    @Autowired
    private LogLoginService LogLoginService;

    @ApiOperation(value = "集合",notes = "可添加筛选条件")
    @GetMapping("/list")
    public JSONObject list(String jsonInfo){
    JSONObject jsonObject = JSONObject.parseObject(jsonInfo);
    return LogLoginService.list(JSON.toJavaObject(jsonObject,LogLogin.class));
    }

    @ApiOperation(value = "根据ID查询")
    @ApiImplicitParam(name = "id",value = "id",required = true,dataType = "Integer",paramType = "path")
    @GetMapping("/{id}")
    public JSONObject get(@PathVariable(name = "id") Integer id){
    return LogLoginService.selectByPrimaryKey(Integer.valueOf(id));
    }

    @ApiOperation(value = "根据ID删除")
    @ApiImplicitParam(name = "id",value = "id",required = true,dataType = "Integer",paramType = "path")
    @DeleteMapping("/{id}")
    public JSONObject delete(@PathVariable(name = "id") Integer id){
    return LogLoginService.delete(Integer.valueOf(id));
    }

    @ApiOperation(value = "添加记录")
    @ApiImplicitParam(name = "jsonInfo",value = "json对象",required = true,dataType = "json",paramType = "path")
    @PostMapping("/add")
    public JSONObject add(String jsonInfo){
    JSONObject jsonObject = JSONObject.parseObject(jsonInfo);
    return LogLoginService.insert(JSON.toJavaObject(jsonObject,LogLogin.class));
    }

    @ApiOperation(value = "修改记录")
    @ApiImplicitParam(name = "jsonInfo",value = "json对象",required = true,dataType = "json",paramType = "path")
    @PutMapping("/upd")
    public JSONObject upd(String jsonInfo){
    JSONObject jsonObject = JSONObject.parseObject(jsonInfo);
    return LogLoginService.update(JSON.toJavaObject(jsonObject,LogLogin.class));
    }


}

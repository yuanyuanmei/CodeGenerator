package com.dm.login.controller;
import com.dm.login.bean.LogOperate;
import com.dm.login.service.LogOperateService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "LogOperate",description = "用户操作日志表")
@RestController
@RequestMapping("/LogOperate")
public class LogOperateController{

    @Autowired
    private LogOperateService LogOperateService;

    @ApiOperation(value = "用户操作日志表集合",notes = "可添加筛选条件")
    @GetMapping("/list")
    public JSONObject list(String jsonInfo){
    JSONObject jsonObject = JSONObject.parseObject(jsonInfo);
    return LogOperateService.list(JSON.toJavaObject(jsonObject,LogOperate.class));
    }

    @ApiOperation(value = "根据用户操作日志表ID查询")
    @ApiImplicitParam(name = "id",value = "id",required = true,dataType = "Integer",paramType = "path")
    @GetMapping("/{id}")
    public JSONObject get(@PathVariable(name = "id") Integer id){
    return LogOperateService.selectByPrimaryKey(Integer.valueOf(id));
    }

    @ApiOperation(value = "根据用户操作日志表ID删除")
    @ApiImplicitParam(name = "id",value = "id",required = true,dataType = "Integer",paramType = "path")
    @DeleteMapping("/{id}")
    public JSONObject delete(@PathVariable(name = "id") Integer id){
    return LogOperateService.delete(Integer.valueOf(id));
    }

    @ApiOperation(value = "添加记录")
    @ApiImplicitParam(name = "jsonInfo",value = "用户操作日志表json对象",required = true,dataType = "json",paramType = "path")
    @PostMapping("/add")
    public JSONObject add(String jsonInfo){
    JSONObject jsonObject = JSONObject.parseObject(jsonInfo);
    return LogOperateService.insert(JSON.toJavaObject(jsonObject,LogOperate.class));
    }

    @ApiOperation(value = "修改记录")
    @ApiImplicitParam(name = "jsonInfo",value = "用户操作日志表json对象",required = true,dataType = "json",paramType = "path")
    @PutMapping("/upd")
    public JSONObject upd(String jsonInfo){
    JSONObject jsonObject = JSONObject.parseObject(jsonInfo);
    return LogOperateService.update(JSON.toJavaObject(jsonObject,LogOperate.class));
    }


}

package com.dm.login.controller;
import com.dm.login.bean.SendMsg;
import com.dm.login.service.SendMsgService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "SendMsg",description = "发送信息记录表")
@RestController
@RequestMapping("/SendMsg")
public class SendMsgController{

    @Autowired
    private SendMsgService SendMsgService;

    @ApiOperation(value = "发送信息记录表集合",notes = "可添加筛选条件")
    @GetMapping("/list")
    public JSONObject list(String jsonInfo){
    JSONObject jsonObject = JSONObject.parseObject(jsonInfo);
    return SendMsgService.list(JSON.toJavaObject(jsonObject,SendMsg.class));
    }

    @ApiOperation(value = "根据发送信息记录表ID查询")
    @ApiImplicitParam(name = "id",value = "id",required = true,dataType = "Integer",paramType = "path")
    @GetMapping("/{id}")
    public JSONObject get(@PathVariable(name = "id") Integer id){
    return SendMsgService.selectByPrimaryKey(Integer.valueOf(id));
    }

    @ApiOperation(value = "根据发送信息记录表ID删除")
    @ApiImplicitParam(name = "id",value = "id",required = true,dataType = "Integer",paramType = "path")
    @DeleteMapping("/{id}")
    public JSONObject delete(@PathVariable(name = "id") Integer id){
    return SendMsgService.delete(Integer.valueOf(id));
    }

    @ApiOperation(value = "添加记录")
    @ApiImplicitParam(name = "jsonInfo",value = "发送信息记录表json对象",required = true,dataType = "json",paramType = "path")
    @PostMapping("/add")
    public JSONObject add(String jsonInfo){
    JSONObject jsonObject = JSONObject.parseObject(jsonInfo);
    return SendMsgService.insert(JSON.toJavaObject(jsonObject,SendMsg.class));
    }

    @ApiOperation(value = "修改记录")
    @ApiImplicitParam(name = "jsonInfo",value = "发送信息记录表json对象",required = true,dataType = "json",paramType = "path")
    @PutMapping("/upd")
    public JSONObject upd(String jsonInfo){
    JSONObject jsonObject = JSONObject.parseObject(jsonInfo);
    return SendMsgService.update(JSON.toJavaObject(jsonObject,SendMsg.class));
    }


}

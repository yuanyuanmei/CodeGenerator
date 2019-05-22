package com.dm.login.controller;
import com.dm.login.bean.Role;
import com.dm.login.service.RoleService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "Role",description = "")
@RestController
@RequestMapping("/Role")
public class RoleController{

    @Autowired
    private RoleService RoleService;

    @ApiOperation(value = "集合",notes = "可添加筛选条件")
    @GetMapping("/list")
    public JSONObject list(String jsonInfo){
    JSONObject jsonObject = JSONObject.parseObject(jsonInfo);
    return RoleService.list(JSON.toJavaObject(jsonObject,Role.class));
    }

    @ApiOperation(value = "根据ID查询")
    @ApiImplicitParam(name = "id",value = "id",required = true,dataType = "Integer",paramType = "path")
    @GetMapping("/{id}")
    public JSONObject get(@PathVariable(name = "id") Integer id){
    return RoleService.selectByPrimaryKey(Integer.valueOf(id));
    }

    @ApiOperation(value = "根据ID删除")
    @ApiImplicitParam(name = "id",value = "id",required = true,dataType = "Integer",paramType = "path")
    @DeleteMapping("/{id}")
    public JSONObject delete(@PathVariable(name = "id") Integer id){
    return RoleService.delete(Integer.valueOf(id));
    }

    @ApiOperation(value = "添加记录")
    @ApiImplicitParam(name = "jsonInfo",value = "json对象",required = true,dataType = "json",paramType = "path")
    @PostMapping("/add")
    public JSONObject add(String jsonInfo){
    JSONObject jsonObject = JSONObject.parseObject(jsonInfo);
    return RoleService.insert(JSON.toJavaObject(jsonObject,Role.class));
    }

    @ApiOperation(value = "修改记录")
    @ApiImplicitParam(name = "jsonInfo",value = "json对象",required = true,dataType = "json",paramType = "path")
    @PutMapping("/upd")
    public JSONObject upd(String jsonInfo){
    JSONObject jsonObject = JSONObject.parseObject(jsonInfo);
    return RoleService.update(JSON.toJavaObject(jsonObject,Role.class));
    }


}

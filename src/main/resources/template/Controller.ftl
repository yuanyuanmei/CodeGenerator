package ${packageName}.controller;
import ${packageName}.bean.${entityName};
import ${packageName}.service.${entityName}Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "${entityName}",description = "${tableComment}")
@RestController
@RequestMapping("/${entityName}")
public class ${entityName}Controller{

    @Autowired
    private ${entityName}Service ${entityName}Service;

    @ApiOperation(value = "${tableComment}集合",notes = "可添加筛选条件")
    @GetMapping("/list")
    public JSONObject list(String jsonInfo){
    JSONObject jsonObject = JSONObject.parseObject(jsonInfo);
    return ${entityName}Service.list(JSON.toJavaObject(jsonObject,${entityName}.class));
    }

    @ApiOperation(value = "根据${tableComment}ID查询")
    @ApiImplicitParam(name = "id",value = "id",required = true,dataType = "Integer",paramType = "path")
    @GetMapping("/{id}")
    public JSONObject get(@PathVariable(name = "id") Integer id){
    return ${entityName}Service.selectByPrimaryKey(Integer.valueOf(id));
    }

    @ApiOperation(value = "根据${tableComment}ID删除")
    @ApiImplicitParam(name = "id",value = "id",required = true,dataType = "Integer",paramType = "path")
    @DeleteMapping("/{id}")
    public JSONObject delete(@PathVariable(name = "id") Integer id){
    return ${entityName}Service.delete(Integer.valueOf(id));
    }

    @ApiOperation(value = "添加记录")
    @ApiImplicitParam(name = "jsonInfo",value = "${tableComment}json对象",required = true,dataType = "json",paramType = "path")
    @PostMapping("/add")
    public JSONObject add(String jsonInfo){
    JSONObject jsonObject = JSONObject.parseObject(jsonInfo);
    return ${entityName}Service.insert(JSON.toJavaObject(jsonObject,${entityName}.class));
    }

    @ApiOperation(value = "修改记录")
    @ApiImplicitParam(name = "jsonInfo",value = "${tableComment}json对象",required = true,dataType = "json",paramType = "path")
    @PutMapping("/upd")
    public JSONObject upd(String jsonInfo){
    JSONObject jsonObject = JSONObject.parseObject(jsonInfo);
    return ${entityName}Service.update(JSON.toJavaObject(jsonObject,${entityName}.class));
    }


}

package ${packageName}.service;

import ${packageName}.bean.${entityName};
import com.alibaba.fastjson.JSONObject;

public interface ${entityName}Service{
    JSONObject selectByPrimaryKey(Integer id);

    JSONObject delete(Integer id);

    JSONObject insert(${entityName} t);

    JSONObject update(${entityName} t);

    JSONObject list(${entityName} t);

    JSONObject getCount(${entityName} t);
}
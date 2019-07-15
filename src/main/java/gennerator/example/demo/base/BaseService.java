package gennerator.example.demo.base;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BaseService<T> {
    T selectByPrimaryKey(Integer id);

    int delete(Integer id);

    int insert(T t);

    int update(T t);

    List<T> list(T t);

    int getCount(T t);
}

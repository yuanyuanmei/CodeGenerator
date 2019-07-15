package gennerator.example.demo.base;

import java.util.List;

public interface BaseDao<T> {

    T selectByPrimaryKey(Integer id);

    int delete(Integer id);

    int insert(T t);

    int update(T t);

    List<T> list(T t);

    int getCount(T t);

}

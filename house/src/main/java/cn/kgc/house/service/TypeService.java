package cn.kgc.house.service;

import cn.kgc.house.entity.District;
import cn.kgc.house.entity.Type;
import cn.kgc.house.util.PageUtil;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TypeService {
    List<Type> getAllType();
    //查询所有类型支持分页
    PageInfo<Type> getTypeByPage(PageUtil pageInfo);
    int addType(String name);
    int updateType(Type type);
    int delType(Integer id);
    int delMore(Integer[] idstr);
}

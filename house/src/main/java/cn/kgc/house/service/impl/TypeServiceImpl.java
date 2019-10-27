package cn.kgc.house.service.impl;

import cn.kgc.house.entity.Type;
import cn.kgc.house.mapper.HouseMapper;
import cn.kgc.house.mapper.TypeMapper;
import cn.kgc.house.service.TypeService;
import cn.kgc.house.util.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeMapper typeMapper;
    @Autowired
    HouseMapper houseMapper;
    @Override
    public List<Type> getAllType() {
        return typeMapper.selectAllDistrict();
    }

    @Override
    public PageInfo<Type> getTypeByPage(PageUtil pageInfo) {
        PageHelper.startPage(pageInfo.getPage(),pageInfo.getRows());
        List<Type> typetList = typeMapper.selectAllDistrict();
        PageInfo<Type> pageInfo1=new PageInfo(typetList);
        return pageInfo1;
    }

    @Override
    public int addType(String name) {
        return typeMapper.insertType(name);
    }

    @Override
    public int updateType(Type type) {
        return typeMapper.updateType(type);
    }

    @Override
    @Transactional
    public int delType(Integer id) {
        //1.通过类型编号删除房子
        int i = houseMapper.deleteHouse(id);
        //2.删除类型
        //int k = 1/0;
        int j = typeMapper.deleteType(id);
        if (i>=0&&j>0) return 1;
        return 0;
    }

    @Override
    @Transactional
    public int delMore(Integer[] idstr) {
        //1.通过类型编号删除房子
        for (Integer s : idstr) {
            houseMapper.deleteHouse(s);
        }
        //2.删除类型
        int i = typeMapper.delMore(idstr);
        return i;
    }
}

package cn.kgc.house.service;


import cn.kgc.house.entity.District;
import cn.kgc.house.entity.Street;
import cn.kgc.house.util.PageUtil;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DistrictService {
    List<District> getAllDistrict();
    //查询所有区域支持分页
    PageInfo<District> getDisrictByPage(PageUtil pageInfo);
    int addDistrict(String name);
    int updateDistrict(District district);
    int delDistrict(Integer id);
    int delMore(Integer[] idstr);
    PageInfo selectStreetById(PageUtil pageUtil,Integer districtId);
}

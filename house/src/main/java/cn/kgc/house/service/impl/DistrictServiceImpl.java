package cn.kgc.house.service.impl;


import cn.kgc.house.entity.District;
import cn.kgc.house.entity.Street;
import cn.kgc.house.mapper.DistrictMapper;
import cn.kgc.house.mapper.StreetMapper;
import cn.kgc.house.service.DistrictService;
import cn.kgc.house.util.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
    private StreetMapper streetMapper;
    @Override
    public List<District> getAllDistrict() {
        return districtMapper.selectAllDistrict();
    }

    @Override
    public PageInfo<District> getDisrictByPage(PageUtil pageInfo) {
        PageHelper.startPage(pageInfo.getPage(),pageInfo.getRows());
        List<District> districtList = districtMapper.selectAllDistrict();
        PageInfo<District> pageInfo1=new PageInfo(districtList);
        return pageInfo1;
    }

    @Override
    public int addDistrict(String name) {
        return districtMapper.insertDistrict(name);
    }

    @Override
    public int updateDistrict(District district) {
        return districtMapper.updateDistrict(district);
    }

    @Override
    @Transactional
    public int delDistrict(Integer id) {
        //1.通过区域编号删除街
        int i = streetMapper.deletcStreet(id);
        //2.删除区域
        //int k = 1/0;
        int j = districtMapper.deleteDistrict(id);
        if (i>=0&&j>0) return 1;
        return 0;
    }

    @Override
    @Transactional
    public int delMore(Integer[] idstr) {
        //1.通过区域编号删除街
        for (Integer s : idstr) {
            streetMapper.deletcStreet(s);
        }
        //2.删除区域
        int i = districtMapper.delMore(idstr);
        return i;
    }

    @Override
    public PageInfo selectStreetById(PageUtil pageUtil,Integer districtId) {
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getRows());
        List<Street> streetList = streetMapper.selectById(districtId);
        return new PageInfo(streetList);
    }
}

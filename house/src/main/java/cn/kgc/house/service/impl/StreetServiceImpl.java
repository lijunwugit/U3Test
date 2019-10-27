package cn.kgc.house.service.impl;

import cn.kgc.house.entity.Street;
import cn.kgc.house.mapper.StreetMapper;
import cn.kgc.house.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StreetServiceImpl implements StreetService {
    @Autowired
    StreetMapper streetMapper;
    @Override
    public List<Street> selectById(Integer districtId) {
        return streetMapper.selectById(districtId);
    }
}

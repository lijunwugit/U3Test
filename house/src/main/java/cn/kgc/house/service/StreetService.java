package cn.kgc.house.service;

import cn.kgc.house.entity.Street;

import java.util.List;

public interface StreetService {
    List<Street> selectById(Integer districtId);
}

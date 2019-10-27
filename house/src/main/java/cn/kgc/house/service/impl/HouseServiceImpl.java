package cn.kgc.house.service.impl;

import cn.kgc.house.entity.House;
import cn.kgc.house.mapper.HouseMapper;
import cn.kgc.house.service.HouseService;
import cn.kgc.house.util.HouseCondition;
import cn.kgc.house.util.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    HouseMapper houseMapper;
    @Override
    public int addHouse(House house) {
        return houseMapper.addHouse(house);
    }

    @Override
    public List<House> getHouseByUser(Integer userid) {
        return houseMapper.getHouseByUser(userid);
    }

    @Override
    public House getHouseById(String id) {
        return houseMapper.getHouseById(id);
    }

    @Override
    public int updateHouse(House house) {
        return houseMapper.updateHouse(house);
    }

    @Override
    public int delHouse(String id, Integer state) {
        return houseMapper.updateDelById(id,state );
    }

    @Override
    public PageInfo<House> getHouseByPassSate(Integer state, PageUtil pageUtil) {
        //开启分页
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getRows());
        //查询所有
        List<House> list=houseMapper.getHouseByPassState(state);
        return new PageInfo<House>(list);
    }

    @Override
    public int updateHousePassState(String id, Integer state) {
        return houseMapper.updatePassById(id,state );
    }

    @Override
    public PageInfo<House> getHouseByBroswer(HouseCondition condition) {
        PageHelper.startPage(condition.getPage(),condition.getRows());
        List<House> list=this.houseMapper.getHouseByBroswer(condition);
        PageInfo<House> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}

package cn.kgc.house.service;

import cn.kgc.house.entity.House;
import cn.kgc.house.util.HouseCondition;
import cn.kgc.house.util.PageUtil;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface HouseService {
    int addHouse(House house);
    List<House> getHouseByUser(Integer userid);
    House getHouseById(String id);
    int updateHouse(House house);
    /**
     * //删除出租房
     * @param id  房屋编号
     * @return  影响行数
     * @param state 如果状态为1删除,0未删除
     * @return
     */

    public int delHouse(String id,Integer state);
    /**
     * 查询已审核|未审核的出租房信息
     * @param state  状态 0表示未审核 1表示审核通过
     * @return  所有的出租房信息
     */
    public PageInfo<House> getHouseByPassSate(Integer state, PageUtil pageUtil);

    /**
     * 修改出租房的审核状态
     * @param id 编号
     * @param state  0未审核  1已审核
     * @return 影响行数
     */
    public int updateHousePassState(String id,Integer state);
    PageInfo<House> getHouseByBroswer(HouseCondition condition);
}

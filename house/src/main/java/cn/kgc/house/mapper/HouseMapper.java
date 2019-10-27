package cn.kgc.house.mapper;

import cn.kgc.house.entity.House;
import cn.kgc.house.util.HouseCondition;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface HouseMapper {
    @Delete("delete from house where typeId=#{arg0}")
    int deleteHouse(Integer typeId);
    @Insert("insert into house values(#{id},#{userId},#{typeId},#{title},#{description},#{price},#{pubdate},#{floorage},#{contact},#{streetId},#{ispass},#{isdel},#{path})")
    int addHouse(House house);
    List<House> getHouseByUser(Integer userid);
    //查询某条出租房信息
    House getHouseById(String id);
    int updateHouse(House record);
    //修改删除状态
    @Update("update house set isdel=#{arg1} where id=#{arg0}")
    int updateDelById(String id ,Integer state);
    //查询所有未|已审核的出租房
    List<House> getHouseByPassState(Integer state);
    //修改审核状态
    @Update("update house set ispass=#{arg1} where id=#{arg0}")
    int updatePassById(String id, Integer state);
    //实现浏览出租房
    List<House> getHouseByBroswer(HouseCondition condition);

}

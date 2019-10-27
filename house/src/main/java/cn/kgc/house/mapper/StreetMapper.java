package cn.kgc.house.mapper;

import cn.kgc.house.entity.Street;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StreetMapper {
    @Delete("delete from street where districtId=#{arg0}")
    int deletcStreet(Integer districtId);
    @Select("select * from street where districtId=#{arg0}")
    List<Street> selectById(Integer districtId);
}

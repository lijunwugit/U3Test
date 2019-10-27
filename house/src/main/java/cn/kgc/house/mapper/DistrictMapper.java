package cn.kgc.house.mapper;


import cn.kgc.house.entity.District;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DistrictMapper {
    @Select("select * from district")
    List<District> selectAllDistrict();
    @Insert("insert into district values(null,#{0})")
    int insertDistrict(String name);
    @Update("update district set name=#{name} where id=#{id}")
    int updateDistrict(District district);
    @Delete("delete from district where id=#{arg0}")
    int deleteDistrict(Integer id);
    int delMore(Integer[] idstr);
}
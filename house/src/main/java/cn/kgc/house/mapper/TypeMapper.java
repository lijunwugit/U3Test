package cn.kgc.house.mapper;

import cn.kgc.house.entity.District;
import cn.kgc.house.entity.Type;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TypeMapper {
    @Select("select * from type")
    List<Type> selectAllDistrict();
    @Insert("insert into type values(null,#{0})")
    int insertType(String name);
    @Update("update type set name=#{name} where id=#{id}")
    int updateType(Type type);
    @Delete("delete from type where id=#{arg0}")
    int deleteType(Integer id);
    int delMore(Integer[] idstr);
}

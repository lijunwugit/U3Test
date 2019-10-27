package cn.kgc.house.mapper;

import cn.kgc.house.entity.Users;
import cn.kgc.house.util.UserCondition;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UsersMapper {
    List<Users> selectBySome(UserCondition condition);
    @Select("select * from users where name=#{0}")
    Users selectByName(String name);
    @Insert("insert into users values(null,#{name},#{password},#{telephone},#{age},#{isadmin})")
    int addUser(Users users);
    @Select("select * from users where name=#{arg0} and password=#{arg1}")
    Users login(String name,String password);
}

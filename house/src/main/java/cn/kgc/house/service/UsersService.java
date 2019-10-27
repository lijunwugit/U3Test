package cn.kgc.house.service;

import cn.kgc.house.entity.Users;
import cn.kgc.house.util.UserCondition;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UsersService {
    PageInfo selectByCondition(UserCondition condition);
    int selectByName(String name);
    int addUser(Users users);
    Users login(String name,String password);

}

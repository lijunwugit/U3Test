package cn.kgc.house.service.impl;

import cn.kgc.house.entity.Users;
import cn.kgc.house.mapper.UsersMapper;
import cn.kgc.house.service.UsersService;
import cn.kgc.house.util.MD5Utils;
import cn.kgc.house.util.UserCondition;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersMapper usersMapper;
    @Override
    public PageInfo selectByCondition(UserCondition condition) {
        PageHelper.startPage(condition.getPage(),condition.getRows() );
        List<Users> usersList = usersMapper.selectBySome(condition);
        return new PageInfo(usersList);
    }

    @Override
    public int selectByName(String name) {
        return usersMapper.selectByName(name)==null?0:1;
    }

    @Override
    public int addUser(Users users) {
        users.setIsadmin(0);
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
        int i = usersMapper.addUser(users);
        return i;
    }

    @Override
    public Users login(String name, String password) {
        Users users = usersMapper.login(name,MD5Utils.md5Encrypt(password) );
        return users;
    }
}

package cn.kgc.house.controller;


import cn.kgc.house.service.UsersService;
import cn.kgc.house.util.UserCondition;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class UsersController {
    @Autowired
    UsersService usersService;

    @RequestMapping("getUsersByPage")
    @ResponseBody
    public Map<String,Object> getUsersByPage(UserCondition condition){
        PageInfo pageInfo = usersService.selectByCondition(condition);
        //使用map封装返回的数据
        Map<String,Object> map=new HashMap<>();
        map.put("rows",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return map;
    }
}

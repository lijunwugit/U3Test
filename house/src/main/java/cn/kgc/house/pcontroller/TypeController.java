package cn.kgc.house.pcontroller;

import cn.kgc.house.entity.Type;
import cn.kgc.house.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller(value ="typeController2" )
@RequestMapping("/page/")
public class TypeController {
    @Autowired
    TypeService typeServise;


    @RequestMapping("getAllType")
    @ResponseBody
    public List<Type> getAllType(){
        System.out.println("123456212312413432153426534");
        System.out.println(typeServise.getAllType());
        return  typeServise.getAllType();
    }

}

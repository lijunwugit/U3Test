package cn.kgc.house.controller;

import cn.kgc.house.entity.Type;
import cn.kgc.house.service.TypeService;
import cn.kgc.house.util.PageUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class TypeController {
    @Autowired
    private TypeService typeServise;

    @RequestMapping("getAllType")
    @ResponseBody
    public List<Type> getAllType(){
        return typeServise.getAllType();
    }

    @RequestMapping("getTypeByPage")
    @ResponseBody
    public Map<String,Object> getTypeByPage(PageUtil pageUtil){
        //调用业务
        PageInfo<Type> pageInfo=typeServise.getTypeByPage(pageUtil);

        //使用map封装返回的数据
        Map<String,Object> map=new HashMap<>();
        map.put("rows",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return map;
    }
    @RequestMapping("addType")
    @ResponseBody
    public Map<String,Object> addType(String name){
        int i = typeServise.addType(name);
        Map<String,Object> map=new HashMap<>();
        map.put("result",i );
        return map;
    }
    @RequestMapping("upType")
    @ResponseBody
    public Map<String,Object> upType(Type type){
        int i = typeServise.updateType(type);
        Map<String,Object> map=new HashMap<>();
        map.put("result",i );
        return map;
    }
    @RequestMapping("delType")
    @ResponseBody
    public Map<String,Object> delType(Integer id){
        int i = typeServise.delType(id);
        Map<String,Object> map=new HashMap<>();
        map.put("result",i );
        return map;
    }
    @RequestMapping("delMoreType")
    @ResponseBody
    public Map<String,Object> delMoreType(String ids){
        String[] idstr = ids.split(",");
        Integer [] ary=new Integer[idstr.length];
        for (int i = 0; i <idstr.length ; i++) {
            ary[i]=Integer.parseInt(idstr[i]);
        }
        int i = typeServise.delMore(ary);
        Map<String,Object> map=new HashMap<>();
        map.put("result",i );
        return map;
    }
}

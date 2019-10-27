package cn.kgc.house.controller;


import cn.kgc.house.entity.District;
import cn.kgc.house.service.DistrictService;
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
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @RequestMapping("getAllDistrict")
    @ResponseBody
    public List<District> getAllDistrict(){
        return districtService.getAllDistrict();
    }

    @RequestMapping("getDistrictByPage")
    @ResponseBody
    public Map<String,Object> getDistrictByPage(PageUtil pageUtil){
        //调用业务
        PageInfo<District> pageInfo=districtService.getDisrictByPage(pageUtil);

        //使用map封装返回的数据
        Map<String,Object> map=new HashMap<>();
        map.put("rows",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return map;
    }
    @RequestMapping("addDistrit")
    @ResponseBody
    public Map<String,Object> addDistrit(String name){
        int i = districtService.addDistrict(name);
        Map<String,Object> map=new HashMap<>();
        map.put("result",i );
        return map;
    }
    @RequestMapping("upDistrit")
    @ResponseBody
    public Map<String,Object> upDistrit(District district){
        int i = districtService.updateDistrict(district);
        Map<String,Object> map=new HashMap<>();
        map.put("result",i );
        return map;
    }
    @RequestMapping("delDistrit")
    @ResponseBody
    public Map<String,Object> delDistrit(Integer id){
        int i = districtService.delDistrict(id);
        Map<String,Object> map=new HashMap<>();
        map.put("result",i );
        return map;
    }
    @RequestMapping("delMore")
    @ResponseBody
    public Map<String,Object> delMore(String ids){
        String[] idstr = ids.split(",");
        Integer [] ary=new Integer[idstr.length];
        for (int i = 0; i <idstr.length ; i++) {
            ary[i]=Integer.parseInt(idstr[i]);
        }
        int i = districtService.delMore(ary);
        Map<String,Object> map=new HashMap<>();
        map.put("result",i );
        return map;
    }
    @RequestMapping("getStreetByPage")
    @ResponseBody
    public Map<String,Object> getStreetByPage(PageUtil pageUtil,String districtId){
        PageInfo pageInfo = districtService.selectStreetById(pageUtil, Integer.parseInt(districtId));
        //使用map封装返回的数据
        Map<String,Object> map=new HashMap<>();
        map.put("rows",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return map;
    }

}

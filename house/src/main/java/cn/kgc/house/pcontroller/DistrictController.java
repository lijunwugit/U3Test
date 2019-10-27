package cn.kgc.house.pcontroller;

import cn.kgc.house.entity.District;
import cn.kgc.house.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller(value ="districtController2" )
@RequestMapping("/page/")
public class DistrictController {
    @Autowired
    DistrictService districtService;

    @RequestMapping("getAllDistrict")
    @ResponseBody
    public List<District> getAllType(){
        List<District> allDistrict = districtService.getAllDistrict();
        return  allDistrict;
    }

}

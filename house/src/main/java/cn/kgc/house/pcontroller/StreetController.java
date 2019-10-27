package cn.kgc.house.pcontroller;

import cn.kgc.house.entity.District;
import cn.kgc.house.entity.Street;
import cn.kgc.house.service.DistrictService;
import cn.kgc.house.service.StreetService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller(value ="streetController2" )
@RequestMapping("/page/")
public class StreetController {
    @Autowired
    StreetService streetService;

    @RequestMapping("getStreetByDid")
    @ResponseBody
    public List<Street> getStreetByDid(Integer did){
        List<Street> streetList = streetService.selectById(did);
        return  streetList;
    }

}

package cn.kgc.house.pcontroller;

import cn.kgc.house.entity.District;
import cn.kgc.house.entity.House;
import cn.kgc.house.entity.Users;
import cn.kgc.house.service.DistrictService;
import cn.kgc.house.service.HouseService;
import cn.kgc.house.util.HouseCondition;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller(value ="houseController2" )
@RequestMapping("/page/")
public class HouseController {
    @Autowired
    HouseService houseService;

    @RequestMapping("addHouse")
    public String addHouse(House house, HttpSession session, @RequestParam(value = "pfile",required =false )MultipartFile pfile){
        String sourceFile = pfile.getOriginalFilename();
        String extName=sourceFile.substring(sourceFile.lastIndexOf("."));//扩展名
        String bh=System.currentTimeMillis()+"";
        String filename=bh+extName;
        String path="e:\\images\\"+filename;
        File saveFile=new File(path);
        try {
            pfile.transferTo(saveFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        house.setId(bh);
        house.setPath(filename);
        Users user=(Users) session.getAttribute("userinfo");
        if (user!=null) house.setUserId(user.getId());
        house.setIsdel(0);
        house.setIspass(0);
        int i = houseService.addHouse(house);
        if (i>0) return "redirect:/page/getUserHouse.do";
        return  "/page/error.jsp";
    }
    @RequestMapping("getUserHouse")
    public String getUserHouse(HttpSession session, Model model){
        //调用业务查询所有用户发布的出租房信息
        //设置用户编号
        Users user=(Users) session.getAttribute("userinfo");
        List<House> list=houseService.getHouseByUser(user.getId());  //固定某值查询
        model.addAttribute("list",list);
        return "/page/guanli.jsp";
    }
    @RequestMapping("showHouse")
    public String showHouse(String id, Model model){
        House house= houseService.getHouseById(id);
        model.addAttribute("house",house);
        return "/page/update.jsp";
    }
    @RequestMapping("updateHouse")
    public String updateHouse(House house ,
                              String oldPic,@RequestParam(value = "pfile",required = false)MultipartFile pfile){
        try {
            //根据用户是否选择图片来判定需不需要上传图片
            if(!pfile.isEmpty()){
                String sourceFile=pfile.getOriginalFilename();  //文件名
                String extName=sourceFile.substring(sourceFile.lastIndexOf("."));//扩展名
                String bh=System.currentTimeMillis()+"";
                String filename=bh+extName;
                String path="e:\\images\\"+filename;
                File saveFile=new File(path);
                pfile.transferTo(saveFile);   //上传
                //设置图片
                house.setPath(filename);
            }

            //2.调用业务将数据保存到数据库
            houseService.updateHouse(house); //保存

            //删除旧图
            if (!pfile.isEmpty()){
                //删除旧的图片
                File file=new File("e:\\images\\"+oldPic);
                file.delete();
            }
            return "redirect:/page/getUserHouse.do";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "/page/error.jsp";
    }
    @RequestMapping("delHouse")
    @ResponseBody
    public String delHouse(String id){
        //调用业务删除
        int temp=this.houseService.delHouse(id,1);
        return "{\"result\":"+temp+"}";
    }

    @RequestMapping("searchHouse")
    public String searchHouse(HouseCondition condition, Model model){
        condition.setRows(5);  //页大小默认5条
        PageInfo<House> houses=this.houseService.getHouseByBroswer(condition);
        model.addAttribute("houses",houses);
        model.addAttribute("conditioin",condition);
        return "/page/list.jsp";

    }

    }

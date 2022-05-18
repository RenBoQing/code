package com.rbq.code.controller;

import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.Circle;
import com.rbq.code.service.CircleService;
import com.rbq.code.vo.JsonObject;
import com.rbq.code.vovo.CircleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年04月19日 15:08
 * @Description 宠友圈动态发布
 */
@Controller
@RequestMapping("/circle")
public class CircleController {
    @Autowired
    private CircleService circleService;


    @RequestMapping("/listdemo")
    @ResponseBody
    public JsonObject queryAllCircles(Model model, Circle circle,@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "100") Integer limit){
        PageInfo<Circle> circlePageInfo = circleService.queryAllCircle(page, limit, circle);
        if(circlePageInfo.getTotal()>0){
            return JsonObject.success(0,circlePageInfo.getList(),"查询成功",circlePageInfo.getTotal());
        }else {
            return JsonObject.fail(1, "查询失败");
        }
    }


    /*
     *查询所有的宠友圈数据
     * @author RenBoQing
     * @date 2022/4/19 0019 16:12
     * @param model
     * @param page
     * @param limit
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/list")
    @ResponseBody
    public JsonObject queryAllCircleVO(Model model, CircleVo circleVo,@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "100") Integer limit) {
        PageInfo<CircleVo> circleVoPageInfo = circleService.queryAllCircleVo(page, limit,circleVo);
        return JsonObject.success(0, circleVoPageInfo.getList(), "查询成功", circleVoPageInfo.getTotal());
    }
    /*
     *用户添加宠友圈
     * @author RenBoQing
     * @date 2022/4/19 0019 18:21
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/add")
    @ResponseBody
    public JsonObject addCircle(String title, Integer id, String image, String address, String comment) {
        String replace = image.replace("[", "");
        String replace1 = replace.replace("\"", "");
        String replace2 = replace1.replace("]", "");
        String[] split = replace2.split(",");
        Circle circle = new Circle();
        String im="";
        String im1="";
        String im2="";
        for (int i = 0; i <= split.length; i++) {
            im=split[0];
            im1=split[1];
            im2=split[2];
        }
        circle.setImage(im);
        circle.setImageone(im1);
        circle.setImagetwo(im2);
        circle.setTitle(title);
        circle.setUid(id);
        circle.setViewcount(20);
        circle.setCount(29);
        circle.setAddress(address);
        circle.setComment(comment);
        circle.setCreatetime(new Date());
        circle.setUpdatetime(new Date());
        int addCircles = circleService.addCircles(circle);
        List<Circle> circleList = new ArrayList<>();
        circleList.add(circle);
        if (addCircles > 0) {
            return JsonObject.success(0, circleList, "添加成功", (long) circleList.size());
        } else {
            return JsonObject.fail(1, "添加失败");
        }
    }


     /*
      *图表信息生成
      * @author RenBoQing
      * @date 2022/5/4 0004 10:30
      * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
      */
    @RequestMapping("/queryCircleCount")
    @ResponseBody
    public List<Map<String, Object>> queryForList() {
        return circleService.queryCircleCount();
    }
}

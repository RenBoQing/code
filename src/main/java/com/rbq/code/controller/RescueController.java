package com.rbq.code.controller;

import com.rbq.code.entity.Rescue;
import com.rbq.code.service.RescueService;
import com.rbq.code.vo.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年04月06日 9:36
 * @Description 救助站控制器
 */
@Controller
@RequestMapping("/rescue")
public class RescueController {
    @Autowired
    private RescueService rescueService;
    /*
     *查询所有的救助站的信息
     * @author RenBoQing
     * @date 2022/4/12 0012 19:18
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/list")
    @ResponseBody
    public JsonObject queryAllRescue() {
        List<Rescue> rescues = rescueService.queryAllRescues();
        return JsonObject.success(0, rescues, "查询成功", (long) rescues.size());
    }
    /*
     *根据id查询所有的救助站信息
     * @author RenBoQing
     * @date 2022/4/12 0012 19:19
     * @param id
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/queryById")
    @ResponseBody
    public JsonObject queryAllRescueById(Integer id) {
        List<Rescue> rescues = rescueService.queryRescuesById(id);
        return JsonObject.success(0, rescues, "查询成功", (long) rescues.size());
    }
}

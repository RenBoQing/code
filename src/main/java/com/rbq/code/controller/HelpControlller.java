package com.rbq.code.controller;

import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.Help;
import com.rbq.code.service.HelpService;
import com.rbq.code.vo.JsonObject;
import com.rbq.code.vovo.HelpVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年05月02日 10:10
 * @Description
 */
@Controller
@RequestMapping("/help")
public class HelpControlller {
    @Autowired
    private HelpService helpService;
    /*
     *查询所有的充互帮数据
     * @author RenBoQing
     * @date 2022/5/2 0002 10:24
     * @param model
     * @param helpVo
     * @param page
     * @param limit
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/list")
    @ResponseBody
    public JsonObject queryAllHelp(Model model, HelpVo helpVo, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "3") Integer limit) {
        PageInfo<HelpVo> helpVoPageInfo = helpService.queryAllHelp(page, limit, helpVo);
        if (helpVoPageInfo.getTotal() > 0) {
            return JsonObject.success(0, helpVoPageInfo.getList(), "查询成功", helpVoPageInfo.getTotal());
        } else {
            return JsonObject.fail(0, "暂无数据");
        }
    }

    /*
     *添加页面
     * @author RenBoQing
     * @date 2022/5/3 0003 16:30
     * @param help
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/add")
    @ResponseBody
    public JsonObject addHelp(Help help) {
        int addHelp = helpService.addHelp(help);
        if (addHelp > 0 && help != null) {
            return JsonObject.success(0, "添加成功");
        } else {
            return JsonObject.fail(1, "添加失败");
        }
    }
}

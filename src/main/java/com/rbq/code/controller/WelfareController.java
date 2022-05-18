package com.rbq.code.controller;

import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.Welfare;
import com.rbq.code.service.WelfareService;
import com.rbq.code.vo.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author RenBoQing
 * @date 2022年04月12日 22:01
 * 2@Description  公益模块
 */
@Controller
@RequestMapping("/welfare")
public class WelfareController {
    @Autowired
    private WelfareService welfareService;

    /*
     *查询所有的公益基金
     * @author RenBoQing
     * @date 2022/4/24 0024 14:31
     * @param model
     * @param welfare
     * @param page
     * @param limit
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/list")
    @ResponseBody
    public JsonObject queryAllWelfare(Model model, Welfare welfare, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
        PageInfo<Welfare> welfarePageInfo = welfareService.queryAllWelfare(page, limit, welfare);
        return JsonObject.success(0, welfarePageInfo.getList(), "查询成功", welfarePageInfo.getTotal());
    }

    /*
     *删除信息
     * @author RenBoQing
     * @date 2022/5/3 0003 12:23
     * @param id
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/del")
    @ResponseBody
    public JsonObject delWelfareById(Integer id) {
        int delWelfareById = welfareService.delWelfareById(id);
        if (delWelfareById > 0) {
            return JsonObject.success(0, "删除成功");
        } else {
            return JsonObject.fail(1, "删除失败");
        }
    }

    /*
     *添加公益项目
     * @author RenBoQing
     * @date 2022/5/3 0003 13:39
     * @param welfare
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/welfareadd")
    @ResponseBody
    public JsonObject addWelfare(Welfare welfare) {
        welfare.setCreatetime(new Date());
        welfare.setCount(90);
        int addWelfare = welfareService.addWelfare(welfare);
        if (addWelfare > 0) {
            return JsonObject.success(0, "添加成功");
        } else {
            return JsonObject.fail(1, "添加失败");
        }
    }

    /*
     *修改数据
     * @author RenBoQing
     * @date 2022/5/3 0003 14:43
     * @param welfare
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/updatewel")
    @ResponseBody
    public JsonObject updateWel(Welfare welfare) {
        int i = welfareService.updateWelfareById(welfare);
        if (i > 0) {
            return JsonObject.success(0, "修改成功");
        }
        return JsonObject.fail(1, "修改失败");
    }

    /*
     *图表信息生成
     * @author RenBoQing
     * @date 2022/5/4 0004 10:10
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    @RequestMapping("/queryWelfareCount")
    @ResponseBody
    public List<Map<String, Object>> queryForList() {
        return welfareService.queryWelfareCount();
    }


}

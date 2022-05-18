package com.rbq.code.controller;

import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.Adopt;
import com.rbq.code.service.AdoptService;
import com.rbq.code.vo.JsonObject;
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
 * @author RenBoQing
 * @date 2022年04月09日 12:02
 * @Description 领养视图层
 */
@Controller
@RequestMapping("/adopt")
public class AdoptController {
    @Autowired
    private AdoptService adoptService;

    /*
     *查询所有的领养信息
     * @author RenBoQing
     * @date 2022/4/15 0015 9:28
     * @param model
     * @param adopt
     * @param page
     * @param limit
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/list")
    @ResponseBody
    public JsonObject queryAllAdopts(Model model, Adopt adopt, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
        PageInfo<Adopt> adoptPageInfo = adoptService.queryAllAdopts(page, limit, adopt);
        return JsonObject.success(0, adoptPageInfo.getList(), "查询成功", adoptPageInfo.getTotal());
    }

    @RequestMapping("/listbytime")
    @ResponseBody
    public JsonObject queryAllAdoptsByTime(Model model, Adopt adopt) {

        List<Adopt> adoptList = adoptService.queryAllAdoptBytime(adopt);
        return JsonObject.success(0, adoptList, "查询成功", (long) adoptList.size());
    }

    /*
     *根据id删除
     * @author RenBoQing
     * @date 2022/4/15 0015 9:56
     * @param id
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/del")
    @ResponseBody
    public JsonObject deleteAdoptsById(Integer id) {
        Integer result = adoptService.deleteAdoptById(id);
        if (result > 0) {
            return JsonObject.success(0, "删除成功");
        } else {
            return JsonObject.fail(1, "删除失败");

        }
    }

    /*
     *批量删除
     * @author RenBoQing
     * @date 2022/4/15 0015 14:33
     * @param ids
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/delAdoptByIds")
    @ResponseBody
    public JsonObject delAdoptByIds(String ids) {
        List<Integer> delList = new ArrayList<>();
        String[] strs = ids.split(",");
        for (String str : strs) {
            delList.add(Integer.parseInt(str));
        }
        adoptService.delAdoptsByIds(delList);
        return JsonObject.success(0, "批量删除成功");
    }

    /*
     *添加领养信息
     * @author RenBoQing
     * @date 2022/4/15 0015 14:41
     * @param adopt
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/add")
    @ResponseBody
    public JsonObject addAdopts(Adopt adopt) {
        adopt.setStatus(0);
        adopt.setCreatetime(new Date());
        int adopts = adoptService.addAdopts(adopt);
        if (adopts > 0) {
            return JsonObject.success(0, "添加成功");
        } else {
            return JsonObject.fail(1, "添加失败");
        }
    }

    /*
     *
     * @author RenBoQing
     * @date 2022/4/24 0024 13:36
     * @param adopt
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/updateAdoptsById")
    @ResponseBody
    public JsonObject updateAdoptsById(Adopt adopt) {
        adoptService.updateAdopts(adopt);
        return JsonObject.success(0, "修改成功");
    }

    /*
     *图表信息生成  领养信息添加
     * @author RenBoQing
     * @date 2022/5/4 0004 9:52
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    @RequestMapping("/queryAdoptCount")
    @ResponseBody
    public List<Map<String, Object>> queryForList() {
        return adoptService.queryAdoptCount();
    }
}

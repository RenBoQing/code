package com.rbq.code.controller;

import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.Wiki;
import com.rbq.code.service.WikiService;
import com.rbq.code.vo.JsonObject;
import lombok.extern.slf4j.Slf4j;
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
 * @date 2022年04月04日 17:13
 * @Description 宠物百科信息
 */
@Controller
@RequestMapping("/wiki")
@Slf4j
public class WikiController {
    @Autowired
    private WikiService wikiService;
    /*
     *获取所有的百科信息
     * @author RenBoQing
     * @date 2022/4/4 0004 20:08
     * @return com.rbq.code.vo.R
     */
    @RequestMapping("/list")
    @ResponseBody
    private JsonObject queryAllWiki(Model model, Wiki wiki, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
        wiki.setCreatetime(new Date());
        PageInfo<Wiki> wikiPageInfo = wikiService.queryHosptialAll(page, limit, wiki);
        return JsonObject.success(0, wikiPageInfo.getList(), "查询成功", wikiPageInfo.getTotal());
    }
    /*
     *根据id获取百科信息
     * @author RenBoQing
     * @date 2022/4/6 0006 11:29
     * @param id
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/queryById")
    @ResponseBody
    public JsonObject queryWikiById(Integer id) {
        Wiki wiki = wikiService.queryWikiById(id);
        List<Wiki> wikis = new ArrayList<>();
        wikis.add(wiki);
        return JsonObject.success(0, wikis, "查询成功", (long) wikis.size());
    }
    /*
     *根据id删除宠物信息
     * @author RenBoQing
     * @date 2022/4/9 0009 9:12
     * @param id
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/del")
    @ResponseBody
    public JsonObject deleteWikiById(Integer id) {
        Integer code = wikiService.deleteWikiById(id);
        if (code > 0) {
            return JsonObject.success("删除成功");
        } else {
            return JsonObject.fail("删除失败");
        }
    }

    /*
     * 添加宠物百科信息
     * @author RenBoQing
     * @date 2022/4/8 0008 9:46
     * @param wiki
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/add")
    @ResponseBody
    public JsonObject addWiki(Wiki wiki) {
        int i = wikiService.addWiki(wiki);
        if (i > 0) {
            return JsonObject.success("添加成功");
        } else {
            return JsonObject.fail("添加失败");
        }
    }
    /*
     *批量删除百科信息
     * @author RenBoQing
     * @date 2022/4/8 0008 9:51
     * @param ids
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/delWikiByIds")
    @ResponseBody
    public JsonObject delWikiByIds(String ids) {
        List<Integer> delList = new ArrayList<>();
        //后台获取
        String[] strs = ids.split(",");
        for (String str : strs) {
            delList.add(Integer.parseInt(str));
        }
        wikiService.delWikiByIds(delList);
        return JsonObject.success("删除成功");
    }

    /*
     *根据id查询动物百科项目
     * @author RenBoQing
     * @date 2022/4/12 0012 19:22
     * @param wiki
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/updateWikiById")
    @ResponseBody
    public JsonObject updateWikiById(Wiki wiki) {
        wikiService.updateWiki(wiki);
        return JsonObject.success(0,"修改成功");
    }


   /*
    *图表信息生成
    * @author RenBoQing
    * @date 2022/5/4 0004 9:04
    * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
    */
    @RequestMapping("/queryWikiCount")
    @ResponseBody
    public List<Map<String, Object>> queryForList() {
        return wikiService.queryWikiCount();
    }
}

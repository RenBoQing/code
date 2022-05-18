package com.rbq.code.controller;

import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.Category;
import com.rbq.code.service.CategoryService;
import com.rbq.code.vo.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author RenBoQing
 * @date 2022年04月12日 9:33
 * @Description 商品分类控制器
 */
@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /*
     *根据分类查询所有的数据
     * @author RenBoQing
     * @date 2022/4/12 0012 19:11
     * @param model
     * @param category
     * @param page
     * @param limit
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/list")
    @ResponseBody
    public JsonObject queryAllProductByCategory(Model model, Category category, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
        PageInfo<Category> categoryPageInfo = categoryService.queryAllProductByCategory(page, limit, category);
        return JsonObject.success(0, categoryPageInfo.getList(), "查询成功", categoryPageInfo.getTotal());
    }
}

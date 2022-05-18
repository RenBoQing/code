package com.rbq.code.controller;

import com.rbq.code.entity.Menu;
import com.rbq.code.service.MenuService;
import com.rbq.code.vo.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年05月04日 10:43
 * @Description
 */
@RequestMapping("/menu")
@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/list")
    @ResponseBody
    public JsonObject list() {
        List<Menu> menus = menuService.queryMenuAll();
        if (menus.size() > 0) {
            return JsonObject.success(0, menus, "查询成功", (long) menus.size());
        } else {
            return JsonObject.fail(1, "查询失败");
        }
    }
}

package com.rbq.code.controller;

import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.Cart;
import com.rbq.code.service.CartService;
import com.rbq.code.vo.JsonObject;
import com.rbq.code.vovo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年04月17日 21:52
 * @Description
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    /*
     *添加商品到购物车
     * @author RenBoQing
     * @date 2022/4/18 0018 8:35
     * @param cart
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/add")
    @ResponseBody
    public JsonObject addCart(Cart cart) {
        cart.setCreatetime(new Date());
        cart.setSelected("circle");
        int addCart = cartService.addCart(cart);
        if (addCart > 0) {
            return JsonObject.success(0, "添加成功");
        } else {
            return JsonObject.success(1, "添加失败");
        }
    }

    /*
     *根据uid查询对应的订单数据
     * @author RenBoQing
     * @date 2022/4/18 0018 16:56
     * @param id
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/queryByid")
    @ResponseBody
    public JsonObject queryCartByUid(Integer id) {
        List<CartVo> cartByUid = cartService.getCartByUid(id);
        if (cartByUid != null) {
            return JsonObject.success(0, cartByUid, "查询成功", (long) cartByUid.size());
        } else {
            return JsonObject.fail(0, "该用户没有添加商品到购物车");
        }
    }

    /*
     *查询所有的数据
     * @author RenBoQing
     * @date 2022/5/1 0001 20:55
     * @param model
     * @param cartVo
     * @param page
     * @param limit
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/queryAllCart")
    @ResponseBody
    public JsonObject queryAllCart(Model model, CartVo cartVo, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
        PageInfo<CartVo> cartVoPageInfo = cartService.queryAllCart(page, limit, cartVo);
        if (cartVoPageInfo.getTotal() > 0) {
            return JsonObject.success(0, cartVoPageInfo.getList(), "查询成功", cartVoPageInfo.getTotal());
        } else {
            return JsonObject.fail(1, "暂无数据");
        }
    }
}

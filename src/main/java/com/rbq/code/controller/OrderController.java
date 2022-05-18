package com.rbq.code.controller;

import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.Order;
import com.rbq.code.entity.Wiki;
import com.rbq.code.service.OrderService;
import com.rbq.code.vo.JsonObject;
import com.rbq.code.vovo.OrderVo;
import com.rbq.code.vovo.UserOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年04月19日 10:35
 * @Description 订单视图层
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /*
     *添加订单
     * @author RenBoQing
     * @date 2022/4/20 0020 16:19
     * @param cids
     * @param userid
     * @param receivename
     * @param receivephone
     * @param receivepaddr
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/add")
    @ResponseBody
    public JsonObject orderAdd(String cids, Integer userid, String receivename, String receivephone, String receivepaddr) {
        String replace = cids.replace("[", "");
        String replace1 = replace.replace("]", "");
        String[] split = replace1.split(",");
        List<Integer> delList = new ArrayList<>();
        for (String str : split) {
            delList.add(Integer.parseInt(str));
        }
        Integer[] integer = delList.toArray(new Integer[delList.size()]);
        Order addOrder = orderService.addOrder(integer, userid, receivename, receivephone, receivepaddr);
        List<Order> orderList = new ArrayList<>();
        orderList.add(addOrder);
        return JsonObject.success(0, orderList, "添加成功", (long) orderList.size());
    }
    /*
     *查询所有的订单
     * @author RenBoQing
     * @date 2022/5/1 0001 21:43
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/list")
    @ResponseBody
    public JsonObject queryAllOrder(Model model, OrderVo orderVo, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
        PageInfo<OrderVo> orderVoPageInfo = orderService.queryAllOrderPage(page, limit, orderVo);
        if(orderVoPageInfo.getTotal()>0){
            return JsonObject.success(0,orderVoPageInfo.getList(),"查询成功", orderVoPageInfo.getTotal() );
        }
        else {
            return JsonObject.fail(0,"查询失败");
        }
    }

    @RequestMapping("/del")
    @ResponseBody
    public JsonObject deleteOrderByoderNo(String orderno){
        int deleteOrderByOrderNo = orderService.deleteOrderByOrderNo(orderno);
        if(deleteOrderByOrderNo>0){
            return JsonObject.success(0,"删除成功");
        }
        else {
            return JsonObject.fail(1,"删除失败");
        }
    }
}

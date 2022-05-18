package com.rbq.code.service;

import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.Order;
import com.rbq.code.vovo.OrderVo;
import com.rbq.code.vovo.UserOrderVo;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年04月18日 21:38
 * @Description
 */

public interface OrderService {

    Order addOrder(Integer[] cids, Integer userid, String receivename, String receivephone, String receivepaddr);

    /*
     *查询用户所有的订单
     * @author RenBoQing
     * @date 2022/5/1 0001 21:36
     * @return java.util.List<com.rbq.code.vovo.UserOrderVo>
     */
    public List<UserOrderVo> queryAllOrder();

    /*
     *查询所有的数据
     * @author RenBoQing
     * @date 2022/5/3 0003 10:21
     * @return java.util.List<com.rbq.code.vovo.OrderVo>
     */
    PageInfo<OrderVo> queryAllOrderPage(int page, int pageSize, OrderVo orderVo);

    /*
     *删除订单
     * @author RenBoQing
     * @date 2022/5/3 0003 11:12
     * @param orderno
     * @return int
     */
    int deleteOrderByOrderNo(String orderno);
}

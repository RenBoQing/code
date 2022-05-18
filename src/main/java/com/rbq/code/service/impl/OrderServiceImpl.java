package com.rbq.code.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.Order;
import com.rbq.code.entity.OrderItem;
import com.rbq.code.mapper.OrderMapper;
import com.rbq.code.service.CartService;
import com.rbq.code.service.OrderService;
import com.rbq.code.utils.UUIDtilus;
import com.rbq.code.vovo.CartVo;
import com.rbq.code.vovo.OrderVo;
import com.rbq.code.vovo.UserOrderItemVo;
import com.rbq.code.vovo.UserOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年04月19日 9:36
 * @Description
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private CartService cartService;

    /*
     *添加订单项
     * @author RenBoQing
     * @date 2022/4/19 0019 9:46
     * @param cids
     * @param userid
     * @param receivename
     * @param receivephone
     * @param receivepaddr
     * @return com.rbq.code.entity.Order
     */
    @Override
    public Order addOrder(Integer[] cids, Integer userid, String receivename, String receivephone, String receivepaddr) {
        //获取当前得时间
        Date now = new Date();
        //将获取到的订单数据 通过uid和ids获取出来
        List<CartVo> voByCids = cartService.getVOByCids(userid, cids);
        //计算商品的总价
        double totalPrice = 0;
        for (CartVo voByCid : voByCids) {
            totalPrice += voByCid.getRealprice() * voByCid.getPrice();
        }
        //创建订单数据
        Order order = new Order();
        order.setOrderno(UUIDtilus.getUuid());
        order.setUserid(userid);
        order.setTotalprice(totalPrice);
        order.setReceivername(receivename);
        order.setReceiverphone(receivephone);
        order.setReceiveraddr(receivepaddr);
        order.setOrderstatus(1);
        order.setPayment(1);
        order.setPaytime(now);
        order.setDeliverytime(now);
        order.setUpdatetime(now);
        //插入订单数据
        Integer addOrder = orderMapper.addOrder(order);
        //当受到影响的行数大于0的时候 进行订单的每一项进行遍历
        OrderItem item = new OrderItem();
        if (addOrder > 0) {
            for (CartVo voByCid : voByCids) {
                item.setOrderid(order.getId());
                item.setProductname(voByCid.getProductname());
                item.setProtuctimg(voByCid.getImage());
                item.setProtuctprice(voByCid.getRealprice());
                item.setCreatetime(now);
                item.setUpdatetime(now);
                item.setCount(voByCid.getCount());
                Integer addOrderItem = orderMapper.addOrderItem(item);
            }
            return order;
        } else {
            return null;
        }
    }

    /*
     *查询所有的订单
     * @author RenBoQing
     * @date 2022/5/1 0001 21:37
     * @return java.util.List<com.rbq.code.vovo.UserOrderVo>
     */
    @Override
    public List<UserOrderVo> queryAllOrder() {
        List<UserOrderVo> userOrderVos = orderMapper.queryAllOrder();
        for (UserOrderVo userOrderVo : userOrderVos) {
            List<UserOrderItemVo> userOrderItemVos = orderMapper.queryUserOrderItemByOrderno(userOrderVo.getOrderno());
            for (UserOrderItemVo userOrderItemVo : userOrderItemVos) {
                if (userOrderItemVo.getOrderno().equals(userOrderVo.getOrderno())) {
                    userOrderVo.setUserOrderItemVoList(userOrderItemVos);
                }
            }
        }
        return userOrderVos;
    }

    /*
     *分页查询订单
     * @author RenBoQing
     * @date 2022/5/3 0003 10:45
     * @param page
     * @param pageSize
     * @param orderVo
     * @return com.github.pagehelper.PageInfo<com.rbq.code.vovo.OrderVo>
     */
    @Override
    public PageInfo<OrderVo> queryAllOrderPage(int page, int pageSize, OrderVo orderVo) {
        PageHelper.startPage(page, pageSize);
        List<OrderVo> orderVos = orderMapper.queryAllOrderDemo(orderVo);
        PageInfo<OrderVo> orderVoPageInfo = new PageInfo<>(orderVos);
        return orderVoPageInfo;
    }

    /*
     *删除订单
     * @author RenBoQing
     * @date 2022/5/3 0003 11:12
     * @param orderno
     * @return int
     */
    @Override
    public int deleteOrderByOrderNo(String orderno) {
        return orderMapper.deleteOrderByOrderNo(orderno);
    }
}

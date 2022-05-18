package com.rbq.code.mapper;

import com.rbq.code.entity.Order;
import com.rbq.code.entity.OrderItem;
import com.rbq.code.vovo.OrderVo;
import com.rbq.code.vovo.UserOrderItemVo;
import com.rbq.code.vovo.UserOrderVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年04月18日 19:43
 * @Description 订单表
 */
@Mapper
public interface OrderMapper {
    /*
     *添加订单
     * @author RenBoQing
     * @date 2022/4/18 0018 20:08
     * @param order
     * @return java.lang.Integer
     */
    Integer addOrder(Order order);

    /*
     *添加订单项
     * @author RenBoQing
     * @date 2022/4/18 0018 20:08
     * @param orderItem
     * @return java.lang.Integer
     */
    Integer addOrderItem(OrderItem orderItem);

    /*
     *查询所有的订单
     * @author RenBoQing
     * @date 2022/5/1 0001 21:31
     * @return java.util.List<com.rbq.code.vovo.UserOrderVo>
     */
    public List<UserOrderVo> queryAllOrder();

    /*
     *根据订单查询订单项
     * @author RenBoQing
     * @date 2022/5/1 0001 21:34
     * @param orderno
     * @return java.util.List<com.rbq.code.vovo.UserOrderItemVo>
     */
    public List<UserOrderItemVo> queryUserOrderItemByOrderno(String orderno);

    /*
     *查询所有的订单数据
     * @author RenBoQing
     * @date 2022/5/3 0003 10:17
     * @return java.util.List<com.rbq.code.vovo.OrderVo>
     */
    public List<OrderVo> queryAllOrderDemo( OrderVo orderVo);
    /*
     *删除订单信息
     * @author RenBoQing
     * @date 2022/5/3 0003 11:10
     * @param orderno
     * @return int
     */
    int deleteOrderByOrderNo(String orderno);
}

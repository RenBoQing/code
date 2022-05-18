package com.rbq.code.vovo;

import lombok.Data;

import java.util.List;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年04月30日 9:56
 * @Description 用户个人订单查询
 */
@Data
public class UserOrderVo {
    private String orderno;//订单编号
    private double totalprice;//订单总金额
    private String receivername;//收货人名称
    private Integer orderstatus;//订单状态
    private List<UserOrderItemVo> userOrderItemVoList;//订单拥有的商品的信息
}

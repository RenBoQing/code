package com.rbq.code.vovo;

import lombok.Data;

import java.util.Date;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年04月30日 10:13
 * @Description 订单的请求设置
 */
@Data
public class UserOrderItemVo {
    private String orderno;
    private String productname;
    private String protuctimg;
    private double price;
    private Integer count;
    private Date updatetime;
}

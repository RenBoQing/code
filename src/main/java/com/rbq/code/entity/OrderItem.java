package com.rbq.code.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年04月18日 19:09
 * @Description 订单项具体化
 */
@Data
public class OrderItem {
    private Integer id;
    private Integer orderid;
    private Integer productid;
    private String productname;
    private String protuctimg;
    private double protuctprice;
    private Date createtime;
    private Date updatetime;
    private Integer count;
}

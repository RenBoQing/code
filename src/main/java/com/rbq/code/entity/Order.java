package com.rbq.code.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年04月18日 19:04
 * @Description 订单实体
 */
@Data
public class Order {
    private Integer id;
    private String orderno;
    private Integer userid;
    private double totalprice;
    private String receivername;
    private String receiverphone;
    private String receiveraddr;
    private Integer orderstatus;
    private Integer payment;
    private Date paytime;
    private Date deliverytime;
    private Date updatetime;


}

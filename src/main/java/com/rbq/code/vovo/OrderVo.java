package com.rbq.code.vovo;

import lombok.Data;

import java.util.Date;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年05月03日 10:13
 * @Description
 */
@Data
public class OrderVo {
    private String orderno;
    private double totalprice;
    private String receivername;
    private String receiverphone;
    private Integer orderstatus;
    private String productname;
    private String protuctimg;
    private Integer count;
    private Integer payment;
    private Date updatetime;
}

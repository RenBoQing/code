package com.rbq.code.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author RenBoQing
 * @date 2022年04月17日 21:26
 * @Description 购物车
 */
@Data
public class Cart {
    private Integer id;
    private Integer productid;
    private Integer userid;
    private Integer count;
    private Double price;
    private Date createtime;
    private Date updatetime;
    private String selected;
}

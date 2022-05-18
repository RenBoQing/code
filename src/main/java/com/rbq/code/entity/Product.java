package com.rbq.code.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author RenBoQing
 * @date 2022年04月11日 19:45
 * @Description
 */
@Data
public class Product {
    private Integer id;
    private String name;
    private String image;
    private String detail;
    private Integer categoryid;
    private double price;
    private Integer stok;
    private String address;
    private double countprice;
    private String status;
    private Date createtime;
    private Date updatetime;
    private Category category;
}

package com.rbq.code.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author RenBoQing
 * @date 2022年04月11日 19:50
 * @Description
 */
@Data
public class Category {
    private Integer id;
    private String name;
    private Integer type;
    private Integer ordernum;
    private Date createtime;
    private Date updatetime;
    //    因为一个Category可以拥有多个商品 所以在一的那一方注入另外一个实体
    private Product product;
}

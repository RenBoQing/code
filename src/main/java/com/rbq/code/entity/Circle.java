package com.rbq.code.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年04月19日 14:57
 * @Description
 */
@Data
public class Circle {
    private Integer id;
    private String title;
    private Integer uid;
    private String image;
    private String imageone;
    private String imagetwo;
    private Integer viewcount;
    private String address;
    private Integer count;
    private String comment;
    private Date createtime;
    private Date updatetime;
}

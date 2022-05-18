package com.rbq.code.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author RenBoQing
 * @date 2022年04月09日 11:27
 * @Description 动物领养
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adopt {
    private Integer id;
    private String name;
    private Integer sex;
    private String age;
    private String image;
    private String address;
    private String situation;
    private String description;
    private String rescueinfo;
    private String category;
    private Integer status;
    private Date createtime;
    private Date updaetime;
}

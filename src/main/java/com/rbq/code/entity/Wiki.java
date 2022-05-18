package com.rbq.code.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author RenBoQing
 * @date 2022年04月04日 17:03
 * @Description 宠物百科
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Wiki {
    private Integer id;
    private String name;
    private String chinesename;
    private String nickname;
    private String area;
    private String shape;
    private String age;
    private String character;
    private String living;
    private String feeding;
    private String imageone;
    private String imagetwo;
    private String category;
    private String imagethree;
    private  Date  createtime;
}

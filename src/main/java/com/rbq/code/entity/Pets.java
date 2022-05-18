package com.rbq.code.entity;

import lombok.Data;

/**
 * @author RenBoQing
 * @date 2022年04月02日 17:10
 * @Description 动物实体类
 */
@Data
public class Pets {
    private Integer pid;
    private Integer uid;
    private String nickname;
    private String birthday;
    private String sex;
    private String hobby;
    private String feedingtime;
}

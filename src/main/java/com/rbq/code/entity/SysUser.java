package com.rbq.code.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author RenBoQing
 * @date 2022年03月24日 11:12
 * @Description
 */
@Data
public class SysUser implements Serializable {
    private Integer aid;
    private String username;
    private String password;
    private String avatar;
    private String realname;
    private String description;
}
package com.rbq.code.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author RenBoQing
 * @date 2022年03月31日 15:37
 * @Description 菜单实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    private Integer mid;
    private Integer parentId;
    private Integer type;
    private String name;
    private String permission;
    private String url;
    private Integer status;
    private Integer sort;
    private Integer createBy;
    private Date createTime;
    private Date updateTime;
}

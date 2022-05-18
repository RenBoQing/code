package com.rbq.code.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年05月01日 22:02
 * @Description
 */
@Data
public class Help {
    private Integer id;
    private Integer userid;
    private Integer ischecked;
    private String content;
    private String keywords;
    private Date createtime;
}

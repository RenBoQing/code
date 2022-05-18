package com.rbq.code.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年04月22日 19:32
 * @Description
 */
@Data
public class Message {
    private Integer messageid;
    private Integer fromuid;
    private Integer touid;
    private String content;
    private Date sendtime;
}

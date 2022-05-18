package com.rbq.code.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年04月22日 19:29
 * @Description
 */
@Data
public class Chatlist {
    private Integer listid;
    private Integer fromuid;
    private String fromname;
    private String fromava;
    private Integer fromstatus;
    private String lastcontext;
    private Integer touid;
    private Date sendtime;

}

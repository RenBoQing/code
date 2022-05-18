package com.rbq.code.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author RenBoQing
 * @date 2022年04月12日 21:41
 * @Description
 */
@Data
public class Welfare implements Serializable {
    private Integer id;
    private String name;
    private String foundationname;
    private String imagesone;
    private String imagestwo;
    private String imagesthree;
    private String detail;
    private String description;
    private Integer count;
    private Date createtime;
}

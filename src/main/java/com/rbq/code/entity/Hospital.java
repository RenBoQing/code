package com.rbq.code.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年03月25日 10:47
 * @Description 医院实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hospital implements Serializable {
    private Integer hid;
    private String hname;
    private String haddress;
    private String hdetalis;
    private String himage;
    private Date updatetime;
    private String telephone;
    private Integer status;
    private Date createtime;
    private Integer wid;
    private String businesstime;
    private Integer departmentnumber;
    private List<HopsptialProject> hopsptialProjectList;
}

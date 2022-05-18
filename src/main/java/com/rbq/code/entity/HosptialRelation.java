package com.rbq.code.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author RenBoQing
 * @date 2022年04月12日 15:12
 * @Description 医院与护理项目实体类
 */
@Data
public class HosptialRelation implements Serializable {
    private Integer id;
    private Integer hsid;
    private Integer sid;
}

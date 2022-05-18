package com.rbq.code.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年04月28日 10:17
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HosptialServiceVo {
    private Integer id;
    private String name;
    private String price;
    private Integer status;
}

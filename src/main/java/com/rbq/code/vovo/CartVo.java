package com.rbq.code.vovo;

import com.rbq.code.entity.Pets;
import lombok.Data;

import java.io.Serializable;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年04月18日 15:25
 * @Description  购物车多表实体类VO
 */
@Data
public class CartVo  implements Serializable {
    private Integer cid ;
    private Integer userid;
    private Integer pid;
    private double price;
    private Integer count;
    private String detail;
    private String image;
    private double realprice;
    private String productname;
    private String select;
}

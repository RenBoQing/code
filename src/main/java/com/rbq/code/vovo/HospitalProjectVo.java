package com.rbq.code.vovo;

import com.rbq.code.entity.HopsptialProject;
import lombok.Data;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年04月12日 16:42
 * @Description
 */
@Data
public class HospitalProjectVo {
    private Integer rid;
    private Integer hid;
    private String hname;
    private String himage;
    private String telephone;
    private String haddress;
    private String name;
    private String price;
    private Integer status;
}

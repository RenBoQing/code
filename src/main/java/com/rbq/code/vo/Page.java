package com.rbq.code.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author RenBoQing
 * @date 2022年03月25日 11:10
 * @Description 分页设置
 */
@Data
public class Page implements Serializable {
    private Integer page;
    private Integer limit;
    public  Long getStart(){
        return (page-1L)*limit;
    }
}

package com.rbq.code.vovo;

import lombok.Data;

import java.util.Date;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年04月29日 21:41
 * @Description 用户发布个人动态VO
 */
@Data
public class UserCommVo {
    private Integer cid; //用户发布文章的id
    private Integer uid;//用户的id
    private String title;//文章的标题
    private Integer count;//点赞数
    private Integer comcount;//评论数
    private String image;//文章的第一张图片
    private String imageone;//文章的第二张图片
    private Date createtime;//文章发布的时间
}

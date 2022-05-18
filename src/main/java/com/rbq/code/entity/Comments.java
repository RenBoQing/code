package com.rbq.code.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年04月19日 20:27
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comments {
    private Integer id; //回复的id
    private Integer cid;//文章的id
    private Integer uid;//评论的用户id
    private String details;//评论的细节
    private Integer likenumber;//点赞数
    private Date createtime;//创建时间
}

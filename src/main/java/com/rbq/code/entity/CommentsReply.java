package com.rbq.code.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年04月19日 20:41
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsReply {
    private Integer id; //回复表的id
    private Integer coid;//回复主表id
    private Integer cuid; // 回復主表的用户id
    private Integer uid;//回复评论的用户id
    private String comment;//回复的内容
    private Date createtime;//创建时间
}

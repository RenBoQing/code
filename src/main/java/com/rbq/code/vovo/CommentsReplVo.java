package com.rbq.code.vovo;

import lombok.Data;

import java.util.Date;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年04月25日 11:21
 * @Description
 */
@Data
public class CommentsReplVo {
    private Integer commentid;//一级评论的id
    private Integer rid;//二级评论id
    private Integer ruid;//二级评论用户id
    private String rnickname;//二级评论用户的昵称
    private String ravatarurl; //二级评论用户的头像地址
    private String rcomtent; //二级评论细节
    private Date rcreatetime; //评论创建时间
}

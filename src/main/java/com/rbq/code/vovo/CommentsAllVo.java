package com.rbq.code.vovo;

import lombok.Data;

import java.util.Date;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年04月24日 19:36
 * @Description
 */
@Data
public class CommentsAllVo {
    private Integer cid; //文章的id
    private Integer commentid; //一级评论的id
    private String cnickname;//一级评论的用户名称
    private String cavatarurl; //一级评论的用户昵称
    private String cdetails; //一级评论的细节
    private Integer clikenumber; //一级评论点赞数
    private Date ccreatetime;
    private Integer rid;//二级评论id
    private String rnickname;//二级评论用户的昵称
    private String ravatarurl; //二级评论用户的头像地址
    private String rcomtent; //二级评论细节
    private Date rcreatetime;
}

package com.rbq.code.vovo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年04月25日 11:20
 * @Description
 */
@Data
public class CommentsVoTe {
    private Integer cid; //文章的id
    private Integer commentid; //一级评论的id
    private String cnickname;//一级评论的用户名称
    private String cavatarurl; //一级评论的用户昵称
    private Integer cuid;//一级评论用户的id
    private String cdetails; //一级评论的细节
    private Integer clikenumber; //一级评论点赞数
    private Date ccreatetime;
    private List<CommentsReplVo> commentsReplVoList;//拥有的二级评论
}
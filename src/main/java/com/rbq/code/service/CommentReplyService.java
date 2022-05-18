package com.rbq.code.service;

import com.rbq.code.entity.CommentsReply;

/**
 * @author RenBoQing
 * @date 2022年04月20日 10:32
 * @Description
 */
public interface CommentReplyService {
    /*
     *添加二级评论
     * @author RenBoQing
     * @date 2022/4/25 0025 17:11
     * @param commentsReply
     * @return int
     */
    int addCommentReply(CommentsReply commentsReply);
}

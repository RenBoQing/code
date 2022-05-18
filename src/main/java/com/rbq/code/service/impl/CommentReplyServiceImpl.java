package com.rbq.code.service.impl;

import com.rbq.code.entity.CommentsReply;
import com.rbq.code.mapper.CommentsReplyMapper;
import com.rbq.code.service.CommentReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author RenBoQing
 * @date 2022年04月20日 10:33
 * @Description
 */
@Service
public class CommentReplyServiceImpl implements CommentReplyService {
    @Autowired
    private CommentsReplyMapper commentsReplyMapper;
    @Override
    public int addCommentReply(CommentsReply commentsReply) {
        //commentsReplyMapper.addCommentReply(commentsReply);
        return commentsReplyMapper.addCommentReply(commentsReply);
    }
}

package com.rbq.code.mapper;

import com.rbq.code.entity.CommentsReply;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author RenBoQing
 * @date 2022年04月20日 9:38
 * @Description
 */
@Mapper
public interface CommentsReplyMapper {
 int addCommentReply(CommentsReply commentsReply);
}

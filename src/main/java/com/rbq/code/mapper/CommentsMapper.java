package com.rbq.code.mapper;

import com.rbq.code.entity.Comments;
import com.rbq.code.entity.CommentsReply;
import com.rbq.code.vovo.CommentsAllVo;
import com.rbq.code.vovo.CommentsReplVo;
import com.rbq.code.vovo.CommentsVoTe;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年04月19日 20:54
 * @Description
 */
@Mapper
public interface CommentsMapper {
    /*
     *一级评论添加
     * @author RenBoQing
     * @date 2022/4/25 0025 9:20
     * @param comments
     * @return int
     */
    int addComments(Comments comments);
    /*
     *查询所有的评论
     * @author RenBoQing
     * @date 2022/4/25 0025 9:21
     * @param null
     * @return null
     */
     List<CommentsAllVo> queryAllCommentsByCid(Integer cid);
     //通过 文章的id查询一级评论
      List<CommentsVoTe> queryAllByCid(Integer cid);
      //通过一级评论的id查询二级评论
     List<CommentsReplVo>  queryReplVoBycomid(Integer commid);
}

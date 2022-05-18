package com.rbq.code.service;

import com.rbq.code.entity.Comments;
import com.rbq.code.vovo.CommentsAllVo;
import com.rbq.code.vovo.CommentsVoTe;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年04月20日 9:51
 * @Description
 */
public interface CommentsService {
    /*
     *添加一级评论
     * @author RenBoQing
     * @date 2022/4/25 0025 9:32
     * @param comments
     * @return int
     */
    int addComments(Comments comments);

    /*
     *查询当前
     * @author RenBoQing
     * @date 2022/4/25 0025 9:32
     * @param cid
     * @return java.util.List<com.rbq.code.vovo.CommentsAllVo>
     */
    List<CommentsAllVo> queryAllCommentsByCid(Integer cid);

    /*
     *  二级查询法 先通过文章的id查询一级评论
     * @author RenBoQing
     * @date 2022/4/25 0025 13:46
     * @param cid
     * @return java.util.List<com.rbq.code.vovo.CommentsVoTe>
     */
    List<CommentsVoTe> queryAllByCid(Integer cid);
}

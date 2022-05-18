package com.rbq.code.service.impl;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年04月20日 10:18
 * @Description 注入服务的接口
 */

import com.rbq.code.entity.Comments;
import com.rbq.code.mapper.CommentsMapper;
import com.rbq.code.service.CommentsService;
import com.rbq.code.vovo.CommentsAllVo;
import com.rbq.code.vovo.CommentsReplVo;
import com.rbq.code.vovo.CommentsVoTe;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    private CommentsMapper commentsMapper;

    /*
     *添加评论
     * @author RenBoQing
     * @date 2022/4/20 0020 10:21
     * @param comments
     * @return int
     */
    @Override
    public int addComments(Comments comments) {
        return commentsMapper.addComments(comments);
    }

    /*
     *根据文章cid查询所有评论
     * @author RenBoQing
     * @date 2022/4/25 0025 9:41
     * @param cid
     * @return java.util.List<com.rbq.code.vovo.CommentsAllVo>
     */
    @Override
    public List<CommentsAllVo> queryAllCommentsByCid(Integer cid) {
        List<CommentsAllVo> commentsAllVos = commentsMapper.queryAllCommentsByCid(cid);
        return commentsAllVos;
    }

    /*
     *查询所有的评论
     * @author RenBoQing
     * @date 2022/4/25 0025 16:50
     * @param cid
     * @return java.util.List<com.rbq.code.vovo.CommentsVoTe>
     */
    @Override
    public List<CommentsVoTe> queryAllByCid(Integer cid) {
        List<CommentsVoTe> commentsVoTes = commentsMapper.queryAllByCid(cid);
        for (CommentsVoTe commentsVoTe : commentsVoTes) {
            List<CommentsReplVo> commentsReplVos = commentsMapper.queryReplVoBycomid(commentsVoTe.getCommentid());
            for (CommentsReplVo commentsReplVo : commentsReplVos) {
                if(!StringUtils.isEmpty(commentsReplVo.getRcomtent())){
                    commentsVoTe.setCommentsReplVoList(commentsReplVos);
                }
            }
        }
        return commentsVoTes;
    }
}

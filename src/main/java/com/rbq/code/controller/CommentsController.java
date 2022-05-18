package com.rbq.code.controller;
import com.rbq.code.entity.Comments;
import com.rbq.code.entity.CommentsReply;
import com.rbq.code.mapper.CommentsMapper;
import com.rbq.code.service.CommentReplyService;
import com.rbq.code.service.CommentsService;
import com.rbq.code.vo.JsonObject;
import com.rbq.code.vovo.CommentsAllVo;
import com.rbq.code.vovo.CommentsVoTe;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author RenBoQing&HuHanYue
 * @date 2022年04月20日 10:22
 * @Description 评论添加
 */
@Slf4j
@Controller
    @RequestMapping("/comments")
public class CommentsController {
    @Autowired
    private CommentsService commentsService;
    @Autowired
    private CommentReplyService commentReplyService;
    /*
     *一级添加评论
     * @author RenBoQing
     * @date 2022/4/20 0020 10:24
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/add")
    @ResponseBody
    public JsonObject addComments(Integer cid, Integer uid, String details) {
        Comments comments = new Comments();
        comments.setCid(cid);
        comments.setUid(uid);
        comments.setLikenumber(1);
        comments.setDetails(details);
        comments.setCreatetime(new Date());
        int addComments = commentsService.addComments(comments);
        //先添加以后在查询
        List<Comments> commentsList = new ArrayList<>();
        commentsList.add(comments);
        if (addComments > 0) {
            return JsonObject.success(0, commentsList, "添加成功", (long) commentsList.size());
        } else {
            return JsonObject.fail(1, "添加失败");
        }
    }
    /*
     *二级添加评论
     * @author RenBoQing
     * @date 2022/4/20 0020 11:23
     * @param coid
     * @param uid
     * @param cuid
     * @param comment
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/addrpl")
    @ResponseBody
    public JsonObject addCommentsRpl(Integer coid, Integer uid, Integer cuid, String comment) {
        CommentsReply commentsReply = new CommentsReply();
        commentsReply.setCoid(coid);
        commentsReply.setComment(comment);
        commentsReply.setCreatetime(new Date());
        commentsReply.setUid(uid);
        commentsReply.setCuid(cuid);
        System.out.println(commentsReply.toString());

        int addCommentReply = commentReplyService.addCommentReply(commentsReply);
        List<CommentsReply> commentsReplyList = new ArrayList<>();
        commentsReplyList.add(commentsReply);
        if (addCommentReply > 0) {
            return JsonObject.success(0, commentsReplyList, "添加成功", (long) commentsReplyList.size());
        } else {
            return JsonObject.fail(1, "添加失败");
        }
    }
    @RequestMapping("/queryAllCommentsByCid")
    @ResponseBody
    public JsonObject queryAllCommentsByCid( Integer cid){
        List<CommentsAllVo> commentsAllVos = commentsService.queryAllCommentsByCid(cid);
        if(commentsAllVos.size()>0){
            return JsonObject.success(0,commentsAllVos,"查询成功", (long) commentsAllVos.size());
        }
        else {
            return JsonObject.fail(1, "该说说无评论");
        }
    }
     /*
      *
      * @author RenBoQing
      * @date 2022/4/25 0025 14:12
      * @param cid
      * @return com.rbq.code.vo.JsonObject
      */
    @RequestMapping("/queryAllByCid")
    @ResponseBody
    public JsonObject queryAllByCid(Integer cid){
        List<CommentsVoTe> commentsVoTes = commentsService.queryAllByCid(cid);
        if(commentsVoTes.size()>0){
            return JsonObject.success(0,commentsVoTes,"查询成功", (long) commentsVoTes.size());
        }
        else {
            return JsonObject.fail(1, "该说说无评论");
        }
    }
}
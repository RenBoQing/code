package com.rbq.code.service.impl;

import com.alibaba.fastjson.JSON;
import com.rbq.code.entity.Chatlist;
import com.rbq.code.entity.Message;
import com.rbq.code.entity.User;
import com.rbq.code.mapper.ChatlistMapper;
import com.rbq.code.mapper.MessageMapper;
import com.rbq.code.mapper.UserMapper;
import com.rbq.code.service.ChatService;
import com.rbq.code.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author RenBoQing
 * @date 2022年05月02日 15:48
 * @Description
 */
@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    private ChatlistMapper chatlistMapper;
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private UserMapper userMapper;

    /*
     *添加消息記錄
     * @author RenBoQing
     * @date 2022/5/2 0002 16:25
     * @param message
     */
    @Override
    public void addInfo(String message) {
        Message msg = JSON.parseObject(message, Message.class);
        Chatlist chatlist = new Chatlist();
        Chatlist chatlist1 = chatlistMapper.selectByTwoUid(msg.getFromuid(), msg.getTouid());
        Chatlist chatlist2 = chatlistMapper.selectByTwoUid(msg.getFromuid(), msg.getTouid());
        //    展现私信列表
        if (chatlist1 == null && chatlist2 == null) {
            User user = userMapper.queryUserById(msg.getFromuid());
            chatlist.setFromuid(user.getId());
            chatlist.setFromava(user.getAvatarurl());
            chatlist.setFromname(user.getNickname());
            chatlist.setLastcontext(msg.getContent());
            chatlist.setTouid(msg.getTouid());
            chatlist.setSendtime(new Date());
            chatlistMapper.insert(chatlist);
            User user1 = userMapper.queryUserById(msg.getTouid());
            chatlist.setFromuid(user1.getId());
            chatlist.setFromava(user1.getAvatarurl());
            chatlist.setFromstatus(user1.getStatus());
            chatlist.setFromname(user1.getNickname());
            chatlist.setTouid(msg.getTouid());
            chatlistMapper.insert(chatlist);
        } else {
            //消息更新
            chatlist1.setSendtime(new Date());
            chatlist1.setLastcontext(msg.getContent());
            chatlistMapper.updateByPrimaryKey(chatlist1);
            chatlist1.setSendtime(new Date());
            chatlist2.setLastcontext(msg.getContent());
            chatlistMapper.updateByPrimaryKey(chatlist2);
        }
    }

    /*
     *添加消息记录
     * @author RenBoQing
     * @date 2022/5/2 0002 16:37
     * @param message
     */
    @Override
    public void addDeInfo(Message message) {
        message.setSendtime(new Date());
        message.setContent(message.getContent());
        messageMapper.insert(message);
    }

    @Override
    public ArrayList<Message> getAllNotRead(Integer fromuid, Integer touid) {

        return messageMapper.selectByUid(fromuid, touid);
    }

    @Override
    public Msg getUserInfoList(Integer fromuid) {
        ArrayList<Chatlist> chatlists = chatlistMapper.selectByUid(fromuid);
        if (chatlists != null) {
            return Msg.fail();
        }
        return Msg.success().add("chatlists", chatlists);
    }

    @Override
    public Msg getNotice(String openid, Integer type) {
        return null;
    }

    @Override
    public Msg deleteCommentsNotice(String openid, Integer type) {
        return null;
    }

    /*
     *
     * @author RenBoQing
     * @date 2022/5/2 0002 16:54
     * @param myOpenid
     * @param beDeleteOpenid
     * @return com.rbq.code.utils.Msg
     */
    @Override
    public Msg deleteList1(Integer myuid, Integer betouid) {
        Chatlist chatlist = chatlistMapper.selectByTwoUid(betouid, myuid);
        System.out.println(chatlist);
        int deleteByPrimaryKey = chatlistMapper.deleteByPrimaryKey(chatlist.getListid());
        if(deleteByPrimaryKey>0){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
}

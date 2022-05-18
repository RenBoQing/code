package com.rbq.code.service;

import com.rbq.code.entity.Message;
import com.rbq.code.utils.Msg;

import java.util.ArrayList;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年05月02日 15:40
 * @Description
 */
public interface ChatService {
    void addInfo(String message);
    void addDeInfo(Message message);
    ArrayList<Message> getAllNotRead(Integer fromuid, Integer touid);
    Msg getUserInfoList(Integer fromuid);
    Msg getNotice(String openid,Integer type);
    Msg deleteCommentsNotice(String openid, Integer type);
    Msg deleteList1(Integer myuid, Integer betouid );
}

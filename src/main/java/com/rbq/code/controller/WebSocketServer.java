package com.rbq.code.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rbq.code.entity.Message;
import com.rbq.code.service.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author RenBoQing
 * @date 2022年05月02日 17:07
 * @Description
 */
@Slf4j
@ServerEndpoint(value = "/wx/{fromuid}/{touid}")
@Component
public class WebSocketServer {
    public static WebSocketServer webSocketServer;
    @Autowired
    private ChatService chatService;
    @PostConstruct        //此注解的方法在bean加载前执行
    private void init() {
        webSocketServer = this;
        //初始化时将静态化的interFaceInfoMapper进行了实例化
        webSocketServer.chatService = this.chatService;
    }
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static AtomicInteger onlineNum = new AtomicInteger();
    //concurrent包的线程安全HashMap，用来存放每个客户端对应的WebSocketServer对象。
    private static ConcurrentHashMap<Integer, Session> sessionPools = new ConcurrentHashMap<>();
    //发送消息
    public void sendMessage(Session session, Message message) throws IOException {
        if (session != null) {
            synchronized (session) {
                String s = JSONObject.toJSONString(message);
                System.out.println("52 发送数据：" + s);
                session.getBasicRemote().sendText(s);
            }
        }
    }
    //给指定用户发送信息
    public void sendInfo(Integer touid, Message message){
        Session session = sessionPools.get(touid);
        if(session == null){
            webSocketServer.chatService.addDeInfo(message);
        }else{
            try {
                sendMessage(session, message);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    // 群发消息
    public void broadcast(Message message){
        for (Session session: sessionPools.values()) {
            try {
                sendMessage(session, message);
            } catch(Exception e){
                e.printStackTrace();
                continue;
            }
        }
    }
    //收到客户端信息后，根据接收人的username把消息推下去或者群发
    // to=-1群发消息
    @OnMessage
    public void onMessage(String message) throws IOException{
        Message msg= JSON.parseObject(message, Message.class);
        sessionPools.get(msg.getTouid());
        webSocketServer.chatService.addInfo(message);
        if (msg.getTouid()==-1) {
            broadcast(msg);
        } else {
            sendInfo(msg.getTouid(),msg);
        }
    }
    //建立连接成功调用
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "fromuid") Integer fromuid, @PathParam(value = "touid") Integer touid) throws IOException {
        ArrayList<Message> list = webSocketServer.chatService.getAllNotRead(fromuid,touid);
        if (!list.isEmpty()) {
            Iterator<Message> it = list.iterator();
            while (it.hasNext()) {
                Message chatMessage = it.next();
                chatMessage.setContent(chatMessage.getContent());
                sendMessage(session, chatMessage);
                log.info("115 当前用户接收离线消息" + chatMessage.toString());
            }
        }
        sessionPools.put(fromuid, session);
        addOnlineCount();
        System.out.println("125 "+fromuid + "加入webSocket！当前人数为" + onlineNum);
    }

    @OnClose
    public void onClose(@PathParam(value = "fromuid") Integer fromuid) throws IOException {

        Session session = sessionPools.get(fromuid);

        session.close();
        sessionPools.remove(fromuid);

        subOnlineCount();
        System.out.println(fromuid + "断开webSocket连接！当前人数为" + onlineNum);
    }
    //错误时调用
    @OnError
    public void onError(Session session, Throwable throwable){
        // System.out.println("发生错误");
        throwable.printStackTrace();
    }
    public static void addOnlineCount(){
        onlineNum.incrementAndGet();
    }
    public static void subOnlineCount() {
        onlineNum.decrementAndGet();
    }

    public static AtomicInteger getOnlineNumber() {
        return onlineNum;
    }
    public static ConcurrentHashMap<Integer, Session> getSessionPools() {
        return sessionPools;
    }
}

package com.hrp.web;

import com.hrp.util.WebSocketUtils;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * WebSocket控制器，使用javax的websocket
 *
 * @author herenpeng
 * @since 2020-09-20 11:27
 */
@Component
@ServerEndpoint("/websocket")
public class MyWebSocket {

    private Session session;

    /**
     * WebSocket连接建立后触发的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        WebSocketUtils.put(session.getId(), this);
        System.out.println("-------- onOpen: 当前在线人数 " + WebSocketUtils.getOnlineCount() + "，连接人 " + session.getId() + " --------");
    }

    /**
     * 连接关闭后触发的方法
     */
    @OnClose
    public void onClose() {
        // 从map中删除
        WebSocketUtils.remove(session.getId());
        System.out.println("-------- onClose: 当前在线人数 " + WebSocketUtils.getOnlineCount() + "，关闭人 " + session.getId() + " --------");
    }

    /**
     * 接收到客户端消息时触发的方法
     */
    @OnMessage
    public void onMessage(String message, Session session) throws Exception {
        // 获取服务端到客户端的通道
        MyWebSocket myWebSocket = WebSocketUtils.get(session.getId());
        System.out.println("收到来自 " + session.getId() + " 的消息：" + message);

        // 返回消息给Web Socket客户端（浏览器）
        myWebSocket.sendMessageAll("服务端已收到消息：" + message);
    }

    /**
     * 发生错误时触发的方法
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("-------- onError: 当前在线人数 " + WebSocketUtils.getOnlineCount() + "，连接发生错误 " + session.getId() + "-"+ error.getMessage() + " --------");
        error.printStackTrace();
    }

    /**
     * 给单个客户端发送消息
     * @param message
     * @param sessionId
     * @throws IOException
     */
    public void sendMessageSingle(String message, String sessionId) throws IOException {
        // session.getBasicRemote().sendText(message); 同步消息
        // session.getAsyncRemote().sendText(message); 异步消息

        MyWebSocket myWebSocket = WebSocketUtils.get(sessionId);
        if(myWebSocket != null) {
            myWebSocket.session.getBasicRemote().sendText(message);
        }
    }

    /**
     * 给所有客户端发送消息
     * @param message
     * @throws IOException
     */
    public void sendMessageAll(String message) throws IOException {
        for (MyWebSocket item : WebSocketUtils.getValues() ) {
            item.session.getAsyncRemote().sendText(message);
            System.out.println(item.session.getId());
            System.out.println(item.session.isSecure());
            System.out.println(item.session.isOpen());
        }
    }


}

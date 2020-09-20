package com.hrp.handler;

import com.hrp.util.WebSocketHandlerUtils;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;

/**
 * WebSocket拦截器
 *
 * @author herenpeng
 * @since 2020-09-20 17:18
 */
public class MyWebSocketHandler extends AbstractWebSocketHandler {
    public MyWebSocketHandler() {
        super();
    }

    /**
     * 连接
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        WebSocketHandlerUtils.put(session.getId(), session);
        System.out.println("-------- onOpen: 当前在线人数 " + WebSocketHandlerUtils.getOnlineCount() + "，连接人 "
                + session.getId() + " --------");
    }

    /**
     * 关闭
     * @param session
     * @param status
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // 从map中删除
        WebSocketHandlerUtils.remove(session.getId());
        System.out.println("-------- onClose: 当前在线人数 " + WebSocketHandlerUtils.getOnlineCount() + "，关闭人 " + session.getId() + " --------");
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // super.handleTextMessage(session, message);
        // 获取服务端到客户端的通道
        System.out.println("收到来自 " + session.getId() + " 的消息：" + message.getPayload());

        // 返回消息给Web Socket客户端（浏览器）
        sendMessageAll("服务端已收到消息：" + message);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
        System.out.println("-------- onError: 当前在线人数 " + WebSocketHandlerUtils.getOnlineCount() + "，连接发生错误 " + session.getId() + "-"+ exception.getMessage() + " --------");
    }


    /**
     * 给单个客户端发送消息
     * @param message
     * @param sessionId
     * @throws IOException
     */
    public void sendMessageSingle(String message, String sessionId) throws IOException {

        WebSocketSession session = WebSocketHandlerUtils.get(sessionId);
        if(session != null) {
            session.sendMessage(new TextMessage(message));
        }
    }

    /**
     * 给所有客户端发送消息
     * @param message
     * @throws IOException
     */
    public void sendMessageAll(String message) throws IOException {
        for (WebSocketSession session : WebSocketHandlerUtils.getValues() ) {

            session.sendMessage(new TextMessage(message));
        }
    }

}

package com.cheney.wesocket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * WebSocket spring封装的底层api
 * 通过继承AbstractWebSocketHandler树实现
 * 再通过继承WebSocketConfigurer配置映射路径等
 */
public class WebSocketMessageHandler extends TextWebSocketHandler {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.info("---------afterConnectionEstablished------------");
    }

    @Override
    public void handleMessage(WebSocketSession session, org.springframework.web.socket.WebSocketMessage<?> message) throws Exception {
        logger.info("---------handleMessage------------\r\n" + message.getPayload().toString());
        Thread.sleep(2000);
        session.sendMessage(new TextMessage("return"));
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info("---------handleMessage------------\r\n" + message);
        Thread.sleep(2000);
        session.sendMessage(new TextMessage("return"));
    }

    @Override
    protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
        super.handlePongMessage(session, message);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        super.handleTransportError(session, exception);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        logger.info("---------afterConnectionClosed------------" + status);
    }
}

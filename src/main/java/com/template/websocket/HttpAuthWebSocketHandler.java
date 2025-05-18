package com.template.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class HttpAuthWebSocketHandler extends TextWebSocketHandler {
    private static final Map<String, WebSocketSession> SESSION_MAP = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.warn("已连接,session_id={},当前连接数={}", session.getId(), SESSION_MAP.size());
        SESSION_MAP.put(session.getId(), session);
        session.sendMessage(new TextMessage("已连接,session_id=" + session.getId() + ",当前连接数=" + SESSION_MAP.size()));
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.warn("server 接收到 {} 发送的 {}", session.getId(), payload);
        session.sendMessage(new TextMessage("server已收到:" + payload ));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        log.warn("已断开,session_id={}当前连接数={}", session.getId(), SESSION_MAP.size());
        SESSION_MAP.remove(session.getId());
    }
}
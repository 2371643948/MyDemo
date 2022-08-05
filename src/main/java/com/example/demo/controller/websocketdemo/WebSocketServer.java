package com.example.demo.controller.websocketdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/*
 * create : 17-07-21
 * auth : milo
 */
@ServerEndpoint("/connect/{userId}")
@Component
@Slf4j
public class WebSocketServer {

    /*
    New Connected
     */
    @OnOpen
    public void onOpen(@PathParam("userId") String userId ,
                       Session session){
        log.info("[WebSocketServer] Connected : userId = "+ userId);
        WebSocketUtils.add(userId , session);
    }

    /*
    Send Message
     */
    @OnMessage
    public String onMessage(@PathParam("userId") String userId,
                            String message) {
        log.info("[WebSocketServer] Received Message : userId = "+ userId + " , message = " + message);
        if (message.equals("&")){
            return "&";
        }else{
            WebSocketUtils.receive(userId , message);
            return "Got your message ("+ message +").";
        }
    }

    /*
    Errot
     */
    @OnError
    public void onError(@PathParam("userId") String userId,
                        Throwable throwable,
                        Session session) {

        log.info("[WebSocketServer] Connection Exception : userId = "+ userId + " , throwable = " + throwable.getMessage());
        WebSocketUtils.remove(userId);
    }

    /*
    Close Connection
     */
    @OnClose
    public void onClose(@PathParam("userId") String userId,
                        Session session) {
        log.info("[WebSocketServer] Close Connection : userId = " + userId);
        WebSocketUtils.remove(userId);
    }
}
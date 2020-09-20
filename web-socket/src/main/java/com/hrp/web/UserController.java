package com.hrp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * 用户的控制器
 *
 * @author herenpeng
 * @since 2020-09-20 21:37
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private MyWebSocket myWebSocket;

    @GetMapping("send")
    public void send(String message) throws IOException {
        myWebSocket.sendMessageAll(message);
    }

}

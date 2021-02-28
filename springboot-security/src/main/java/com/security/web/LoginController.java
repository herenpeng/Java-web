package com.security.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author hrp
 * 2020/3/26 16:58
 */
@Controller
public class LoginController {

    /**
     *
     * @return
     */
    @GetMapping("login")
    public String login(){
        return "login";
    }

    /**
     *
     * @return
     */
    @GetMapping("index")
    public String loginSuccess(){
        System.out.println("index页面");
        return "index";
    }

}

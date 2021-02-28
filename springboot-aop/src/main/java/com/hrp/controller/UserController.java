package com.hrp.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author herenpeng
 * @since 2020-11-01 16:54
 */
@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping
    public String user() {
        System.out.println("[Controller]执行controller方法");
        return "正常执行";
    }

    @GetMapping("e")
    public String e() {
        System.out.println("[Controller]执行controller方法:异常之前");
        int i = 1 / 0;
        System.out.println("[Controller]执行controller方法:异常之后");
        return "发生异常";
    }

}

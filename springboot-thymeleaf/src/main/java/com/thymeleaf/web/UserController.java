package com.thymeleaf.web;

import com.thymeleaf.domain.User;
import com.thymeleaf.service.ThymeleafService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;

/**
 * @author hrp
 * 2020/3/24 20:03
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private ThymeleafService thymeleafService;

    @GetMapping("hello")
    public String hello(Model model) throws FileNotFoundException {
        User user = new User(1,"张三",20);
        model.addAttribute("user",user);
        model.addAttribute("msg", "Hello, Thymeleaf!");
        thymeleafService.createHtml();
        return "hello";
    }
}

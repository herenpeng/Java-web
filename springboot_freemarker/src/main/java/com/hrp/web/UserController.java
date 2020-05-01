package com.hrp.web;

import com.hrp.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author hrp
 * 2020/5/1 14:53
 */
@Controller
public class UserController {

    @RequestMapping("/user")
    public String findUser(Model model) {
        List<User> users = new ArrayList<>();
        users.add(new User("张三","123"));
        users.add(new User("李四","123"));

        model.addAttribute("users", users);
        model.addAttribute("hello","hello world");
        model.addAttribute("now",new Date());
        model.addAttribute("num",100);

        return "index";
    }
}

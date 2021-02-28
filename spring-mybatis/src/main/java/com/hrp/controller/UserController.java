package com.hrp.controller;

import com.hrp.domain.User;
import com.hrp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author hrp
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("list")
    public String findAll(Model model) throws Exception{
        List<User> list = userService.findAll();
        model.addAttribute("list",list);
        return "list";
    }

    @RequestMapping("delete/{id}")
    public String deleteUser(@PathVariable Integer id) throws Exception{
        userService.deleteUser(id);
        return "forward:/user/list";
    }

    @RequestMapping("save")
    public String save(User user) throws Exception {
        userService.save(user);
        return "forward:/user/list";
    }



}

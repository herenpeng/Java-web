package com.security.web;

import com.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

/**
 * @author hrp
 * 2020/3/26 15:29
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("page")
    public String hello() {
        return "user page";
    }

    @GetMapping("list")
    public String dba() {
        return "user list";
    }

    @GetMapping("update")
    public String admin() {
        return "user update";
    }


    @GetMapping("delete")
    public String delete() {
        return "user delete";
    }



}

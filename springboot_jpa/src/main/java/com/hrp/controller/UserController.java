package com.hrp.controller;

import com.hrp.domain.User;
import com.hrp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author hrp
 * 2020/2/23 10:10
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("page/{pageNum}")
    public ResponseEntity<Page<User>> findByPage(
            @PathVariable("pageNum") Integer pageNum,
            @RequestParam(defaultValue = "5") Integer pageSize){
        return ResponseEntity.ok(userService.findByPage(pageNum,pageSize));
    }
}

package com.hrp.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hrp.domain.User;
import com.hrp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hrp
 * 2020/2/20 20:40
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("page/{currentPage}")
    public IPage<User> findByPage(
            @PathVariable("currentPage") Integer currentPage,
            @RequestParam(defaultValue = "10") Integer size) throws Exception {
        return userService.findByPage(currentPage,size);
    }

    @GetMapping("{id}")
    public User findById(@PathVariable Integer id) throws Exception {
        return userService.findById(id);
    }

    @PostMapping()
    public void insertUser(@RequestBody User user) throws Exception{
        userService.insertUser(user);
    }

    @PutMapping()
    public void updateUser(@RequestBody User user) throws Exception{
        userService.updateUser(user);
    }



}

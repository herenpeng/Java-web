package com.hrp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hrp.annotation.LogAnnotation;
import com.hrp.domain.User;
import com.hrp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author hrp
 * 2020/3/20 15:27
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("page/{currentPage}")
    public ResponseEntity<IPage<User>> selectPage(
            @PathVariable("currentPage") Integer currentPage,
            @RequestParam(defaultValue = "5") Integer size) throws Exception {
        return ResponseEntity.ok(userService.selectPage(currentPage, size));
    }

    @PostMapping
    public ResponseEntity<Void> insert(User user) throws Exception {
        userService.insert(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @LogAnnotation
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) throws Exception {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(User user) throws Exception {
        userService.update(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

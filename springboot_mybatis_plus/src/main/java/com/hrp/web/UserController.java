package com.hrp.web;

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
    public ResponseEntity<IPage<User>> findUserByPage(
            @PathVariable("currentPage") Integer currentPage,
            @RequestParam(defaultValue = "5") Integer size) throws Exception {
        return ResponseEntity.ok(userService.findUserByPage(currentPage, size));
    }

    @PostMapping("add")
    public ResponseEntity<Void> saveUser(User user) throws Exception {
        userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @LogAnnotation
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delUserById(@PathVariable("id") Integer id) throws Exception {
        userService.delUserById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("update")
    public ResponseEntity<Void> updateUser(User user) throws Exception {
        userService.updateUser(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

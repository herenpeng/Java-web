package com.hrp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hrp.domain.User;
import com.hrp.service.UserService;
import com.hrp.util.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author hrp
 * 2020/2/20 20:40
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 分页查找所有用户
     *
     * @param currentPage 当前页码
     * @param size        每页大小
     * @return 返回值
     * @throws Exception 异常
     */
    @GetMapping("page/{currentPage}")
    public IPage<User> findByPage(
            @PathVariable("currentPage") Integer currentPage,
            @RequestParam(defaultValue = "10") Integer size) throws Exception {
        return userService.findByPage(currentPage, size);
    }

    @GetMapping("export")
    public ResponseEntity<Void> export(HttpServletResponse response) throws Exception {
        List<User> exportData = userService.findList();
        ExcelUtils.exportExcel("用户列表",User.class,exportData,response);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    public User findById(@PathVariable Integer id) throws Exception {
        return userService.findById(id);
    }

    @PostMapping()
    public void insertUser(@RequestBody User user) throws Exception {
        userService.insertUser(user);
    }

    @PutMapping()
    public void updateUser(@RequestBody User user) throws Exception {
        userService.updateUser(user);
    }


}

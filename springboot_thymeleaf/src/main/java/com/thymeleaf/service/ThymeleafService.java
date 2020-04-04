package com.thymeleaf.service;

import com.thymeleaf.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


/**
 * @author hrp
 * 2020/3/25 11:47
 */
@Service
public class ThymeleafService {

    @Autowired
    private TemplateEngine templateEngine;

    public void createHtml() throws FileNotFoundException {
        User user = new User(1,"张三",20);
        //创建thymeleaf上下文对象
        Context context = new Context();
        //把数据放入上下文对象
        context.setVariable("user",user);
        context.setVariable("msg","Hello, Thymeleaf!");
        //创建一个输出流
        PrintWriter writer = new PrintWriter(new File("G:\\temp\\html\\"+user.getId()+".html"));
        //生成静态页面
        templateEngine.process("hello",context,writer);
    }
}

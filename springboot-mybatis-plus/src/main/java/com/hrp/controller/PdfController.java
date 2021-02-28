package com.hrp.controller;

import com.hrp.util.ImageUtils;
import com.hrp.util.PdfUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @description: 用于处理Pdf相关的请求
 * @author: 何任鹏
 * @create: 2020/8/24 21:55
 */
@Controller
@RequestMapping("pdf")
public class PdfController {

    @PostMapping("image/to")
    public void imageToPdf(@RequestParam("file") MultipartFile file,HttpServletResponse response) throws Exception{
        PdfUtils.imageToPdf(file,response);
    }

    @PostMapping("to/image")
    public void pdfToImage(@RequestParam("file") MultipartFile file,HttpServletResponse response) throws Exception{
        ImageUtils.pdfToImage(file,response);
    }

}

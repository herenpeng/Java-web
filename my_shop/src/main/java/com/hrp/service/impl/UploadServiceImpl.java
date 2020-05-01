package com.hrp.service.impl;

import com.hrp.config.UploadProperties;
import com.hrp.service.UploadService;
import com.hrp.util.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author hrp
 * 2020/2/23 16:55
 */
@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    private UploadProperties uploadProperties;

    @Override
    public String uploadImage(MultipartFile file) throws IOException {
        if(!uploadProperties.getAllowTypes().contains(file.getContentType())){
            throw new IOException("文件上传类型错误！");
        }
        String fileName = UploadUtils.generateFileName(file.getOriginalFilename());
        file.transferTo(new File(uploadProperties.getPath()+fileName));
        return fileName;
    }
}

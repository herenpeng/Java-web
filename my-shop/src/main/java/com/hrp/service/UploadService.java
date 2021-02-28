package com.hrp.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author hrp
 * 2020/2/23 16:55
 */
public interface UploadService {

    /**
     * 上传图片
     * @param file
     * @return
     * @throws Exception
     */
    String uploadImage(MultipartFile file) throws Exception;
}

package com.hrp.util;

/**
 * @author hrp
 * 2020/2/24 11:46
 */
public class UploadUtils {

    /**
     * 文件名称替换工具，将文件名称替换为随机名称
     * @param oldName
     * @return
     */
    public static String generateFileName(String oldName){
        String suffix = oldName.substring(oldName.lastIndexOf("."));
        return IDUtils.generateUniqueId()+suffix;
    }
}

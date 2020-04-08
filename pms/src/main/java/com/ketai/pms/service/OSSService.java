package com.ketai.pms.service;

import org.springframework.web.multipart.MultipartFile;

public interface OSSService {
    /**
     * 文件上传至阿里云
     * @param file
     * @return
     */
    String upload(MultipartFile file);
}

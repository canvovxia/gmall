package com.ketai.pms.service.impl;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;

import com.atguigu.core.exception.RRException;
import com.ketai.pms.service.OSSService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import org.joda.time.DateTime;

@Service
@Slf4j
public class OSSServiceImpl implements OSSService {
    @Override
    public String upload(MultipartFile file) {
        //获取阿里云存储相关常量
        String endPoint = "oss-cn-beijing.aliyuncs.com";
        String accessKeyId = "LTAI4Fn9b9t4ie8eBYoqXdC7";
        String accessKeySecret = "63dBIBo6CBEMKTZvPrG8JwTUqILjnC";
        String bucketName = "ketai-file1111";
        String fileHost = "avatar";
        String uploadUrl = null;
        try {
            //判断oss实例是否存在：如果不存在则创建，如果存在则获取
            OSSClient ossClient = new OSSClient(endPoint, accessKeyId, accessKeySecret);
            if (!ossClient.doesBucketExist(bucketName)) {
                //创建bucket
                ossClient.createBucket(bucketName);
                //设置oss实例的访问权限：公共读
                ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
            }
            //获取上传文件流
            InputStream inputStream = file.getInputStream();
            //构建日期路径：avatar/2019/02/26/文件名
            String filePath = new DateTime().toString("yyyy/MM/dd");
            //文件名：uuid.扩展名
            String original = file.getOriginalFilename();
            String fileName = UUID.randomUUID().toString();
            String fileType = original.substring(original.lastIndexOf("."));
            String newName = fileName + fileType;
            String fileUrl = fileHost + "/" + filePath + "/" + newName;
            //文件上传至阿里云
            ossClient.putObject(bucketName, fileUrl, inputStream);

            // 关闭OSSClient。
            ossClient.shutdown();

            //获取url地址
            uploadUrl = "http://" + bucketName + "." + endPoint + "/" + fileUrl;

        } catch (IOException e) {
            log.error(e.getMessage(),e);
            new RRException("文件上传错误");
        }

        return uploadUrl;
    }
}

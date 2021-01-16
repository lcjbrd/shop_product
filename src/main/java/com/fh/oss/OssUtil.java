package com.fh.oss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class OssUtil {

    public static final String uploadPhoto(String mkdir, MultipartFile file) throws IOException {
// Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = "LTAI4GGueArRdukVigLFxYfM";
        String accessKeySecret = "NougExEbABMmGTJiy9XkhZrlxCya4T";
        String bucketName="19121";
        String photoUrl="https://19121.oss-cn-beijing.aliyuncs.com/";
        //获取后缀名
        String originalFilename= file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileNme= UUID.randomUUID().toString()+suffix;
        String path=mkdir+"/"+newFileNme;


// 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

// 上传文件流。
        InputStream inputStream =file.getInputStream();
        ossClient.putObject(bucketName, path,inputStream);

// 关闭OSSClient。
        ossClient.shutdown();

        return photoUrl+"/"+path;
    }

}

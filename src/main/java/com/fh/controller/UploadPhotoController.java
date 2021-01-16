package com.fh.controller;


import com.fh.model.vo.ResultData;
import com.fh.oss.OssUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/uploadPhoto")
@CrossOrigin
public class UploadPhotoController {

    @PostMapping
    public ResultData uploadPhoto(@RequestParam("file") MultipartFile file) throws IOException {
        String url= OssUtil.uploadPhoto("user",file);
        System.out.println(url);
        return ResultData.success(url);
    }
}

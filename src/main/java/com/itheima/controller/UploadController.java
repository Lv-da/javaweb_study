package com.itheima.controller;

import com.itheima.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws Exception {
        log.info("上传文件:{}",image.getOriginalFilename());
        //获取原始文件名
        String originalFilename = image.getOriginalFilename();
        //构造唯一的文件名 - uuid(通用唯一识别码)
        int index=originalFilename.lastIndexOf(".");
        String extname=originalFilename.substring(index);
        String fileName= UUID.randomUUID().toString()+extname;
        log.info("新的文件名:{}",fileName);
        //文件路径 返回值
        //String path="C:\\Users\\lvda6\\IdeaProjects\\tlias-web-management\\src\\main\\resources\\image\\"+fileName;
        String path=(new File("").getAbsolutePath()+"\\src\\main\\resources\\image\\"+fileName);
        //String path=this.getClass().getClassLoader().getResource("").getPath()+"image/"+fileName;
        //将文件存储在本地
        image.transferTo(new File(path));//throws Exception
        log.info("url:{}",path);
        return Result.success(path);
    }
}

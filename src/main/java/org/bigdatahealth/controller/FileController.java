package org.bigdatahealth.controller;

import org.bigdatahealth.domain.Result;
import org.bigdatahealth.utils.FastDFSClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.HashMap;
import java.util.Map;

import static org.bigdatahealth.Constant.FILE_SERVER_URL;

@RestController
public class FileController {


    @RequestMapping("/file")
    public void uploadFile(@RequestParam("file") CommonsMultipartFile file){
        try {
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:fdfs_client.conf");
            //上传文件返回文件保存的路径和文件名
            String path = fastDFSClient.uploadFile(file.getBytes(), file.getOriginalFilename(), file.getSize());
            //拼接上服务器的地址返回给前端
            String url  = FILE_SERVER_URL+"/"+ path;
            System.out.println(url);
            Map<String ,Object > result = new HashMap<>();
            result.put("state","SUCCESS");
            result.put("url",url);
            result.put("title",file.getOriginalFilename());
            result.put("original",file.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @RequestMapping("/delete")
    public Result deleteImage(String url){
        try {
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:fdfs/fdfs_client.conf");
            String path = url.substring(FILE_SERVER_URL.length());
            Integer falg = fastDFSClient.delete_file(path);
            if (falg==0) {
                return new Result(true,"删除成功");
            }else{
                return new Result(false,"删除失败");
            }

        }catch (Exception e){
            return new Result(false,"删除失败");
        }
    }

}

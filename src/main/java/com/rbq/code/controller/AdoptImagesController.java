package com.rbq.code.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author RenBoQing
 * @date 2022年04月15日 16:01
 * @Description
 */
@Controller
public class AdoptImagesController {
    @Value("${upload-path-adopt}")
    private String uploadPath;
    /*
     *上传文件
     * @author RenBoQing
     * @date 2022/4/1 0001 9:07
     * @param servletRequest
     * @param file
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */

    @RequestMapping(value = "/adopt/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> uploadFile(HttpServletRequest servletRequest, @RequestParam("file") MultipartFile file)
            throws IOException {
        // 如果文件内容不为空，则写入上传路径
        if (!file.isEmpty()) {
            // 上传文件路径
            String UploadPath = uploadPath;
            //取得原文件名字
            String fileName = file.getOriginalFilename();
            //取得文件扩展名
            String suffix = fileName.substring(fileName.lastIndexOf("."));
            //提取系统时间作为新文件名
            String prefix = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date().getTime());
            //保存路径
            // 上传文件名
            String filename = prefix + suffix;
            File filepath = new File(UploadPath, filename);
            // 判断路径是否存在,没有创建
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            // 将上传文件保存到一个目标文档中
            File file1 = new File(UploadPath + File.separator + filename);
            file.transferTo(file1);
            Map<String, Object> res = new HashMap<>();
            // 返回的是一个url对象,图片名称
            res.put("url", "/images/adopt/" + filename);
            System.out.println(filename);
            return res;
        } else {
            return null;
        }
    }
    /*
     *上传文件前端接口
     * @author RenBoQing
     * @date 2022/4/1 0001 9:07
     * @param servletRequest
     * @param file
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @ResponseBody
    @RequestMapping(value = "/adopt/uploadimage", method = RequestMethod.POST)
    public String uploadFileDemo(HttpServletRequest servletRequest, @RequestParam("file") MultipartFile file)
            throws IOException {
        // 如果文件内容不为空，则写入上传路径
        if (!file.isEmpty()) {
            // 上传文件路径
            String UploadPath = uploadPath;
            //取得原文件名字
            String fileName = file.getOriginalFilename();
            //取得文件扩展名
            String suffix = fileName.substring(fileName.lastIndexOf("."));
            //提取系统时间作为新文件名
            String prefix = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date().getTime());
            //保存路径
            // 上传文件名
            String filename = prefix + suffix;
            File filepath = new File(UploadPath, filename);
            // 判断路径是否存在,没有创建
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            // 将上传文件保存到一个目标文档中
            File file1 = new File(UploadPath + File.separator + filename);
            file.transferTo(file1);;
            // 返回的是一个url对象,图片名称
            String  demo ="/images/adopt/"+filename;
            return demo;
        } else {
            return null;
        }
    }
}

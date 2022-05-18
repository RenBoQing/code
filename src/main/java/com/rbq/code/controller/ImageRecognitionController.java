package com.rbq.code.controller;

import com.rbq.code.utils.Base64Util;
import com.rbq.code.utils.FileUtil;
import com.rbq.code.utils.HttpUtil;
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
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author RenBoQing
 * @date 2022年04月14日 11:29
 * @Description 百度图片识别 图片上传接口
 */
@Controller
public class ImageRecognitionController {
    @Value("${upload-path-demotest}")
    private String uploadPath;
    /*
     *  百度图片识别并返回结果
     * @author RenBoQing
     * @date 2022/4/14 0014 11:33
     * @param servletRequest
     * @param file
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */

    @RequestMapping(value = "/image/recognition", method = RequestMethod.POST)
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
            System.out.println(filename);
            // 返回的是一个url对象,图片名称
            /*
           开始百度图片识别
             */
            //百度动物识别  地址
            String result = "";
            String url = "https://aip.baidubce.com/rest/2.0/image-classify/v1/animal";
            try {
                // 本地文件路径
                String filePath = "G:\\workspace\\code\\src\\main\\resources\\static\\images\\recognition\\" + filename;
                //通过文件工具类  将本地文件读成数据流 字节流
                byte[] imgData = FileUtil.readFileByBytes(filePath);
                String imgStr = Base64Util.encode(imgData);
                String imgParam = URLEncoder.encode(imgStr, "UTF-8");
                String param = "image=" + imgParam;
                //将获取的token添加到 需要解析的图片地址中
                String accessToken = "24.824b2df2d0a91744363eac7276d9f4ba.2592000.1652494082.282335-25962116";
                //封装结果集
                result = HttpUtil.post(url, accessToken, param);
                System.out.println(result);

            } catch (Exception e) {
                e.printStackTrace();
            }
            res.put("result", result);
            //返回结果集
            return res;
        } else {
            //返回空结果集合
            return null;
        }
    }
    @RequestMapping(value = "/image/recognition1", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFiled(HttpServletRequest servletRequest, @RequestParam("file") MultipartFile file)
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
            System.out.println(filename);
            // 返回的是一个url对象,图片名称
            /*
           开始百度图片识别
             */
            //百度动物识别  地址
            String result = "";
            String url = "https://aip.baidubce.com/rest/2.0/image-classify/v1/animal";
            try {
                // 本地文件路径
                String filePath = "G:\\workspace\\code\\src\\main\\resources\\static\\images\\recognition\\" + filename;
                //通过文件工具类  将本地文件读成数据流 字节流
                byte[] imgData = FileUtil.readFileByBytes(filePath);
                String imgStr = Base64Util.encode(imgData);
                String imgParam = URLEncoder.encode(imgStr, "UTF-8");
                String param = "image=" + imgParam;
                //将获取的token添加到 需要解析的图片地址中
                String accessToken = "24.824b2df2d0a91744363eac7276d9f4ba.2592000.1652494082.282335-25962116";
                //封装结果集
                result = HttpUtil.post(url, accessToken, param);
                System.out.println(result);

            } catch (Exception e) {
                e.printStackTrace();
            }
            res.put("result", result);
            //返回结果集
            return  result;
        } else {
            //返回空结果集合
            return null;
        }
    }
}

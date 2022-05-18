package com.rbq.code.utils;

import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;

/**
 * @author RenBoQing
 * @date 2022年04月14日 10:21
 * @Description
 */
public class Animal {
    public static String animal() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/image-classify/v1/animal";
        try {
            // 本地文件路径
            String filePath = "G:\\workspace\\code\\src\\main\\resources\\static\\images\\recognition\\20220415193836.jpg";
            //通过文件工具类  将本地文件读成数据流 字节流
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
            String param = "image=" + imgParam;
            //将获取的token添加到
            String accessToken = "24.824b2df2d0a91744363eac7276d9f4ba.2592000.1652494082.282335-25962116";
            //封装结果集
            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        Animal.animal();
    }
}

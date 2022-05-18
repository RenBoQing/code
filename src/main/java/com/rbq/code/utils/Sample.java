package com.rbq.code.utils;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.baidu.aip.util.Util;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author RenBoQing
 * @date 2022年04月13日 18:25
 * @Description
 */
public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "25962116";
    public static final String API_KEY = "qZAN4SPlR2FxsiK0NuCHgyOO";
    public static final String SECRET_KEY = "s3mUzGffUzwdSpv6GlsqwmDqFu9mhzHx";
    public static void main(String[] args) throws IOException {
        // 初始化一个AipImageClassify
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("top_num", "3");
        options.put("baike_num", "5");
        // 调用接口
        String path = "G:\\workspace\\code\\src\\main\\resources\\static\\images\\wiki\\3-150410143532.jpg";
        JSONObject res=null;
        try{
            res = client.advancedGeneral(Util.readFileByBytes(path), options);

        }catch (IOException e){

            e.printStackTrace();
        }
        System.out.println(res.toString(2));
    }
}

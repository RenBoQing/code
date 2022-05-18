package com.rbq.code.controller;

import com.rbq.code.utils.Md5Util;
import com.rbq.code.vo.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author RenBoQing
 * @date 2022年04月11日 10:07
 * @Description 邮件验证码发送
 */
@Slf4j
@Controller
public class MailServiceController {
    @Autowired
    JavaMailSenderImpl mailSender;    //自动注入对象
    Map<String, Object> resultMap = new HashMap<>();

    //指定验证码
    private String VerifyCode(int n) {
        // n的作用就是指定验证码的长度
        Random r = new Random(); //创建一个生成随机数的对象
        StringBuffer sb = new StringBuffer(); // StringBuffer是一种可变的字符串，长度、内容都可变
        for (int i = 0; i < n; i++) {    //一个for循环
            int ran1 = r.nextInt(10);//生成一个大于0小于10的随机数
            sb.append(String.valueOf(ran1));//调用append方法将我们生成的随机数存放到StringBuffer对象sb中
        }
        System.out.println(sb);
        return sb.toString();      //将sb以String的形式输出
    }

    /*
     *保存验证码加上密码
     * @author RenBoQing
     * @date 2022/4/12 0012 19:16
     * @param code
     */
    private void saveCode(String code) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH：mm：ss");//设置时间的格式
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MINUTE, 5);
        String currentTime = sf.format(c.getTime());// 生成5分钟后时间，用户校验是否过期
        String hash = Md5Util.code(code);//生成MD5值    //对验证码进行md5加密
        resultMap.put("hash", hash);    //将加密后的验证码发到HashMap中
        resultMap.put("tamp", currentTime);  //将验证码保存的时间信息发到HashMap中
    }

    /*
     *获取验证码
     * @author RenBoQing
     * @date 2022/4/12 0012 19:15
     * @param str
     * @return java.lang.String
     */
    public static String code(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] byteDigest = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
            // 16位的加密
            //return buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
     *发送验证码
     * @author RenBoQing
     * @date 2022/4/12 0012 19:15
     * @param email
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/email")
    @ResponseBody
    public JsonObject sendEmail(@RequestParam("email") @Validated String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        String code = VerifyCode(6);    //随机数生成6位验证码
        message.setFrom("2098510757@qq.com");        //指定发送者的邮箱
        message.setTo(email);       //接受者的邮箱，由用户输入
        message.setSubject("验证码");// 邮件标题
        message.setText("【验证码】你的验证码为：" + code + "，有效时间为5分钟(若不是本人操作，可忽略该条邮件)");// 内容
        try {
            mailSender.send(message);    //发送邮件
            log.info("验证码发送");
            //saveCode(code);                //邮件发送成功，将验证码保存
            List<String> codeList = new ArrayList<>();
            codeList.add(code);
            return JsonObject.success(0, codeList, "发送成功", (long) codeList.size());
        } catch (MailSendException e) {
            log.error("目标邮箱不存在");    //抛出异常，用户邮箱不存在
            return JsonObject.success("错误");
        } catch (Exception e) {
            return JsonObject.success("错误");
        }
    }
}

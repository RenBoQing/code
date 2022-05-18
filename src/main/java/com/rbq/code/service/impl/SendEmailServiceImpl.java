package com.rbq.code.service.impl;

/**
 * @author RenBoQing
 * @date 2022年04月10日 21:59
 * @Description
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class SendEmailServiceImpl {
    @Autowired
    private JavaMailSenderImpl mailSender;
    @Value("${spring.mail.username}")
    private String from;
    public  void sendSimpleEmail(String to, String subject, String text) {
        //定制纯文本邮件信息
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        try {
            mailSender.send(message);
            System.out.println("纯文本邮件发送成功");
        } catch (MailException e) {
            // TODO Auto-generated catch block
            System.out.println("纯文本邮件发送失败" + e.getMessage());
            e.printStackTrace();
        }
    }
}

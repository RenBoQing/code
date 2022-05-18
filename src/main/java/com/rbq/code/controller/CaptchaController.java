package com.rbq.code.controller;

import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author RenBoQing
 * @date 2022年03月24日 18:26
 * @Description 验证码Controller
 */
@Controller
public class CaptchaController {
    /*
     *图形验证码
     * @author RenBoQing
     * @date 2022/4/12 0012 19:10
     * @param request
     * @param response
     */
    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CaptchaUtil.out(request, response);
    }
}

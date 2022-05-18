package com.rbq.code.controller;

import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.SysUser;
import com.rbq.code.entity.Wiki;
import com.rbq.code.service.SysUserService;
import com.rbq.code.vo.JsonObject;
import com.rbq.code.vo.R;
import com.rbq.code.vo.Result;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author RenBoQing
 * @date 2022年03月24日 11:26
 * @Description 管理员控制器
 */
@RestController
@RequestMapping("/sysuser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    /*
     *管理员登录
     * @author RenBoQing
     * @date 2022/4/12 0012 19:18
     * @param sysUser
     * @param session
     * @param request
     * @param captcha
     * @return com.rbq.code.vo.Result
     */
    @PostMapping("/login")
    public Result loginUser(SysUser sysUser, HttpSession session, HttpServletRequest request, @RequestParam("captcha") String captcha) {
        //先进行验证码的验证
        if (!CaptchaUtil.ver(captcha, request)) {
            session.removeAttribute("captcha");
            return Result.fail("验证码错误");
        } else {
            SysUser loginSysUser = sysUserService.login(sysUser);
            session.setAttribute("userInfo", loginSysUser);
            if (loginSysUser != null) {
                return Result.success("登录成功");
            } else {
                return Result.fail("用户名或密码错误");
            }
        }
    }

    /*
     *管理员退出
     * @author RenBoQing
     * @date 2022/4/12 0012 19:19
     * @param session
     * @return com.rbq.code.vo.R
     */
    @RequestMapping("/logout")
    @ResponseBody
    public R logout(HttpSession session) {
        session.removeAttribute("userInfo");
        return R.fail("退出成功");
    }

    @RequestMapping("/list")
    @ResponseBody
    public JsonObject queryAllSysUser(Model model, SysUser  sysUser, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
        PageInfo<SysUser> sysUserPageInfo = sysUserService.queryAllSys(page, limit, sysUser);
        if(sysUserPageInfo.getTotal()>0){
            return JsonObject.success(0,sysUserPageInfo.getList(),"查询成功",sysUserPageInfo.getTotal());
        }
        else {
            return JsonObject.fail(0,"暂无数据");
        }
    }
}

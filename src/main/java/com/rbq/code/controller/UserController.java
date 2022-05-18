package com.rbq.code.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.User;
import com.rbq.code.service.UserService;
import com.rbq.code.utils.WxOpenIdUtils;
import com.rbq.code.vo.JsonObject;
import com.rbq.code.vovo.UserCommVo;
import com.rbq.code.vovo.UserOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author RenBoQing
 * @date 2022年03月30日 19:44
 * @Description 小程序用户管理
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder encoder;

    /*
     *小程序用户注册
     * @author RenBoQing
     * @date 2022/4/17 0017 20:58
     * @param demo
     * @param nickname
     * @param sex
     * @param avatarurl
     * @param password
     * @param telnumber
     * @param email
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping(value = "/register")
    @ResponseBody
    public JsonObject register(String demo, String nickname, String sex, String avatarurl, String password, String telnumber, String email) {
        //微信官方提供获取openid的url
        String WX_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JS_CODE&grant_type=authorization_code";
        //替换appid，appsecret，和code
        String requestUrl = WX_URL.replace("APPID", "wxcda84cfe03f87b7b").//填写自己的appid
                replace("SECRET", "c8320b4c4faba1fda9d1f88424819d40").replace("JS_CODE", demo).//填写自己的appsecret，
                replace("authorization_code", "authorization_code");
        //定义json对象
        JSONObject convertvalue = new JSONObject();
        //调用get方法
        String returnvalue = WxOpenIdUtils.GET(requestUrl);
        //解析返回值，对象解析成字符串
        convertvalue = (JSONObject) JSON.parse(returnvalue);
        String session_key = (String) convertvalue.get("session_key");
        String openid = (String) convertvalue.get("openid");
        User user1 = userService.selectUserByOpenId(openid);//判断数据库中是否已存在
        if (user1 == null) {//不存在就存入数据库
            User user = new User();
            user.setSex(sex);
            user.setOpenid(openid);
            user.setAvatarurl(avatarurl);
            System.out.println(avatarurl);
            user.setNickname(nickname);
            user.setPassword(password);
            user.setTelnumber(telnumber);
            user.setEmail(email);
            user.setSession_key(session_key);
            user.setStatus(0);
            userService.addUser(user);
        } else {
            return JsonObject.fail(1, "该用户已经存在,请直接登录");
        }
        System.out.println(returnvalue);//打印测试
        System.out.println("openid:" + openid);//打印测试
        System.out.println("session_key:" + session_key);//打印测试
        System.out.println(requestUrl);
        System.out.println(demo);
        return JsonObject.success(0, "注册成功");
    }

    /*
     *小程序用户登录
     * @author RenBoQing
     * @date 2022/4/12 0012 19:21
     * @param telnumber
     * @param password
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public JsonObject login(String telnumber, String password) {
        User user = userService.selectUserByTelNumber(telnumber);
        if (user != null) {
            if (encoder.matches(password, user.getPassword())) {
                List<User> userList = new ArrayList<>();

                userList.add(user);
                return JsonObject.success(0, userList, "登录成功", (long) userList.size());
            } else {
                return JsonObject.fail(1, "用户名或密码错误");
            }
        } else {
            return JsonObject.fail(1, "该用户不存在");
        }
    }

    /*
     *查询所有用户数据
     * @author RenBoQing
     * @date 2022/4/25 0025 20:17
     * @param model
     * @param user
     * @param page
     * @param limit
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/list")
    @ResponseBody
    public JsonObject queryAllUser(Model model, User user, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
        PageInfo<User> userPageInfo = userService.queryAllUsers(page, limit, user);
        if (userPageInfo.getTotal() > 0) {
            return JsonObject.success(0, userPageInfo.getList(), "查询成功", userPageInfo.getTotal());
        } else {
            return JsonObject.fail(0, "查询失败");
        }
    }

    /*
     *根据id删除
     * @author RenBoQing
     * @date 2022/4/26 0026 8:47
     * @param id
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/del")
    @ResponseBody
    public JsonObject deleUsersById(Integer id) {
        int deleteUserById = userService.deleteUserById(id);
        if (deleteUserById > 0) {
            return JsonObject.success(0, "删除成功");
        } else {
            return JsonObject.fail(1, "删除失败");
        }
    }
    /*
     *批量删除
     * @author RenBoQing
     * @date 2022/4/26 0026 8:52
     * @param ids
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/delUserByIds")
    @ResponseBody
    public JsonObject delUserByIds(String ids) {
        List<Integer> delList = new ArrayList<>();
        //后台获取
        String[] strs = ids.split(",");
        for (String str : strs) {
            delList.add(Integer.parseInt(str));
        }
        int delUserByIds = userService.delUserByIds(delList);
        if (delUserByIds > 0) {
            return JsonObject.success(0, "删除成功");
        } else {
            return JsonObject.fail(1, "删除失败");
        }
    }
    /*
     *修改用户状态
     * @author RenBoQing
     * @date 2022/4/26 0026 13:55
     * @param user
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/updateUserById")
    @ResponseBody
    public JsonObject updateUserById(Integer status, Integer id) {
        int updateUserById = userService.updateUserById(status, id);
        if (updateUserById > 0) {
            return JsonObject.success(0, "修改用户状态成功");
        } else {
            return JsonObject.fail(0, "修改用户状态失败");
        }
    }
    /*
     *图表信息
     * @author RenBoQing
     * @date 2022/4/26 0026 16:37
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    @RequestMapping("/queryUserCount")
    @ResponseBody
    public List<Map<String, Object>> queryForList() {
        return userService.queryUserConut();
    }
    /*
     *查询用户的个人发布
     * @author RenBoQing
     * @date 2022/4/29 0029 22:15
     * @param uid
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/usercomm")
    @ResponseBody
    public JsonObject queryUserCommVoByUid(Integer uid) {
        List<UserCommVo> userCommVos = userService.queryUserCommVoByUid(uid);
        if (userCommVos.size() > 0) {
            return JsonObject.success(0, userCommVos, "查询成功", (long) userCommVos.size());
        } else {
            return JsonObject.fail(1, "该用户没有发布任何动态");
        }
    }
    /*
     *根据用户的id查询所有的订单项
     * @author RenBoQing
     * @date 2022/4/30 0030 11:28
     * @param uid
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/userorder")
    @ResponseBody
    public JsonObject queryUserOrderByUid(Integer uid) {
        List<UserOrderVo> userOrderVos = userService.queryUserOrderByUid(uid);
        if (userOrderVos.size() > 0) {
            return JsonObject.success(0, userOrderVos, "查询成功", (long) userOrderVos.size());
        } else {
            return JsonObject.fail(0, "该用户暂无订单");
        }
    }


}

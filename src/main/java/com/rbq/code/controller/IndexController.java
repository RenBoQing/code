package com.rbq.code.controller;

import com.rbq.code.entity.*;
import com.rbq.code.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author RenBoQing
 * @date 2022年03月24日 10:18
 * @Description 静态页面配映射
 */
@Controller
public class IndexController {
    @Autowired
    private WikiService wikiService;
    @Autowired
    private AdoptService adoptService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private HosptialProService hosptialProService;
    @Autowired
    private WelfareService welfareService;

    //用户登录页
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    //系统首页
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    //图表页面
    @RequestMapping("/home/dashboard")
    public String dashboard() {
        return "home/dashboard";
    }

    //医院列表页面
    @RequestMapping("/hosptial/hosptial")
    public String hosptial() {
        return "hosptial/hosptial";
    }

    //医院添加页面
    @RequestMapping("/hosptial/hosptialadd")
    public String hosptialadd() {
        return "hosptial/hosptialadd";
    }

    //医院添加页面
    @RequestMapping("/hosptial/hosptialcount")
    public String hosptialcount() {
        return "hosptial/hosptialcount";
    }

    //管理员用户页面
    @RequestMapping("/sysuser/sysuser")
    public String sysuser() {
        return "sysuser/sysuser";
    }

    //管理员权限管理页面
    @RequestMapping("/sysuser/sysmenu")
    public String menu() {
        return "sysuser/sysmenu";
    }

    //萌宠百科页面
    @RequestMapping("/wiki/wiki")
    public String wiki() {
        return "wiki/wiki";
    }

    //百科大数据页面
    @RequestMapping("/wiki/data")
    public String data() {
        return "wiki/data";
    }

    //百科添加页面
    @RequestMapping("/wiki/wikiadd")
    public String wikiadd() {
        return "wiki/wikiadd";
    }

    //侠贝测试数据
    @RequestMapping("/test/demo")
    public String demo() {
        return "/test/demo";
    }

    //侠贝测试数据
    @RequestMapping("/test/demo2")
    public String demo2() {
        return "/test/demo2";
    }

    //侠贝测试数据
    @RequestMapping("/test/demo1")
    public String demo1() {
        return "/test/demo1";
    }

    //侠贝测试数据
    @RequestMapping("/test/demo3")
    public String demo3() {
        return "/test/demo3";
    }

    //侠贝测试数据
    @RequestMapping("/test/demo4")
    public String demo4() {
        return "/test/demo4";
    }

    @RequestMapping("/test/chat1")
    public String demo5() {
        return "/test/chat1";
    }

    //侠贝测试数据
    @RequestMapping("/test/classify")
    public String classify() {
        return "/test/classify";
    }

    // 跳转到百科修改页面
    @RequestMapping("/wiki/queryWikiById")
    public String updateWiki(Model model, int id) {
        //    根据id查询相关信息  将id带回
        Wiki wiki = wikiService.queryWikiById(id);
        model.addAttribute("wiki", wiki);
        return "wiki/wikiupdate";
    }

    //商品页面
    @RequestMapping("/mall/product")
    public String product() {
        return "mall/product";
    }

    //领养管理页面
    @RequestMapping("/adopt/adopt")
    public String adopt() {
        return "adopt/adopt";
    }

    //领养添加页面
    @RequestMapping("/adopt/adoptadd")
    public String adoptadd() {
        return "adopt/adoptadd";
    }

    //页面跳转 领养信息修改
    @RequestMapping("/adopt/queryAdoptById")
    public String updateAdopt(Model model, int id) {
        Adopt adopt = adoptService.queryAdoptById(id);
        model.addAttribute("adopt", adopt);
        return "adopt/adoptupdate";
    }

    //跳转到商品添加页面
    @RequestMapping("/mall/productadd")
    public String addProduct() {
        return "/mall/productadd";
    }

    //添加到商品修改页面
    @RequestMapping("/product/queryProductById")
    public String updateProduct(Model model, int id) {
        Product product = productService.queryProductById(id);
        model.addAttribute("product", product);
        return "/mall/productupdate";
    }

    //医院项目页面
    @RequestMapping("/hosptial/project")
    public String hosptialProject() {
        return "hosptial/project";
    }

    //小程序用户页面
    @RequestMapping("/wxuser/user")
    public String wxUser() {
        return "wxuser/user";
    }

    //小程序用户统计页面
    @RequestMapping("/wxuser/statistics")
    public String wxUserStatistics() {
        return "wxuser/statistics";
    }

    //跳转到用户信息修改页面
    @RequestMapping("/user/queryProductById")
    public String queryProductById(Model model, int id) {
        User user = userService.queryUserById(id);
        model.addAttribute("user", user);
        return "/wxuser/userupdate";
    }

    //跳转到宠物项目页面
    @RequestMapping("/hosptial/service")
    public String hosptialService() {
        return "/hosptial/service";
    }

    //跳转到项目添加页面
    @RequestMapping("/hosptial/serviceadd")
    public String hosptialServiceAdd() {
        return "/hosptial/serviceadd";
    }

    //跳转到项目修改页面
    @RequestMapping("/hosptial/queryHosptialServiceVoById")
    public String queryHosptialServiceVoById(Model model, int id) {
        HosptialServiceVo hosptialServiceVo = hosptialProService.queryHosptialServiceVoById(id);
        model.addAttribute("hosptialServiceVo", hosptialServiceVo);
        return "/hosptial/serviceupdate";
    }

    //    跳转到购物车页面
    @RequestMapping("/mall/cart")
    public String cart() {
        return "/mall/cart";
    }

    //跳转到订单页面
    @RequestMapping("/mall/order")
    public String order() {
        return "/mall/order";
    }

    //宠物公益页面
    @RequestMapping("/welfare/welfare")
    public String welfare() {
        return "/welfare/welfare";
    }

    //公益添加
    @RequestMapping("/welfare/add")
    public String add() {
        return "/welfare/add";
    }

    /*
     *公益修改
     * @author RenBoQing
     * @date 2022/5/4 0004 9:55
     * @param model
     * @param id
     * @return java.lang.String
     */
    @RequestMapping("/welfare/queryWelfareById")
    public String queryWelfareById(Model model, int id) {
        Welfare welfare = welfareService.queryWelfareById(id);
        model.addAttribute("welfare", welfare);
        return "welfare/welfareupdate";
    }

    /*
     *说说页面
     * @author RenBoQing
     * @date 2022/5/4 0004 9:55
     * @return java.lang.String
     */
    @RequestMapping("/circle/circle")
    public String circle() {
        return "/circle/circle";
    }

    /*
     *商城大数据
     * @author RenBoQing
     * @date 2022/5/4 0004 9:56
     * @return java.lang.String
     */
    @RequestMapping("/mall/data")
    public String mallData() {
        return "/mall/data";
    }

    //领养大数据
    @RequestMapping("/adopt/data")
    public String adoptData() {
        return "/adopt/data";
    }

    //公益大数据
    @RequestMapping("/welfare/data")
    public String welfareData() {
        return "/welfare/data";
    }
    //动态大数据
    @RequestMapping("/circle/data")
    public String cicleData(){
        return "/circle/data";
    }
}

package com.rbq.code.controller;

import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.Product;
import com.rbq.code.service.ProductService;
import com.rbq.code.vo.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author RenBoQing
 * @date 2022年04月11日 20:28
 * @Description 商品控制器
 */
@Controller
@Slf4j
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    /*
     *查询所有的商品数据
     * @author RenBoQing
     * @date 2022/4/12 0012 19:17
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/list")
    @ResponseBody
    public JsonObject queryAllProduct(Model model, Product product, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
        PageInfo<Product> productPageInfo = productService.queryAllProduct(page, limit, product);
        return JsonObject.success(0, productPageInfo.getList(), "查询成功", productPageInfo.getTotal());
    }

    /*
     *下架商品
     * @author RenBoQing
     * @date 2022/4/20 0020 16:52
     * @param id
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/del")
    @ResponseBody
    public JsonObject deleteProductById(Integer id) {
        int deleteProductById = productService.deleteProductById(id);
        if (deleteProductById > 0) {
            return JsonObject.success(0, "删除成功");
        } else {
            return JsonObject.fail(1, "删除失败");
        }
    }

    /*
     *商品上架
     * @author RenBoQing
     * @date 2022/4/20 0020 20:35
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/add")
    @ResponseBody
    public JsonObject addProduct(Product product) {
        product.setCreatetime(new Date());
        product.setUpdatetime(new Date());
        int addProduct = productService.addProduct(product);
        if (addProduct > 0) {
            return JsonObject.success(0, "上架成功");
        } else {
            return JsonObject.fail(1, "上架失败,请重试");
        }
    }
    /*
     *修改商品信息
     * @author RenBoQing
     * @date 2022/4/21 0021 9:39
     * @param product
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/updateProductById")
    @ResponseBody
    public JsonObject updateProductById(Product product) {
        product.setUpdatetime(new Date());
        int updateProductById = productService.updateProductById(product);
        if (updateProductById > 0) {
            return JsonObject.success(0, "修改成功");
        } else {
            return JsonObject.fail(1, "修改失败");
        }
    }
    /*
     *批量删除
     * @author RenBoQing
     * @date 2022/4/21 0021 10:31
     * @param ids
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/delProductByIds")
    @ResponseBody
    public JsonObject delProductByIds(String ids) {
        List<Integer> delList = new ArrayList<>();
        //后台获取
        String[] strs = ids.split(",");
        for (String str : strs) {
            delList.add(Integer.parseInt(str));
        }
        int delProductByIds = productService.delProductByIds(delList);
        if (delProductByIds > 0) {
            return JsonObject.success(0, "删除成功");
        } else {
            return JsonObject.success(1, "删除失败");
        }
    }
    /*
     *图表信息生成
     * @author RenBoQing
     * @date 2022/5/4 0004 9:39
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    @RequestMapping("/queryProductCount")
    @ResponseBody
    public List<Map<String, Object>> queryForList() {
        return productService.queryProductCount();
    }

}

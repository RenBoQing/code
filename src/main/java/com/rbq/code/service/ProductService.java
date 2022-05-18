package com.rbq.code.service;

import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.Product;

import java.util.List;
import java.util.Map;

/**
 * @author RenBoQing
 * @date 2022年04月11日 20:25
 * @Description
 */
public interface ProductService {
    /*
     *查询所有的商品信息
     * @author RenBoQing
     * @date 2022/4/20 0020 16:49
     * @param page
     * @param pageSize
     * @param product
     * @return com.github.pagehelper.PageInfo<com.rbq.code.entity.Product>
     */
    PageInfo<Product> queryAllProduct(int page, int pageSize, Product product);

    /*
     *根据id下架商品
     * @author RenBoQing
     * @date 2022/4/20 0020 16:49
     * @param id
     * @return int
     */
    int deleteProductById(Integer id);

    /*
     *上架商品
     * @author RenBoQing
     * @date 2022/4/20 0020 20:34
     * @param product
     * @return int
     */
    int addProduct(Product product);

    /*
     *根据id查询商品
     * @author RenBoQing
     * @date 2022/4/21 0021 9:34
     * @param id
     * @return com.rbq.code.entity.Product
     */
    Product queryProductById(Integer id);

    /*
     *修改商品信息
     * @author RenBoQing
     * @date 2022/4/21 0021 9:35
     * @param product
     * @return int
     */
    int updateProductById(Product product);

    /*
     *批量删除
     * @author RenBoQing
     * @date 2022/4/21 0021 10:27
     * @param delList
     * @return int
     */
    int delProductByIds(List<Integer> delList);


    public List<Map<String, Object>> queryProductCount();
}

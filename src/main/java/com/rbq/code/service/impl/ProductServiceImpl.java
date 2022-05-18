package com.rbq.code.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.Product;
import com.rbq.code.mapper.ProductMapper;
import com.rbq.code.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author RenBoQing
 * @date 2022年04月11日 20:26
 * @Description
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    /*
     *查询所有的商品数据
     * @author RenBoQing
     * @date 2022/4/20 0020 16:50
     * @param page
     * @param pageSize
     * @param product
     * @return com.github.pagehelper.PageInfo<com.rbq.code.entity.Product>
     */
    @Override
    public PageInfo<Product> queryAllProduct(int page, int pageSize, Product product) {
        PageHelper.startPage(page, pageSize);
        List<Product> productList = productMapper.queryAllProduct(product);
        PageInfo<Product> productPageInfo = new PageInfo<Product>(productList);
        return productPageInfo;
    }

    /*
     *通过id下架商品
     * @author RenBoQing
     * @date 2022/4/20 0020 16:50
     * @param id
     * @return int
     */
    @Override
    public int deleteProductById(Integer id) {
        return productMapper.deleteProductById(id);
    }

    /*
     *商品上架
     * @author RenBoQing
     * @date 2022/4/20 0020 20:34
     * @param product
     * @return int
     */
    @Override
    public int addProduct(Product product) {
        return productMapper.addProduct(product);
    }

    /*
     *修改商品信息
     * @author RenBoQing
     * @date 2022/4/21 0021 8:24
     * @param id
     * @return com.rbq.code.entity.Product
     */
    @Override
    public Product queryProductById(Integer id) {

        return productMapper.queryProductById(id);
    }

    /*
     *根据商品id来修改商品信息
     * @author RenBoQing
     * @date 2022/4/21 0021 9:35
     * @param product
     * @return int
     */
    @Override
    public int updateProductById(Product product) {
        return productMapper.updateProductById(product);
    }

    /*
     *批量删除
     * @author RenBoQing
     * @date 2022/4/21 0021 10:28
     * @param delList
     * @return int
     */
    @Override
    public int delProductByIds(List<Integer> delList) {
        int delProductByIds = productMapper.delProductByIds(delList);
        return delProductByIds;
    }

    @Override
    public List<Map<String, Object>> queryProductCount() {
        return productMapper.queryProductCount();
    }
}

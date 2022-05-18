package com.rbq.code.mapper;

import com.rbq.code.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author RenBoQing
 * @date 2022年04月11日 20:02
 * @Description
 */
@Mapper
public interface ProductMapper {
    /*
     *查询所有的商品信息  带上条件查询和分页
     * @author RenBoQing
     * @date 2022/4/11 0011 20:03
     * @return java.util.List<com.rbq.code.entity.Product>
     */
    List<Product> queryAllProduct(Product product);

    /*
     *根据id对应的商品下架
     * @author RenBoQing
     * @date 2022/4/20 0020 16:45
     * @param id
     * @return int
     */
    int deleteProductById(Integer id);

    /*
     *商品上架
     * @author RenBoQing
     * @date 2022/4/20 0020 20:30
     * @param product
     * @return int
     */
    int addProduct(Product product);

    /*
     *根据id查询数据商品
     * @author RenBoQing
     * @date 2022/4/20 0020 20:57
     * @param id
     * @return com.rbq.code.entity.Product
     */
    Product queryProductById(Integer id);

    /*
     *根据id更新商品信息
     * @author RenBoQing
     * @date 2022/4/21 0021 9:26
     * @param product
     * @return int
     */
    int updateProductById(Product product);

    /*
     *批量删除
     * @author RenBoQing
     * @date 2022/4/21 0021 10:10
     * @param delList
     * @return int
     */
    int delProductByIds(List<Integer> delList);


    /*
     *图表信息生成
     * @author RenBoQing
     * @date 2022/5/4 0004 9:34
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    public List<Map<String, Object>> queryProductCount();
}

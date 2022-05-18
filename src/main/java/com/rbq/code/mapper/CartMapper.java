package com.rbq.code.mapper;

import com.rbq.code.entity.Cart;
import com.rbq.code.vovo.CartVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年04月17日 21:28
 * @Description
 */
@Mapper
@Repository
public interface CartMapper {
    /*
     *添加商品到购物车
     * @author RenBoQing
     * @date 2022/4/17 0017 21:29
     * @param cart
     * @return int
     */
    int addCart(Cart cart);

    /*
     *修改对应的购买数量
     * @author RenBoQing
     * @date 2022/4/18 0018 9:57
     * @param id
     * @param count
     * @return int
     */
    int updateCountById(Integer id, Integer count);

    /*
     *根据商品的id和用户的id来查询购物车中的数据
     * @author RenBoQing
     * @date 2022/4/18 0018 10:00
     * @param productd
     * @param userid
     * @return com.rbq.code.entity.Cart
     */
    Cart findByUidAndPid(Integer productid, Integer userid);

    /*
     *根据用户的id来查询对应的购物车信息
     * @author RenBoQing
     * @date 2022/4/18 0018 15:25
     * @param id
     * @return java.util.List<com.rbq.code.vovo.CartVo>
     */
    List<CartVo> findByUid(Integer id);


    /*
     *根据订单编号数组来获取订单信息
     * @author RenBoQing
     * @date 2022/4/19 0019 9:02
     * @param cids
     * @return java.util.List<com.rbq.code.vovo.CartVo>
     */
    List<CartVo> findVoByCids(Integer[] ids);

    /*
     *根据购物车id来获取购物车信息
     * @author RenBoQing
     * @date 2022/4/19 0019 9:03
     * @param cid
     * @return com.rbq.code.entity.Cart
     */
    Cart findByCid(Integer id);

    /*
     *查询所有的购物车信息
     * @author RenBoQing
     * @date 2022/5/1 0001 20:39
     * @return java.util.List<com.rbq.code.vovo.CartVo>
     */
    List<CartVo> queryAllCart( CartVo cartVo);


}

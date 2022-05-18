package com.rbq.code.service;

import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.Cart;
import com.rbq.code.vovo.CartVo;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年04月17日 21:48
 * @Description
 */
public interface CartService {
    /*
     *将商品添加到购物车中
     * @author RenBoQing
     * @date 2022/4/17 0017 21:49
     * @param cart
     * @return int
     */
    int addCart(Cart cart);

    /*
     *根据id查询购物车信息
     * @author RenBoQing
     * @date 2022/4/18 0018 16:48
     * @param id
     * @return java.util.List<com.rbq.code.vovo.CartVo>
     */
    List<CartVo> getCartByUid(Integer id);

    /*
     *根据用户的id和传入的购物车数量来进行查询
     * @author RenBoQing
     * @date 2022/4/19 0019 9:40
     * @param uid
     * @param cids
     * @return java.util.List<com.rbq.code.vovo.CartVo>
     */
    List<CartVo> getVOByCids(Integer id, Integer[] ids);

    /*
     *查询所有的购物车信息
     * @author RenBoQing
     * @date 2022/5/1 0001 20:44
     * @return java.util.List<com.rbq.code.vovo.CartVo>
     */
   PageInfo<CartVo> queryAllCart(int page, int pageSize, CartVo cartVo);
}

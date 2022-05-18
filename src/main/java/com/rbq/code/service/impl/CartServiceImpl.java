package com.rbq.code.service.impl;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年04月17日 21:49
 * @Description 购物车业务层
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.Cart;
import com.rbq.code.mapper.CartMapper;
import com.rbq.code.mapper.ProductMapper;
import com.rbq.code.service.CartService;
import com.rbq.code.vovo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;

    /*
     *添加购物车
     * @author RenBoQing
     * @date 2022/4/17 0017 21:51
     * @param cart
     * @return int
     */
    @Override
    public int addCart(Cart cart) {
        //判断这个加入的商品是否在数据库中存在 如果存在 直接更新 不存在 直接添加
        Cart byUidAndPid = cartMapper.findByUidAndPid(cart.getProductid(), cart.getUserid());
        if (byUidAndPid == null) {
            //   表示这个商品没有添加过
            return cartMapper.addCart(cart);
        } else {
            //直接更新数量 表示这个数据存在
            //将总的数量传递给对应数据库
            Integer total = byUidAndPid.getCount() + cart.getCount();
            return cartMapper.updateCountById(byUidAndPid.getId(), total);
        }
    }

    /*
     *根据uid查询该用户的购物车信息
     * @author RenBoQing
     * @date 2022/4/18 0018 16:49
     * @param id
     * @return java.util.List<com.rbq.code.vovo.CartVo>
     */
    @Override
    public List<CartVo> getCartByUid(Integer id) {
        return cartMapper.findByUid(id);
    }

    /*
     *根据用户id和传入购物车ids进行数据查询
     * @author RenBoQing
     * @date 2022/4/19 0019 9:41
     * @param id
     * @param ids
     * @return java.util.List<com.rbq.code.vovo.CartVo>
     */
    @Override
    public List<CartVo> getVOByCids(Integer id, Integer[] ids) {
        List<CartVo> list = cartMapper.findVoByCids(ids);
        Iterator<CartVo> it = list.iterator();
        //获取相关数据
        while (it.hasNext()) {
            CartVo cart = it.next();
            //将两个数据比较
            if (!cart.getUserid().equals(id)) {
                it.remove();
            }
        }
        return list;
    }

    /*
     *查询所有的购物车
     * @author RenBoQing
     * @date 2022/5/1 0001 20:49
     * @param page
     * @param pageSize
     * @param cartVo
     * @return com.github.pagehelper.PageInfo<com.rbq.code.vovo.CartVo>
     */
    @Override
    public PageInfo<CartVo> queryAllCart(int page, int pageSize, CartVo cartVo) {
        PageHelper.startPage(page,pageSize);
        List<CartVo> cartVos = cartMapper.queryAllCart(cartVo);
        PageInfo<CartVo> cartVoPageInfo=new PageInfo<>(cartVos);
        return cartVoPageInfo;
    }
}

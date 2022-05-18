package com.rbq.code.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.User;
import com.rbq.code.mapper.UserMapper;
import com.rbq.code.service.UserService;
import com.rbq.code.vovo.UserCommVo;
import com.rbq.code.vovo.UserOrderItemVo;
import com.rbq.code.vovo.UserOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author RenBoQing
 * @date 2022年03月30日 19:37
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public int addUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        int count = userMapper.addUser(user);
        return count;
    }

    @Override
    public User selectUserByOpenId(String openid) {
        return userMapper.selectUserByOpenId(openid);
    }

    /*
     *根据电话查询用户
     * @author RenBoQing
     * @date 2022/4/25 0025 20:14
     * @param telnumber
     * @return com.rbq.code.entity.User
     */
    @Override
    public User selectUserByTelNumber(String telnumber) {
        return userMapper.selectUserByTelNumber(telnumber);
    }

    /*
     *查询所有的数据
     * @author RenBoQing
     * @date 2022/4/25 0025 20:14
     * @param page
     * @param pageSize
     * @param user
     * @return com.github.pagehelper.PageInfo
     */
    @Override
    public PageInfo queryAllUsers(int page, int pageSize, User user) {
        PageHelper.startPage(page, pageSize);
        List<User> userList = userMapper.queryAllUsers(user);
        PageInfo<User> userPageInfo = new PageInfo<>(userList);
        return userPageInfo;
    }

    /*
     *根据id删除用户
     * @author RenBoQing
     * @date 2022/4/25 0025 22:12
     * @param id
     * @return int
     */
    @Override
    public int deleteUserById(Integer id) {
        return userMapper.deleteUserById(id);
    }

    /*
     *批量删除
     * @author RenBoQing
     * @date 2022/4/26 0026 8:46
     * @param delList
     * @return int
     */
    @Override
    public int delUserByIds(List<Integer> delList) {
        return userMapper.delUserByIds(delList);
    }

    /*
     *
     * @author RenBoQing
     * @date 2022/4/26 0026 11:16
     * @param id
     * @return com.rbq.code.entity.User
     */
    @Override
    public User queryUserById(Integer id) {
        return userMapper.queryUserById(id);
    }

    /*
     *更新用户信息
     * @author RenBoQing
     * @date 2022/4/26 0026 13:51
     * @param user
     * @return int
     */
    @Override
    public int updateUserById(Integer status, Integer id) {
        return userMapper.updateUserById(status, id);
    }

    /*
     *图标信息
     * @author RenBoQing
     * @date 2022/4/26 0026 16:35
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    @Override
    public List<Map<String, Object>> queryUserConut() {
        return userMapper.queryUserConut();
    }

    /*
     *查询用户的个人动态发布
     * @author RenBoQing
     * @date 2022/4/29 0029 22:13
     * @param uid
     * @return java.util.List<com.rbq.code.vovo.UserCommVo>
     */
    @Override
    public List<UserCommVo> queryUserCommVoByUid(Integer uid) {
        return userMapper.queryUserCommVoByUid(uid);
    }
    /*
     *根据用户的id查询订单项
     * @author RenBoQing
     * @date 2022/4/30 0030 11:18
     * @param userid
     * @return java.util.List<com.rbq.code.vovo.UserOrderVo>
     */
    @Override
    public List<UserOrderVo> queryUserOrderByUid(Integer userid) {
        List<UserOrderVo> userOrderVos = userMapper.queryUserOrderByUid(userid);
        //遍历订单项
        for (UserOrderVo userOrderVo : userOrderVos) {
            List<UserOrderItemVo> userOrderItemVos = userMapper.queryUserOrderItemByOrderno(userOrderVo.getOrderno());
            for (UserOrderItemVo userOrderItemVo : userOrderItemVos) {
                if(userOrderItemVo.getOrderno().equals(userOrderVo.getOrderno())){
                    userOrderVo.setUserOrderItemVoList(userOrderItemVos);
                }
            }
        }
        return userOrderVos;
    }
}

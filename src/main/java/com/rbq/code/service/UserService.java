package com.rbq.code.service;

import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.User;
import com.rbq.code.vovo.UserCommVo;
import com.rbq.code.vovo.UserOrderVo;

import java.util.List;
import java.util.Map;

/**
 * @author RenBoQing
 * @date 2022年03月30日 19:37
 * @Description
 */
public interface UserService {
    int addUser(User user);

    User selectUserByOpenId(String openid);

    User selectUserByTelNumber(String telnumber);

    /*
     *查询所有的用户
     * @author RenBoQing
     * @date 2022/4/25 0025 20:12
     * @param page
     * @param pageSize
     * @param user
     * @return com.github.pagehelper.PageInfo
     */
    PageInfo queryAllUsers(int page, int pageSize, User user);

    /*
     *根据id删除用户
     * @author RenBoQing
     * @date 2022/4/25 0025 22:11
     * @param id
     * @return int
     */
    int deleteUserById(Integer id);

    /*
     *批量删除
     * @author RenBoQing
     * @date 2022/4/26 0026 8:45
     * @param delList
     * @return int
     */
    int delUserByIds(List<Integer> delList);

    /*
     *根据id查询用户
     * @author RenBoQing
     * @date 2022/4/26 0026 11:15
     * @param id
     * @return com.rbq.code.entity.User
     */
    User queryUserById(Integer id);

    /*
     *根据id更新用户
     * @author RenBoQing
     * @date 2022/4/26 0026 13:50
     * @param user
     * @return int
     */
    int updateUserById(Integer status, Integer id);

    /*
     *图表信息
     * @author RenBoQing
     * @date 2022/4/26 0026 16:35
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    public List<Map<String, Object>> queryUserConut();


    /*
     *查询用户所有的发布动态
     * @author RenBoQing
     * @date 2022/4/29 0029 22:13
     * @param uid
     * @return java.util.List<com.rbq.code.vovo.UserCommVo>
     */
    public List<UserCommVo> queryUserCommVoByUid(Integer uid);

    /*
     *查询用户的订单
     * @author RenBoQing
     * @date 2022/4/30 0030 11:17
     * @param userid
     * @return java.util.List<com.rbq.code.vovo.UserOrderVo>
     */
    public List<UserOrderVo> queryUserOrderByUid(Integer userid);
}

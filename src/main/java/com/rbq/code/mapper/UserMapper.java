package com.rbq.code.mapper;

import com.rbq.code.entity.User;
import com.rbq.code.vovo.UserCommVo;
import com.rbq.code.vovo.UserOrderItemVo;
import com.rbq.code.vovo.UserOrderVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author RenBoQing
 * @date 2022年03月30日 19:23
 * @Description
 */
@Mapper
public interface UserMapper {
    /*
     *添加用户
     * @author RenBoQing
     * @date 2022/4/18 0018 19:08
     * @param user
     * @return int
     */
    int addUser(User user);

    /*
     *根据openid查询用户
     * @author RenBoQing
     * @date 2022/4/18 0018 19:08
     * @param openid
     * @return com.rbq.code.entity.User
     */
    User selectUserByOpenId(String openid);

    /*
     *根据电话查询用户
     * @author RenBoQing
     * @date 2022/4/18 0018 19:08
     * @param telnumber
     * @return com.rbq.code.entity.User
     */
    User selectUserByTelNumber(String telnumber);

    /*
     *查询所有的人用户
     * @author RenBoQing
     * @date 2022/4/25 0025 22:07
     * @param user
     * @return java.util.List<com.rbq.code.entity.User>
     */
    List<User> queryAllUsers(User user);

    /*
     *根据id删除用户
     * @author RenBoQing
     * @date 2022/4/25 0025 22:07
     * @param id
     * @return int
     */
    int deleteUserById(Integer id);

    /*
     *批量删除
     * @author RenBoQing
     * @date 2022/4/26 0026 8:42
     * @param delList
     * @return int
     */
    int delUserByIds(List<Integer> delList);

    /*
     *根据用户id查询用户
     * @author RenBoQing
     * @date 2022/4/26 0026 11:14
     * @return com.rbq.code.entity.User
     */
    User queryUserById(Integer id);

    /*
     *根据id修改对应的设置
     * @author RenBoQing
     * @date 2022/4/26 0026 13:33
     * @param id
     * @return int
     */
    int updateUserById(Integer status, Integer id);

    /*
     *图表信息
     * @author RenBoQing
     * @date 2022/4/26 0026 16:31
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    public List<Map<String, Object>> queryUserConut();

    /*
     *查询用户的动态发布
     * @author RenBoQing
     * @date 2022/4/29 0029 21:53
     * @param uid
     * @return java.util.List<com.rbq.code.vovo.UserCommVo>
     */
    public List<UserCommVo> queryUserCommVoByUid(Integer uid);

    /*
     *查询用户的订单列表
     * @author RenBoQing
     * @date 2022/4/30 0030 10:35
     * @param userid
     * @return java.util.List<com.rbq.code.vovo.UserOrderVo>
     */
    public List<UserOrderVo> queryUserOrderByUid(Integer userid);


    /*
     *根据订单号查询对应的订单项
     * @author RenBoQing
     * @date 2022/4/30 0030 11:09
     * @param orderno
     * @return java.util.List<com.rbq.code.vovo.UserOrderItemVo>
     */
    public List<UserOrderItemVo> queryUserOrderItemByOrderno(String orderno);

}

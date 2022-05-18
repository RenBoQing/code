package com.rbq.code;

import com.rbq.code.entity.Cart;
import com.rbq.code.entity.Comments;
import com.rbq.code.entity.Order;
import com.rbq.code.entity.OrderItem;
import com.rbq.code.mapper.*;
import com.rbq.code.vovo.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Slf4j
@SpringBootTest
public class CodeApplicationTests {

   // @Autowired
   // private CartMapper cartMapper;
   // @Autowired
   // private OrderMapper orderMapper;
   // @Autowired
   // private CircleMapper circleMapper;
   // @Autowired
   // private CommentsMapper commentsMapper;
   // @Autowired
   // private HopsptialProjectMapper hopsptialProjectMapper;
   // @Autowired
   // private UserMapper userMapper;
   // @Autowired
   // private HosptialServiceMapper hosptialServiceMapper;
   // @Autowired
   // private Random random;
   // @Autowired
   // private HelpMapper helpMapper;
   //
   // /*
   //  *通过id查询对应的购物车  看是否存在
   //  * @author RenBoQing
   //  * @date 2022/4/18 0018 13:51
   //  */
   // @Test
   // public void testCart() {
   //     Cart byUidAndPid = cartMapper.findByUidAndPid(1, 100);
   //     log.info(byUidAndPid.toString());
   // }
   //
   // /*
   //  *通过购物车的id更新数据
   //  * @author RenBoQing
   //  * @date 2022/4/18 0018 14:14
   //  * @param null
   //  * @return null
   //  */
   // @Test
   // public void testCartByUid() {
   //     int i = cartMapper.updateCountById(1, 100);
   //     System.out.println(i);
   // }
   //
   // /*
   //  *根据用户的id来查询订单信息
   //  * @author RenBoQing
   //  * @date 2022/4/18 0018 16:26
   //  */
   // @Test
   // public void testCartByVo() {
   //     List<CartVo> byUid = cartMapper.findByUid(100);
   //     for (CartVo cartVo : byUid) {
   //         System.out.println(cartVo);
   //     }
   // }
   //
   // /*
   //  *添加订单项
   //  * @author RenBoQing
   //  * @date 2022/4/18 0018 21:31
   //  */
   // @Test
   // public void testOrder() {
   //     Order order = new Order();
   //     order.setUserid(100);
   //     order.setOrderno("");
   //     order.setTotalprice(900);
   //     orderMapper.addOrder(order);
   // }
   //
   // /*
   //  *添加订单项目
   //  * @author RenBoQing
   //  * @date 2022/4/18 0018 21:31
   //  */
   // @Test
   // public void testOrderItem() {
   //     OrderItem orderItem = new OrderItem();
   //     orderItem.setOrderid(1);
   //     orderItem.setProductid(2);
   //     orderItem.setProductname("ceshi");
   //     orderMapper.addOrderItem(orderItem);
   // }
   //
   // /*
   //  *根据cids 获取对应的信息
   //  * @author RenBoQing
   //  * @date 2022/4/19 0019 9:12
   //  */
   // @Test
   // public void testCartItems() {
   //     List<CartVo> voByCids = cartMapper.findVoByCids(new Integer[]{4, 5, 3});
   //     for (CartVo voByCid : voByCids) {
   //         System.out.println(voByCid.toString());
   //     }
   // }
   //
   //
   // //评论添加
   // @Test
   // public void testComment() {
   //     int addComments = commentsMapper.addComments(new Comments(null, 1, 100, "喜欢的呢", 90, new Date()));
   //     int addCommentsDemo = commentsMapper.addComments(new Comments(null, 1, 101, "测试评论", 90, new Date()));
   // }
   //
   // //测试订单功能
   // @Test
   // public void testOrderde() {
   //     String demo = "[\"/images/circle/20220421141930.jpg\"]";
   //     String replace = demo.replace("[", "");
   //     String replace1 = replace.replace("]", "");
   //     String substring = replace1.substring(1, replace1.length() - 1);
   //     System.out.println(substring);
   // }
   //
   // /*
   //  *
   //  * @author RenBoQing
   //  * @date 2022/4/21 0021 17:31
   //  */
   // @Test
   // public void testComments() {
   //     List<HospitalProjectVo> hospitalProjectVos = hopsptialProjectMapper.queryAllProject();
   //     for (HospitalProjectVo hospitalProjectVo : hospitalProjectVos) {
   //         System.out.println(hospitalProjectVo);
   //     }
   // }
   //
   // /*
   //  *多图上传  测试
   //  * @author RenBoQing
   //  * @date 2022/4/22 0022 11:06
   //  */
   // @Test
   // public void testce() {
   //     //String demo = "[\"/images/circle/202204221023047f3de31d76204b9c9ff3f9be532ebe1b.jpg\",\"/images/circle/202204221023056048d666ad6548159e75cea1811b091a.jpg\",\"/images/circle/20220422102305a05ba9ac80604093b864d7c1dda512e1.jpg\"]";
   //     //String replace = demo.replace("[", "");
   //     //String replace1 = replace.replace("\"", "");
   //     //String replace2 = replace1.replace("]", "");
   //     ////System.out.println(replace2);
   //     //String[] split = replace2.split(",");
   //     //
   //     //System.out.println(split);
   //     //String im = "";
   //     //String im1 = "";
   //     //String im2 = "";
   //     //System.out.println(split.length);
   //     //for (int i = 0; i < split.length; i++) {
   //     //    im = split[0];
   //     //    im1 = split[1];
   //     //    im2 = split[2];
   //     //}
   //     //System.out.println(im);
   //     //System.out.println(im1);
   //     //System.out.println(im2);
   //
   //     String test = "{\"url\" : \" / images/product/20220428223020.png\" }";
   //
   //     String replace3 = test.replace("{", "");
   //     String replace4 = replace3.replace("}", "");
   //     String replace5 = replace4.replace("\"", "");
   //     String replace6 = replace5.replace(":", "");
   //     String url = replace6.replace("url", "");
   //     String trim = url.trim();
   //     System.out.println(trim);
   // }
   //
   // /*
   //  *根据文章的cid查询当前文章的所有评论
   //  * @author RenBoQing
   //  * @date 2022/4/25 0025 9:26
   //  */
   // @Test
   // public void testAllCommentsByCid() {
   //     List<CommentsAllVo> commentsAllVos = commentsMapper.queryAllCommentsByCid(1);
   //     for (CommentsAllVo allVo : commentsAllVos) {
   //         System.out.println(allVo);
   //     }
   // }
   //
   //
   // @Test
   // public void tesrdemo() {
   //     List<CommentsVoTe> commentsVoTes = commentsMapper.queryAllByCid(1);
   //     for (CommentsVoTe commentsVoTe : commentsVoTes) {
   //         System.out.println(commentsVoTe);
   //     }
   // }
   // //更具
   //
   // @Test
   // public void tesrdemode() {
   //     List<CommentsReplVo> commentsReplVos = commentsMapper.queryReplVoBycomid(1);
   //     for (CommentsReplVo commentsReplVo : commentsReplVos) {
   //         System.out.println(commentsReplVo);
   //     }
   // }
   //
   // @Test
   // public void teddrtr() {
   //     List<Map<String, Object>> maps = userMapper.queryUserConut();
   //     for (Map<String, Object> map : maps) {
   //         System.out.println(map.toString());
   //     }
   // }
   //
   // @Test
   // public void testde() {
   //     //int addCart = cartMapper.addCart(new Cart(null,1,100,5,89,new Date(),new Date(),"select"));
   //     Cart cart = new Cart();
   //     cart.setProductid(1);
   // }
   ///*
   // *根据用户的id查询发布
   // * @author RenBoQing
   // * @date 2022/4/29 0029 21:55
   // */
   // @Test
   // public void queryUserComByUid() {
   //     List<UserCommVo> userCommVos = userMapper.queryUserCommVoByUid(100);
   //     //userCommVos.get(4).setCount(100);
   //     for (UserCommVo userCommVo : userCommVos) {
   //         System.out.println(userCommVo.toString());
   //     }
   // }
   //
   //
   // @Test
   //public  void helptest(){
   //     HelpVo helpVo=new HelpVo();
   //     List<HelpVo> helpVos = helpMapper.queryAllHelpVo(helpVo);
   //     for (HelpVo vo : helpVos) {
   //         System.out.println(vo);
   //     }
   // }
        }


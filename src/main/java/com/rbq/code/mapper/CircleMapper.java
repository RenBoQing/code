package com.rbq.code.mapper;

import com.rbq.code.entity.Circle;
import com.rbq.code.vovo.CircleVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author RenBoQing
 * @date 2022年04月19日 14:59
 * @Description
 */
@Mapper
public interface CircleMapper {
    /*
     *查询所有的数据
     * @author RenBoQing
     * @date 2022/4/19 0019 15:53
     * @param circle
     * @return java.util.List<com.rbq.code.entity.Circle>
     */
    List<Circle> queryAllCircles(Circle circle);

    /*
     *查询所有的宠友圈数据
     * @author RenBoQing
     * @date 2022/4/19 0019 17:06
     * @return java.util.List<com.rbq.code.vovo.CircleVo>
     */
    List<CircleVo> queryAllCirclesVo(CircleVo circleVo);

    /*
     *添加宠友圈 信息
     * @author RenBoQing
     * @date 2022/4/19 0019 17:08
     * @param circle
     * @return int
     */
    int addCircles(Circle circle);


    /*
     *查询所有的数据
     * @author RenBoQing
     * @date 2022/5/4 0004 10:27
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    public List<Map<String, Object>> queryCircleCount();

}

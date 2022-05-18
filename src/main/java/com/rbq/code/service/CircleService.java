package com.rbq.code.service;

import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.Circle;
import com.rbq.code.vovo.CircleVo;

import java.util.List;
import java.util.Map;

/**
 * @author RenBoQing
 * @date 2022年04月19日 15:03
 * @Description
 */
public interface CircleService {
    /*
     *查询所有的宠友圈信息
     * @author RenBoQing
     * @date 2022/4/19 0019 15:04
     * @param page
     * @param pageSize
     * @param circle
     * @return com.github.pagehelper.PageInfo<com.rbq.code.entity.Circle>
     */
    PageInfo<Circle> queryAllCircle(int page, int pageSize, Circle circle);

    /*
     *查询对应的所有的宠友圈数据
     * @author RenBoQing
     * @date  16:05
     * @param page
     * @param pageSize
     * @return com.github.pagehelper.PageInfo<com.rbq.code.vovo.CircleVo>
     */
    PageInfo<CircleVo> queryAllCircleVo(int page, int pageSize,CircleVo circleVo);
    /*
     *添加对应数据
     * @author RenBoQing
     * @date 2022/4/19 0019 17:25
     * @param circle
     * @return int
     */
    int addCircles(Circle circle);
    public List<Map<String, Object>> queryCircleCount();
}

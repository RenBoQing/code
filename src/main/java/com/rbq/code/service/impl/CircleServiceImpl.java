package com.rbq.code.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.Circle;
import com.rbq.code.mapper.CircleMapper;
import com.rbq.code.service.CircleService;
import com.rbq.code.vovo.CircleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年04月19日 15:05
 * @Description
 */
@Service
public class CircleServiceImpl implements CircleService {
    @Autowired
    private CircleMapper circleMapper;

    @Override
    public PageInfo<Circle> queryAllCircle(int page, int pageSize, Circle circle) {
        PageHelper.startPage(page, pageSize);
        List<Circle> circles = circleMapper.queryAllCircles(circle);
        PageInfo<Circle> circlePageInfo = new PageInfo<Circle>(circles);
        return circlePageInfo;
    }

    /*
     *查询所有的数据
     * @author RenBoQing
     * @date 2022/4/19 0019 16:08
     * @param page
     * @param pageSize
     * @return com.github.pagehelper.PageInfo<com.rbq.code.vovo.CircleVo>
     */
    @Override
    public PageInfo<CircleVo> queryAllCircleVo(int page, int pageSize,CircleVo circleVo) {
        PageHelper.startPage(page, pageSize);
        List<CircleVo> circleVos = circleMapper.queryAllCirclesVo(circleVo);
        PageInfo<CircleVo> circleVoPageInfo = new PageInfo<CircleVo>(circleVos);
        return circleVoPageInfo;
    }

    @Override
    public int addCircles(Circle circle) {
        return circleMapper.addCircles(circle);
    }
   /*
    *图表信息生成
    * @author RenBoQing
    * @date 2022/5/4 0004 10:28
    * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
    */
    @Override
    public List<Map<String, Object>> queryCircleCount() {
        return circleMapper.queryCircleCount();
    }
}

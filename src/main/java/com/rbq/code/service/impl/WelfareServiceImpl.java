package com.rbq.code.service.impl;

/**
 * @author RenBoQing
 * @date 2022年04月12日 21:54
 * @Description
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.Welfare;
import com.rbq.code.mapper.WelfareMapper;
import com.rbq.code.service.WelfareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WelfareServiceImpl implements WelfareService {
    @Autowired
    private WelfareMapper welfareMapper;

    /*
     *分页查询公益信息
     * @author RenBoQing
     * @date 2022/5/3 0003 12:16
     * @param page
     * @param pageSize
     * @param welfare
     * @return com.github.pagehelper.PageInfo<com.rbq.code.entity.Welfare>
     */
    @Override
    public PageInfo<Welfare> queryAllWelfare(int page, int pageSize, Welfare welfare) {
        PageHelper.startPage(page, pageSize);
        List<Welfare> welfareList = welfareMapper.queryAllWelfare(welfare);
        PageInfo<Welfare> welfarePageInfo = new PageInfo<Welfare>(welfareList);
        return welfarePageInfo;
    }

    /*
     *删除公益信息
     * @author RenBoQing
     * @date 2022/5/3 0003 12:16
     * @param id
     * @return int
     */
    @Override
    public int delWelfareById(Integer id) {
        return welfareMapper.delWelfareById(id);
    }

    /*
     *添加公益信息
     * @author RenBoQing
     * @date 2022/5/3 0003 13:37
     * @param welfare
     * @return int
     */
    @Override
    public int addWelfare(Welfare welfare) {
        return welfareMapper.addWelfare(welfare);
    }

    /*
     *
     * @author RenBoQing
     * @date 2022/5/3 0003 14:02
     * @param id
     * @return com.rbq.code.entity.Welfare
     */
    @Override
    public Welfare queryWelfareById(Integer id) {
        return welfareMapper.queryWelfareById(id);
    }

    /*
     *根据id更新
     * @author RenBoQing
     * @date 2022/5/3 0003 14:02
     * @param welfare
     * @return int
     */
    @Override
    public int updateWelfareById(Welfare welfare) {
        return welfareMapper.updateWelfareById(welfare);
    }

    /*
     *大数据页面
     * @author RenBoQing
     * @date 2022/5/4 0004 10:07
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    @Override
    public List<Map<String, Object>> queryWelfareCount() {
        return welfareMapper.queryWelfareCount();
    }
}

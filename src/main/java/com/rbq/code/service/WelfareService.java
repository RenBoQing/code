package com.rbq.code.service;

import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.Welfare;
import com.rbq.code.entity.Wiki;

import java.util.List;
import java.util.Map;

/**
 * @author RenBoQing
 * @date 2022年04月12日 21:52
 * @Description
 */
public interface WelfareService {
    PageInfo<Welfare> queryAllWelfare(int page, int pageSize, Welfare welfare);
    int delWelfareById(Integer id);
    int addWelfare(Welfare welfare);
    Welfare queryWelfareById(Integer id);
    int updateWelfareById(Welfare welfare);
    public List<Map<String, Object>> queryWelfareCount();
}

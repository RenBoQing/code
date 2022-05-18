package com.rbq.code.service;

import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.Hospital;
import com.rbq.code.entity.Wiki;

import java.util.List;
import java.util.Map;

/**
 * @author RenBoQing
 * @date 2022年04月04日 17:11
 * @Description
 */
public interface WikiService {
    PageInfo<Wiki> queryHosptialAll(int page, int pageSize, Wiki wiki);
    Wiki queryWikiById(Integer id);
    int deleteWikiById(Integer id);
    int addWiki(Wiki wiki);
    int delWikiByIds(List<Integer> delList);
    int updateWiki(Wiki wiki);
    public List<Map<String, Object>> queryWikiCount();
}

package com.rbq.code.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.Wiki;
import com.rbq.code.mapper.WikiMapper;
import com.rbq.code.service.WikiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author RenBoQing
 * @date 2022年04月04日 17:12
 * @Description 宠物百科服务层
 */
@Service
public class WikiServiceImpl implements WikiService {
    @Autowired
    private WikiMapper wikiMapper;
    /*
     *查询所有的百科信息  返回分页消息
     * @author RenBoQing
     * @date 2022/4/6 0006 14:00
     * @return java.util.List<com.rbq.code.entity.Wiki>
     */

    @Override
    public PageInfo<Wiki> queryHosptialAll(int page, int pageSize, Wiki wiki) {
        PageHelper.startPage(page, pageSize);
        List<Wiki> wikiList = wikiMapper.queryAllWiki(wiki);
        PageInfo<Wiki> wikiPageInfo = new PageInfo<Wiki>(wikiList);
        return wikiPageInfo;
    }

    /*
     *根据id查询对应的宠物百科信息
     * @author RenBoQing
     * @date 2022/4/6 0006 14:01
     * @param id
     * @return java.util.List<com.rbq.code.entity.Wiki>
     */
    @Override
    public Wiki queryWikiById(Integer id) {
        return wikiMapper.queryWikiById(id);
    }

    @Override
    public int deleteWikiById(Integer id) {
        return wikiMapper.deleteWikiById(id);
    }

    @Override
    public int addWiki(Wiki wiki) {
        return wikiMapper.addWiki(wiki);
    }

    @Override
    public int delWikiByIds(List<Integer> delList) {
        return wikiMapper.delWikiByIds(delList);
    }

    @Override
    public int updateWiki(Wiki wiki) {
        return wikiMapper.updateWiki(wiki);
    }

    @Override
    public List<Map<String, Object>> queryWikiCount() {
        return wikiMapper.queryWikiCount();
    }
}

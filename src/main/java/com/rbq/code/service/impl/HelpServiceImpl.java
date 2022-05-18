package com.rbq.code.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.Help;
import com.rbq.code.mapper.HelpMapper;
import com.rbq.code.service.HelpService;
import com.rbq.code.vovo.HelpVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年05月02日 10:03
 * @Description
 */
@Service
public class HelpServiceImpl implements HelpService {
    @Autowired
    private HelpMapper helpMapper;

    /*
     *查询所有发布
     * @author RenBoQing
     * @date 2022/5/2 0002 10:04
     * @param page
     * @param pageSize
     * @param helpVo
     * @return com.github.pagehelper.PageInfo<com.rbq.code.vovo.HelpVo>
     */
    @Override
    public PageInfo<HelpVo> queryAllHelp(int page, int pageSize, HelpVo helpVo) {
        PageHelper.startPage(page, pageSize);
        List<HelpVo> helpVos = helpMapper.queryAllHelpVo(helpVo);
        PageInfo<HelpVo> helpVoPageInfo = new PageInfo<>(helpVos);
        return helpVoPageInfo;
    }

    /*
     *添加
     * @author RenBoQing
     * @date 2022/5/2 0002 10:49
     * @param help
     * @return int
     */
    @Override
    public int addHelp(Help help) {
        help.setCreatetime(new Date());
        help.setIschecked(1);
        return helpMapper.addHelp(help);
    }
}

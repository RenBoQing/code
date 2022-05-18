package com.rbq.code.service;

import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.Help;
import com.rbq.code.vovo.HelpVo;

/**
 * @author RenBoQing
 * @date 2022年05月02日 10:01
 * @Description
 */
public interface HelpService {
    PageInfo<HelpVo> queryAllHelp(int page, int pageSize, HelpVo helpVo);

    int addHelp(Help help);
}

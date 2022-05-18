package com.rbq.code.mapper;

import com.rbq.code.entity.Help;
import com.rbq.code.vovo.HelpVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年05月02日 9:39
 * @Description
 */
@Component
@Mapper
public interface HelpMapper {
    /*
     *查询充互帮数据
     * @author RenBoQing
     * @date 2022/5/2 0002 10:38
     * @param helpVo
     * @return java.util.List<com.rbq.code.vovo.HelpVo>
     */
    List<HelpVo> queryAllHelpVo(HelpVo helpVo);

    /*
     *添加宠互帮数据
     * @author RenBoQing
     * @date 2022/5/2 0002 10:36
     * @return int
     */
    int addHelp(Help help);
}

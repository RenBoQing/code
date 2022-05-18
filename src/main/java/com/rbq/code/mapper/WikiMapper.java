package com.rbq.code.mapper;

import com.rbq.code.entity.Wiki;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author RenBoQing
 * @date 2022年04月04日 17:08
 * @Description
 */
@Mapper
public interface WikiMapper {
    /*
     *查询所有的百科数据
     * @author RenBoQing
     * @date 2022/4/6 0006 20:04
     * @return java.util.List<com.rbq.code.entity.Wiki>
     */
    List<Wiki> queryAllWiki(Wiki wiki);

    /*
     *根据id查询
     * @author RenBoQing
     * @date 2022/4/6 0006 20:05
     * @param id
     * @return java.util.List<com.rbq.code.entity.Wiki>
     */
    Wiki queryWikiById(Integer id);

    /*
     *根据id删除数据
     * @author RenBoQing
     * @date 2022/4/6 0006 20:07
     * @param id
     * @return int
     */
    int deleteWikiById(Integer id);

    /*
     *添加百科信息
     * @author RenBoQing
     * @date 2022/4/8 0008 9:40
     * @param wiki
     * @return int
     */
    int addWiki(Wiki wiki);

    /*
     *批量删除百科信息
     * @author RenBoQing
     * @date 2022/4/8 0008 9:40
     * @param delList
     */
    int delWikiByIds(List<Integer> delList);

    /*
     *修改百科相关信息
     * @author RenBoQing
     * @date 2022/4/9 0009 17:28
     * @param wiki
     * @return int
     */
    int updateWiki(Wiki wiki);

    /*
     *百科数据生成
     * @author RenBoQing
     * @date 2022/5/4 0004 8:56
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    public List<Map<String, Object>> queryWikiCount();
}

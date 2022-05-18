package com.rbq.code.service;

import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.Adopt;

import java.util.List;
import java.util.Map;

/**
 * @author RenBoQing
 * @date 2022年04月09日 11:58
 * @Description
 */
public interface AdoptService {

    /*
     *查询所有动物领养信息并分页
     * @author RenBoQing
     * @date 2022/4/14 0014 16:29
     * @param page
     * @param pageSize
     * @param adopt
     * @return com.github.pagehelper.PageInfo<com.rbq.code.entity.Adopt>
     */
    PageInfo<Adopt> queryAllAdopts(int page, int pageSize, Adopt adopt);

    /*
     *
     * @author RenBoQing
     * @date 2022/4/29 0029 20:24
     * @param adopt
     * @return java.util.List<com.rbq.code.entity.Adopt>
     */
    List<Adopt> queryAllAdoptBytime(Adopt adopt);

    /*
     *通过id删除领养信息
     * @author RenBoQing
     * @date 2022/4/15 0015 9:54
     * @param id
     * @return int
     */
    int deleteAdoptById(Integer id);

    /*
     *通过id批量删除
     * @author RenBoQing
     * @date 2022/4/15 0015 9:55
     * @param delList
     * @return int
     */
    int delAdoptsByIds(List<Integer> delList);

    /*
     *添加领养信息
     * @author RenBoQing
     * @date 2022/4/15 0015 14:31
     * @param adopt
     * @return int
     */
    int addAdopts(Adopt adopt);

    /*
     *根据id查询领养信息
     * @author RenBoQing
     * @date 2022/4/17 0017 11:05
     * @param id
     * @return com.rbq.code.entity.Adopt
     */
    Adopt queryAdoptById(Integer id);

    /*
     *修改医院信息
     * @author RenBoQing
     * @date 2022/4/17 0017 11:38
     * @param adopt
     * @return int
     */
    int updateAdopts(Adopt adopt);

    /*
     *图表信息生成
     * @author RenBoQing
     * @date 2022/5/4 0004 9:50
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    public List<Map<String, Object>> queryAdoptCount();
}

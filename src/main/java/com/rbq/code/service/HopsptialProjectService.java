package com.rbq.code.service;

import com.github.pagehelper.PageInfo;
import com.rbq.code.vovo.HospitalProjectVo;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年04月12日 16:53
 * @Description
 */
public interface HopsptialProjectService {
    /*
     *根据id查询对应的设置
     * @author RenBoQing
     * @date 2022/4/25 0025 17:25
     * @param id
     * @return java.util.List<com.rbq.code.vovo.HospitalProjectVo>
     */
    List<HospitalProjectVo> queryAllProjectById(Integer id);

    /*
     *分页查询医院项目
     * @author RenBoQing
     * @date 2022/4/25 0025 17:11
     * @param page
     * @param pageSize
     * @param hospitalProjectVo
     * @return com.github.pagehelper.PageInfo<com.rbq.code.vovo.HospitalProjectVo>
     */
    PageInfo<HospitalProjectVo> queryHopsptialProject(int page, int pageSize, HospitalProjectVo hospitalProjectVo);

    /*
     *根据id删除项目
     * @author RenBoQing
     * @date 2022/4/30 0030 16:51
     * @param rid
     * @return int
     */
    int deleteProjectByRid(Integer rid);

    /*
     *批量删除
     * @author RenBoQing
     * @date 2022/4/30 0030 17:27
     * @param delList
     * @return int
     */
    int delProByIds(List<Integer> delList);
}

package com.rbq.code.service;

import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.HosptialServiceVo;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年04月28日 10:42
 * @Description
 */

public interface HosptialProService {
    /*
     *查询所有的信息
     * @author RenBoQing
     * @date 2022/4/30 0030 19:45
     * @param page
     * @param pageSize
     * @param hosptialServiceVo
     * @return com.github.pagehelper.PageInfo<com.rbq.code.entity.HosptialServiceVo>
     */
    PageInfo<HosptialServiceVo> queryAllProject(int page, int pageSize, HosptialServiceVo hosptialServiceVo);

    /*
     *根据id删除
     * @author RenBoQing
     * @date 2022/4/30 0030 19:46
     * @param id
     * @return int
     */
    int deleteServiceById(Integer id);

    /*
     *添加项目
     * @author RenBoQing
     * @date 2022/4/30 0030 21:02
     * @param hosptialServiceVo
     * @return int
     */
    int addService(HosptialServiceVo hosptialServiceVo);

    /*
     *批量删除
     * @author RenBoQing
     * @date 2022/4/30 0030 21:21
     * @param delList
     * @return int
     */
    int delServiceByIds(List<Integer> delList);

    /*
     *修改医院信息
     * @author RenBoQing
     * @date 2022/4/30 0030 21:35
     * @param hosptialServiceVo
     * @return int
     */
    int updateServiceById(HosptialServiceVo hosptialServiceVo);

    /*
     *根据id查询项目数据
     * @author RenBoQing
     * @date 2022/4/30 0030 21:43
     * @param id
     * @return com.rbq.code.entity.HosptialServiceVo
     */
    HosptialServiceVo queryHosptialServiceVoById(Integer id);
}

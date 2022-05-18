package com.rbq.code.mapper;

import com.rbq.code.vovo.HospitalProjectVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年04月12日 15:28
 * @Description
 */
@Mapper
public interface HopsptialProjectMapper {
    /*
     *通过id查询所有数据
     * @author RenBoQing
     * @date 2022/4/21 0021 17:18
     * @param id
     * @return java.util.List<com.rbq.code.vovo.HospitalProjectVo>
     */
    List<HospitalProjectVo> queryAllProjectById(Integer id);

    /*
     *查询所有的数据
     * @author RenBoQing
     * @date 2022/4/21 0021 17:20
     * @return java.util.List<com.rbq.code.vovo.HospitalProjectVo>
     */
    List<HospitalProjectVo> queryAllProject();

    /*
     *根据id删除对应的项目
     * @author RenBoQing
     * @date 2022/4/30 0030 16:35
     * @param rid
     * @return int
     */
    int deleteProjectByRid(Integer rid);


    /*
     *批量删除
     * @author RenBoQing
     * @date 2022/4/30 0030 17:25
     * @param delList
     * @return int
     */
    int delProByIds(List<Integer> delList);
}

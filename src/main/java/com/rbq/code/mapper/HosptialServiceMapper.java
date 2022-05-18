package com.rbq.code.mapper;

import com.rbq.code.entity.HosptialServiceVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年04月28日 10:20
 * @Description
 */
@Mapper
public interface HosptialServiceMapper {
    /*
     *查询所有的医院项目服务
     * @author RenBoQing
     * @date 2022/4/30 0030 19:43
     * @param hosptialServiceVo
     * @return java.util.List<com.rbq.code.entity.HosptialServiceVo>
     */
    List<HosptialServiceVo> queryAllService(HosptialServiceVo hosptialServiceVo);

    /*
     *根据id删除对应的项目
     * @author RenBoQing
     * @date 2022/4/30 0030 19:44
     * @param id
     * @return int
     */
    int deleteServiceById(Integer id);

    /*
     *添加项目
     * @author RenBoQing
     * @date 2022/4/30 0030 20:59
     * @return int
     */
    int addService(HosptialServiceVo hosptialServiceVo);

    /*
     *批量删除
     * @author RenBoQing
     * @date 2022/4/30 0030 21:16
     * @param delList
     * @return int
     */
    int delServiceByIds(List<Integer> delList);


    /*
     *修改项目信息
     * @author RenBoQing
     * @date 2022/4/30 0030 21:31
     * @param hosptialServiceVo
     * @return int
     */
    int updateServiceById(HosptialServiceVo hosptialServiceVo);


    /*
     *查询对应的信息
     * @author RenBoQing
     * @date 2022/4/30 0030 21:39
     * @param id
     * @return com.rbq.code.entity.HosptialServiceVo
     */
    HosptialServiceVo queryHosptialServiceVoById(Integer id);

}

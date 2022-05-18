package com.rbq.code.mapper;

import com.rbq.code.entity.Hospital;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author RenBoQing
 * @date 2022年03月25日 10:53
 * @Description 医院信息Mapper层接口
 */
@Mapper
public interface HospitalMapper {

    /*
     *查询所有的医院信息
     * @author RenBoQing
     * @date 2022/3/27 0027 16:17
     * @return java.util.List<com.rbq.code.entity.Hospital>
     */
    List<Hospital> queryHosptialAll( Hospital hospital);
    /*
     *删除医院信息
     * @author RenBoQing
     * @date 2022/3/27 0027 16:17
     * @param id
     */
    void deleteHosptialById(Integer id);
    /*
     *添加医院信息
     * @author RenBoQing
     * @date 2022/3/29 0029 9:25
     * @param hospital
     */
    void addHosptial(Hospital hospital);

    /*
     *根据id查询医院
     * @author RenBoQing
     * @date 2022/4/6 0006 14:20
     * @param id
     * @return com.rbq.code.entity.Hospital
     */
    Hospital queryHosptialById(Integer id);

    /*
     *修改医院的信息
     * @author RenBoQing
     * @date 2022/4/6 0006 14:20
     * @param hospital
     * @return int
     */
    int updateHosptial(Hospital hospital);

    /*
     *echarts的图标信息
     * @author RenBoQing
     * @date 2022/4/6 0006 14:20
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    public List<Map<String, Object>> queryHosptialCount();

    /*
     *批量删除医院信息
     * @author RenBoQing
     * @date 2022/4/9 0009 9:16
     * @param delList
     * @return int
     */
    int delHosptialByIds(List<Integer> delList);
}

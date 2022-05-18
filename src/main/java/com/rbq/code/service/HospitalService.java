package com.rbq.code.service;

import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.Hospital;

import java.util.List;
import java.util.Map;

/**
 * @author RenBoQing
 * @date 2022年03月25日 11:20
 * @Description
 */
public interface HospitalService {


    /*
     *查询所有的数据
     * @author RenBoQing
     * @date 2022/3/27 0027 16:18
     * @return java.util.List<com.rbq.code.entity.Hospital>
     */
    //List<Hospital> queryHosptialAll();

    PageInfo<Hospital> queryHosptialAll( int page,int pageSize,Hospital hospital);

    /*
     *删除医院信息
     * @author RenBoQing
     * @date 2022/3/27 0027 16:19
     * @param id
     */
    void deleteHosptialById(Integer id);

    /*
     *添加医院信息
     * @author RenBoQing
     * @date 2022/4/9 0009 9:17
     * @param hospital
     */
    void addaddHosptial(Hospital hospital);

    /*
     *通过id查询医院信息
     * @author RenBoQing
     * @date 2022/4/9 0009 9:18
     * @param id
     * @return com.rbq.code.entity.Hospital
     */
    Hospital queryHosptialById(Integer id);

    /*
     *更新医院信息
     * @author RenBoQing
     * @date 2022/4/9 0009 9:18
     * @param hospital
     * @param hid
     * @return int
     */
    int updateHosptial(Hospital hospital, Integer hid);

    /*
     *图表信息生成
     * @author RenBoQing
     * @date 2022/4/9 0009 9:19
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    List<Map<String, Object>> queryHosptialCount();

    /*
     *批量删除医院信息
     * @author RenBoQing
     * @date 2022/4/9 0009 9:21
     * @param delList
     * @return int
     */
    int delHosptialByIds(List<Integer> delList);
}

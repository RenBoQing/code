package com.rbq.code.mapper;

import com.rbq.code.entity.Adopt;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author RenBoQing
 * @date 2022年04月09日 11:33
 * @Description 宠物领养Mapper
 */
@Mapper
@Repository
public interface AdoptMapper {
    /*
     *查询所有的领养信息 带参数
     * @author RenBoQing
     * @date 2022/4/15 0015 9:08
     * @param adopt
     * @return java.util.List<com.rbq.code.entity.Adopt>
     */
    List<Adopt> queryAllAdopt(Adopt adopt);


    /*
     *按照时间排序
     * @author RenBoQing
     * @date 2022/4/29 0029 20:17
     * @param adopt
     * @return java.util.List<com.rbq.code.entity.Adopt>
     */
    List<Adopt> queryAllAdoptBytime(Adopt adopt);


    /*
     *根据id删除对应的领养信息
     * @author RenBoQing
     * @date 2022/4/15 0015 9:09
     * @param id
     * @return int
     */
    int deleteAdoptById(Integer id);

    /*
     *批量删除
     * @author RenBoQing
     * @date 2022/4/15 0015 9:52
     * @param delList
     * @return int
     */
    int delAdoptsByIds(List<Integer> delList);

    /*
     *添加领养信息
     * @author RenBoQing
     * @date 2022/4/15 0015 14:21
     * @param adopt
     * @return int
     */
    int addAdopts(Adopt adopt);

    /*
     *根据id查询领养信息
     * @author RenBoQing
     * @date 2022/4/17 0017 11:01
     * @param id
     * @return com.rbq.code.entity.Adopt
     */
    Adopt queryAdoptById(Integer id);

    /*
     *修改领养信息
     * @author RenBoQing
     * @date 2022/4/17 0017 11:23
     * @param adopt
     * @return int
     */
    int updateAdopts(Adopt adopt);


    /*
     *图表信息生成
     * @author RenBoQing
     * @date 2022/5/4 0004 9:48
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    public List<Map<String, Object>> queryAdoptCount();
}

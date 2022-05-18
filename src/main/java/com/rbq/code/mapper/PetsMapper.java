package com.rbq.code.mapper;

import com.rbq.code.entity.Pets;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年04月03日 8:48
 * @Description 宠物信息接口
 */
@Mapper
public interface PetsMapper {
    /*
     *查询所有的宠物数据
     * @author RenBoQing
     * @date 2022/4/6 0006 19:08
     * @return java.util.List<com.rbq.code.entity.Pets>
     */
    List<Pets> queryAllPets();

    /*
     * 添加宠物信息
     * @author RenBoQing
     * @date 2022/4/6 0006 19:08
     * @param pets
     * @return int
     */
    int addPets(Pets pets);
}

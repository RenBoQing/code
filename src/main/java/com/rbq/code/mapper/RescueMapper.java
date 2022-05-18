package com.rbq.code.mapper;

import com.rbq.code.entity.Rescue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年04月06日 9:28
 * @Description
 */
@Mapper
public interface RescueMapper {
    List<Rescue> queryAllRescues();
    List<Rescue> queryRescuesById(Integer id);
}

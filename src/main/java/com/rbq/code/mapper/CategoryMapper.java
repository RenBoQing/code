package com.rbq.code.mapper;

import com.rbq.code.entity.Category;
import com.rbq.code.entity.Hospital;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年04月12日 9:18
 * @Description
 */
@Mapper
public interface CategoryMapper {
    List<Category> queryAllProductByCategory( Category category);
}

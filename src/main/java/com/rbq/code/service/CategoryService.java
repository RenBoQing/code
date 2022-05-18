package com.rbq.code.service;

import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.Category;

/**
 * @author RenBoQing
 * @date 2022年04月12日 9:31
 * @Description
 */
public interface CategoryService {
    /*
     *根据分类查询所以
     * @author RenBoQing
     * @date 2022/4/19 0019 9:33
     * @param page
     * @param pageSize
     * @param category
     * @return com.github.pagehelper.PageInfo<com.rbq.code.entity.Category>
     */
    PageInfo<Category> queryAllProductByCategory(int page, int pageSize, Category category);
}

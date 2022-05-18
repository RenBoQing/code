package com.rbq.code.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.Category;
import com.rbq.code.mapper.CategoryMapper;
import com.rbq.code.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年04月12日 9:32
 * @Description
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public PageInfo<Category> queryAllProductByCategory(int page, int pageSize, Category category) {
        PageHelper.startPage(page, pageSize);
        List<Category> categoryList = categoryMapper.queryAllProductByCategory(category);
        PageInfo<Category> categoryPageInfo = new PageInfo<Category>(categoryList);
        return categoryPageInfo;
    }
}

package com.rbq.code.service.impl;

import com.rbq.code.entity.Menu;
import com.rbq.code.mapper.MenuMapper;
import com.rbq.code.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年04月01日 9:19
 * @Description
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> queryMenuAll() {
        return menuMapper.queryAllMenu();
    }
}

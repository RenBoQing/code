package com.rbq.code.mapper;

import com.rbq.code.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年03月31日 15:39
 * @Description 用户权限管理接口
 */
@Mapper
public interface MenuMapper {
    /*
     *查询所有的菜单数据
     * @author RenBoQing
     * @date 2022/4/6 0006 19:07
     * @return java.util.List<com.rbq.code.entity.Menu>
     */
    List<Menu> queryAllMenu();
}

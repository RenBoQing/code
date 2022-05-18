package com.rbq.code.service;

import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.SysUser;
import com.rbq.code.entity.Welfare;

/**
 * @author RenBoQing
 * @date 2022年03月24日 11:23
 * @Description
 */
public interface SysUserService {
    SysUser login(SysUser sysUser);
    PageInfo<SysUser> queryAllSys(int page, int pageSize, SysUser sysUser);
}

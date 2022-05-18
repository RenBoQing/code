package com.rbq.code.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.SysUser;
import com.rbq.code.mapper.SysUserMapper;
import com.rbq.code.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年03月30日 8:56
 * @Description
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper ;
    @Override
    public SysUser login(SysUser sysUser) {
        return sysUserMapper.getSysUser(sysUser);
    }

    @Override
    public PageInfo<SysUser> queryAllSys(int page, int pageSize, SysUser sysUser) {
        PageHelper.startPage(page,pageSize);
        List<SysUser> sysUsers = sysUserMapper.queryAllSysUser(sysUser);
         PageInfo<SysUser> sysUserPageInfo=new PageInfo<>(sysUsers);
        return sysUserPageInfo;
    }
}

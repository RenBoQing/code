package com.rbq.code.mapper;

import com.rbq.code.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年03月24日 11:18
 * @Description
 */
@Mapper
public interface SysUserMapper {
    SysUser  getSysUser(SysUser sysUser);
    List<SysUser> queryAllSysUser(SysUser sysUser);
}

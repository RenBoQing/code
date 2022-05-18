package com.rbq.code.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rbq.code.mapper.HopsptialProjectMapper;
import com.rbq.code.service.HopsptialProjectService;
import com.rbq.code.vovo.HospitalProjectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年04月12日 16:53
 * @Description
 */
@Service
public class HopsptialProjectServiceImpl implements HopsptialProjectService {
    @Autowired
    private HopsptialProjectMapper hopsptialProjectMapper;

    /*
     * 通过id查询
     * @author RenBoQing
     * @date 2022/4/21 0021 19:48
     * @param id
     * @return java.util.List<com.rbq.code.vovo.HospitalProjectVo>
     */
    @Override
    public List<HospitalProjectVo> queryAllProjectById(Integer id) {
        return hopsptialProjectMapper.queryAllProjectById(id);
    }

    /*
     *分页查询数据
     * @author RenBoQing
     * @date 2022/4/21 0021 19:48
     * @param page
     * @param pageSize
     * @param hospitalProjectVo
     * @return com.github.pagehelper.PageInfo<com.rbq.code.vovo.HospitalProjectVo>
     */
    @Override
    public PageInfo<HospitalProjectVo> queryHopsptialProject(int page, int pageSize, HospitalProjectVo hospitalProjectVo) {
        PageHelper.startPage(page, pageSize);
        List<HospitalProjectVo> hospitalProjectVos = hopsptialProjectMapper.queryAllProject();
        PageInfo<HospitalProjectVo> hospitalProjectVoPageInfo = new PageInfo<>(hospitalProjectVos);
        return hospitalProjectVoPageInfo;
    }

    /*
     *根据id查询项目
     * @author RenBoQing
     * @date 2022/4/30 0030 16:52
     * @param rid
     * @return int
     */
    @Override
    public int deleteProjectByRid(Integer rid) {
        return hopsptialProjectMapper.deleteProjectByRid(rid);
    }

    /*
     *批量删除
     * @author RenBoQing
     * @date 2022/4/30 0030 17:28
     * @param delList
     * @return int
     */
    @Override
    public int delProByIds(List<Integer> delList) {
        return hopsptialProjectMapper.delProByIds(delList);
    }
}

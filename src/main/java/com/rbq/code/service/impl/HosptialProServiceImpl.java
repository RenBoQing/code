package com.rbq.code.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.HosptialServiceVo;
import com.rbq.code.mapper.HosptialServiceMapper;
import com.rbq.code.service.HosptialProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年04月28日 10:46
 * @Description
 */
@Service
public class HosptialProServiceImpl implements HosptialProService {
    @Autowired
    private HosptialServiceMapper hosptialServiceMapper;

    /*
     *请求所有的参数并分页   查询所有的数据
     * @author RenBoQing
     * @date 2022/4/28 0028 17:31
     * @param page
     * @param pageSize
     * @param hosptialServiceVo
     * @return com.github.pagehelper.PageInfo<com.rbq.code.entity.HosptialServiceVo>
     */
    @Override
    public PageInfo<HosptialServiceVo> queryAllProject(int page, int pageSize, HosptialServiceVo hosptialServiceVo) {
        PageHelper.startPage(page, pageSize);
        List<HosptialServiceVo> hosptialServiceVos = hosptialServiceMapper.queryAllService(hosptialServiceVo);
        PageInfo<HosptialServiceVo> hosptialServiceVoPageInfo = new PageInfo<>(hosptialServiceVos);
        return hosptialServiceVoPageInfo;
    }

    /*
     *根据id删除对应的信息
     * @author RenBoQing
     * @date 2022/4/30 0030 20:17
     * @param id
     * @return int
     */
    @Override
    public int deleteServiceById(Integer id) {
        return hosptialServiceMapper.deleteServiceById(id);
    }

    /*
     *添加项目
     * @author RenBoQing
     * @date 2022/4/30 0030 21:03
     * @param hosptialServiceVo
     * @return int
     */
    @Override
    public int addService(HosptialServiceVo hosptialServiceVo) {
        return hosptialServiceMapper.addService(hosptialServiceVo);
    }
  /*
   *批量删除
   * @author RenBoQing
   * @date 2022/4/30 0030 21:21
   * @param delList
   * @return int
   */
    @Override
    public int delServiceByIds(List<Integer> delList) {
        return hosptialServiceMapper.delServiceByIds(delList);
    }
    /*
     *修改项目信息
     * @author RenBoQing
     * @date 2022/4/30 0030 21:36
     * @param hosptialServiceVo
     * @return int
     */
    @Override
    public int updateServiceById(HosptialServiceVo hosptialServiceVo) {
        return hosptialServiceMapper.updateServiceById(hosptialServiceVo);
    }
  /*
   *根据id查询对应得项目数据
   * @author RenBoQing
   * @date 2022/4/30 0030 21:44
   * @param id
   * @return com.rbq.code.entity.HosptialServiceVo
   */
    @Override
    public HosptialServiceVo queryHosptialServiceVoById(Integer id) {
        return hosptialServiceMapper.queryHosptialServiceVoById(id);
    }
}

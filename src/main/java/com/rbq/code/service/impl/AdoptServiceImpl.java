package com.rbq.code.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.Adopt;
import com.rbq.code.mapper.AdoptMapper;
import com.rbq.code.service.AdoptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author RenBoQing
 * @date 2022年04月09日 11:59
 * @Description
 */
@Service
public class AdoptServiceImpl implements AdoptService {
    @Autowired
    private AdoptMapper adoptMapper;

    /*
     *查询所有的领养信息分页并传参
     * @author RenBoQing
     * @date 2022/4/14 0014 16:32
     * @param page
     * @param pageSize
     * @param adopt
     * @return com.github.pagehelper.PageInfo<com.rbq.code.entity.Adopt>
     */
    @Override
    public PageInfo<Adopt> queryAllAdopts(int page, int pageSize, Adopt adopt) {
        PageHelper.startPage(page, pageSize);
        List<Adopt> adoptList = adoptMapper.queryAllAdopt(adopt);
        PageInfo<Adopt> adoptPageInfo = new PageInfo<Adopt>(adoptList);
        return adoptPageInfo;
    }

    /*
     *
     * @author RenBoQing
     * @date 2022/4/29 0029 20:25
     * @param adopt
     * @return java.util.List<com.rbq.code.entity.Adopt>
     */
    @Override
    public List<Adopt> queryAllAdoptBytime(Adopt adopt) {
        return adoptMapper.queryAllAdoptBytime(adopt);
    }

    /*
     *根据id删除
     * @author RenBoQing
     * @date 2022/4/15 0015 9:27
     * @param id
     * @return int
     */
    @Override
    public int deleteAdoptById(Integer id) {
        return adoptMapper.deleteAdoptById(id);
    }

    /*
     *批量删除
     * @author RenBoQing
     * @date 2022/4/15 0015 14:32
     * @param delList
     * @return int
     */
    @Override
    public int delAdoptsByIds(List<Integer> delList) {
        return adoptMapper.delAdoptsByIds(delList);
    }

    /*
     *添加领养信息
     * @author RenBoQing
     * @date 2022/4/15 0015 14:32
     * @param adopt
     * @return int
     */
    @Override
    public int addAdopts(Adopt adopt) {
        return adoptMapper.addAdopts(adopt);
    }

    /*
     *根据id查询领养信息
     * @author RenBoQing
     * @date 2022/4/17 0017 11:06
     * @param id
     * @return com.rbq.code.entity.Adopt
     */
    @Override
    public Adopt queryAdoptById(Integer id) {
        return adoptMapper.queryAdoptById(id);
    }

    /*
     *修改领养信息
     * @author RenBoQing
     * @date 2022/4/17 0017 11:39
     * @param adopt
     * @return int
     */
    @Override
    public int updateAdopts(Adopt adopt) {
        return adoptMapper.updateAdopts(adopt);
    }
   /*
    *图表信息生成
    * @author RenBoQing
    * @date 2022/5/4 0004 9:51
    * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
    */
    @Override
    public List<Map<String, Object>> queryAdoptCount() {
        return adoptMapper.queryAdoptCount();
    }
}

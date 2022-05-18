package com.rbq.code.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.Hospital;
import com.rbq.code.mapper.HospitalMapper;
import com.rbq.code.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author RenBoQing
 * @date 2022年03月25日 11:22
 * @Description
 */
@Service
public class HospitalServiceImpl implements HospitalService {
    @Autowired
    private HospitalMapper hospitalMapper;

    /*
     *查询所有医院信息
     * @author RenBoQing
     * @date 2022/4/9 0009 9:41
     * @return java.util.List<com.rbq.code.entity.Hospital>
     */
    @Override
    public PageInfo<Hospital> queryHosptialAll(int page, int pageSize, Hospital hospital) {
        PageHelper.startPage(page,pageSize);
        List<Hospital> hospitalList = hospitalMapper.queryHosptialAll(hospital);
        PageInfo<Hospital> hospitalPageInfo = new PageInfo<Hospital>(hospitalList);
        return hospitalPageInfo;
    }

    /*
     *通过id查询医院信息
     * @author RenBoQing
     * @date 2022/4/9 0009 9:41
     * @param id
     */
    @Override
    public void deleteHosptialById(Integer id) {
        hospitalMapper.deleteHosptialById(id);
    }

    /*
     *添加医院信息
     * @author RenBoQing
     * @date 2022/4/9 0009 9:42
     * @param hospital
     */
    @Override
    public void addaddHosptial(Hospital hospital) {
        hospitalMapper.addHosptial(hospital);
    }

    /*
     *通过id查询医院信息
     * @author RenBoQing
     * @date 2022/4/9 0009 9:42
     * @param id
     * @return com.rbq.code.entity.Hospital
     */
    @Override
    public Hospital queryHosptialById(Integer id) {
        return hospitalMapper.queryHosptialById(id);
    }

    /*
     *修改对应的信息
     * @author RenBoQing
     * @date 2022/4/9 0009 9:42
     * @param hospital
     * @param hid
     * @return int
     */
    @Override
    public int updateHosptial(Hospital hospital, Integer hid) {
        int i = hospitalMapper.updateHosptial(hospital);
        return i;
    }

    /*
     *
     * @author RenBoQing
     * @date 2022/4/9 0009 9:43
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    @Override
    public List<Map<String, Object>> queryHosptialCount() {
        return hospitalMapper.queryHosptialCount();
    }

    /*
     *批量删除医院
     * @author RenBoQing
     * @date 2022/4/9 0009 9:43
     * @param delList
     * @return int
     */
    @Override
    public int delHosptialByIds(List<Integer> delList) {
        return hospitalMapper.delHosptialByIds(delList);
    }
}

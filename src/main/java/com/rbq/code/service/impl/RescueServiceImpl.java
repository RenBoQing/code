package com.rbq.code.service.impl;

import com.rbq.code.entity.Rescue;
import com.rbq.code.mapper.RescueMapper;
import com.rbq.code.service.RescueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年04月06日 9:33
 * @Description
 */
@Service
public class RescueServiceImpl implements RescueService {
    @Autowired
    private RescueMapper rescueMapper;

    @Override
    public List<Rescue> queryAllRescues() {
        return rescueMapper.queryAllRescues();
    }

    @Override
    public List<Rescue> queryRescuesById(Integer id) {
        return rescueMapper.queryRescuesById(id);
    }
}

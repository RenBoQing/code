package com.rbq.code.service;

import com.rbq.code.entity.Rescue;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年04月06日 9:31
 * @Description
 */
public interface RescueService {
    List<Rescue>  queryAllRescues();
    List<Rescue>  queryRescuesById(Integer id);
}

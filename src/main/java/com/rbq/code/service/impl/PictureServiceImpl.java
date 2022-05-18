package com.rbq.code.service.impl;

import com.rbq.code.entity.Picture;
import com.rbq.code.mapper.PictureMapper;
import com.rbq.code.service.PictureService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年04月03日 10:17
 * @Description
 */
@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureMapper pictureMapper;

    @Override
    public List<Picture> queryAllPicture() {
        return pictureMapper.queryAllPicture();
    }
}

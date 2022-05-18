package com.rbq.code.mapper;

import com.rbq.code.entity.Picture;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年04月03日 10:12
 * @Description
 */
@Mapper
public interface PictureMapper {
    List<Picture> queryAllPicture();
}

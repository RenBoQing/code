package com.rbq.code.mapper;

import com.rbq.code.entity.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年05月02日 15:03
 * @Description
 */
@Mapper
public interface MessageMapper {
    int deleteByPrimaryKey(Integer messageid);

    int insert(Message message);

    Message selectByPrimaryKey(Integer messageid);

    List<Message> selectAll();

    int updateByPrimaryKey(Message message);

    ArrayList<Message> selectByUid(Integer touid, Integer fromuid);
}

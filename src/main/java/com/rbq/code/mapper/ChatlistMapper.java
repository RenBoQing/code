package com.rbq.code.mapper;

import com.rbq.code.entity.Chatlist;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年04月22日 19:37
 * @Description
 */
@Mapper
public interface ChatlistMapper {

    int deleteByPrimaryKey(Integer listid);

    int insert(Chatlist record);

    Chatlist selectByPrimaryKey(Integer listId);

    List<Chatlist> selectAll();

    int updateByPrimaryKey(Chatlist chatlist);

    Chatlist selectByTwoUid(Integer fromuid, Integer touid);

    ArrayList<Chatlist> selectByUid(Integer uid);
}

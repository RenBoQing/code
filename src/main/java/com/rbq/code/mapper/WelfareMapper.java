package com.rbq.code.mapper;

import com.rbq.code.entity.Welfare;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author RenBoQing
 * @date 2022年04月12日 21:46
 * @Description
 */
@Mapper
@Repository
public interface WelfareMapper {
    List<Welfare> queryAllWelfare(Welfare welfare);

    int delWelfareById(Integer id);

    int addWelfare(Welfare welfare);

    Welfare queryWelfareById(Integer id);

    int updateWelfareById(Welfare welfare);

    /*
     *查询所有的数据
     * @author RenBoQing
     * @date 2022/5/11 0011 21:37
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    List<Map<String, Object>> queryWelfareCount();
}

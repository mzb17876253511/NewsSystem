package com.winter.mapper;

import com.winter.model.Advice;

public interface AdviceMapper {
    int deleteByPrimaryKey(String aId);

    int insert(Advice record);

    int insertSelective(Advice record);

    Advice selectByPrimaryKey(String aId);

    int updateByPrimaryKeySelective(Advice record);

    int updateByPrimaryKey(Advice record);
}
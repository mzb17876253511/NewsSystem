package com.winter.mapper;

import com.winter.model.Tinynews;

public interface TinynewsMapper {
    int deleteByPrimaryKey(String tId);

    int insert(Tinynews record);

    int insertSelective(Tinynews record);

    Tinynews selectByPrimaryKey(String tId);

    int updateByPrimaryKeySelective(Tinynews record);

    int updateByPrimaryKey(Tinynews record);
}
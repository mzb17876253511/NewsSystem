package com.winter.mapper;

import com.winter.model.Menu;

public interface MenuMapper {
    int deleteByPrimaryKey(String mId);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(String mId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}
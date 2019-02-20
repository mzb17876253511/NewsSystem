package com.winter.mapper;

import com.winter.model.Users;

public interface UsersMapper {
    int deleteByPrimaryKey(String uId);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(String uId);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}
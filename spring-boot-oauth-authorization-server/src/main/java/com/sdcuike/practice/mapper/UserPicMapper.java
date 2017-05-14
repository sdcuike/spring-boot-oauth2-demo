package com.sdcuike.practice.mapper;

import com.sdcuike.practice.domain.UserPic;
import com.sdcuike.practice.domain.UserPicWithBLOBs;

public interface UserPicMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserPicWithBLOBs record);

    int insertSelective(UserPicWithBLOBs record);

    UserPicWithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserPicWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UserPicWithBLOBs record);

    int updateByPrimaryKey(UserPic record);
}
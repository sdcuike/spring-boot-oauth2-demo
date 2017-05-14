package com.sdcuike.practice.mapper;

import com.sdcuike.practice.config.DatasourceConfig.UseDataSourceTest;
import com.sdcuike.practice.domain.UserAuthority;

import java.util.List;

@UseDataSourceTest
public interface UserAuthorityMapper {
    int deleteByPrimaryKey(UserAuthority key);

    int insert(UserAuthority record);

    int insertSelective(UserAuthority record);
    
    List<UserAuthority> findByUserId(Long userId);
}
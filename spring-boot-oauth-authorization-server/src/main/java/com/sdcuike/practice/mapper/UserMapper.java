package com.sdcuike.practice.mapper;

import com.sdcuike.practice.config.DatasourceConfig.UseDataSourceTest;
import com.sdcuike.practice.domain.User;

@UseDataSourceTest
public interface UserMapper {
    int deleteByPrimaryKey(Long id);
    
    int insert(User record);
    
    int insertSelective(User record);
    
    User selectByPrimaryKey(Long id);
    
    int updateByPrimaryKeySelective(User record);
    
    int updateByPrimaryKey(User record);
    User findByLoginName(String loginName);
}
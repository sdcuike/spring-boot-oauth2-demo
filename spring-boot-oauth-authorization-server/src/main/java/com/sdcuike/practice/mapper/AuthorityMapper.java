package com.sdcuike.practice.mapper;

import com.sdcuike.practice.config.DatasourceConfig.UseDataSourceTest;
import com.sdcuike.practice.domain.Authority;

@UseDataSourceTest
public interface AuthorityMapper {
    int deleteByPrimaryKey(String name);

    int insert(Authority record);

    int insertSelective(Authority record);
}
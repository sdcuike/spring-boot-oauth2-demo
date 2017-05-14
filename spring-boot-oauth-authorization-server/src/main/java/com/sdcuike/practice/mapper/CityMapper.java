package com.sdcuike.practice.mapper;

import com.sdcuike.practice.config.DatasourceConfig.UseDataSourceTest;
import com.sdcuike.practice.domain.City;

@UseDataSourceTest
public interface CityMapper {
    int deleteByPrimaryKey(Long id);
    
    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}
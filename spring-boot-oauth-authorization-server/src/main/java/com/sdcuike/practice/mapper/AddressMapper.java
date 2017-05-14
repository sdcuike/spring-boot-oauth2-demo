package com.sdcuike.practice.mapper;

import com.sdcuike.practice.domain.Address;

public interface AddressMapper {
    int deleteByPrimaryKey(Long addrId);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Long addrId);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}
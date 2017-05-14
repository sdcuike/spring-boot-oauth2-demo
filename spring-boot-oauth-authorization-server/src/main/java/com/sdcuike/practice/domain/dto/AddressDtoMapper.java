package com.sdcuike.practice.domain.dto;

import com.sdcuike.practice.domain.Address;
import org.mapstruct.Mapper;

/**
 * Created by beaver on 2017/5/2.
 */
@Mapper
public interface AddressDtoMapper {
    
    AddressDto address2Dto(Address address);
}

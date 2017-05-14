package com.sdcuike.practice.domain.dto;

import com.sdcuike.practice.domain.City;
import org.mapstruct.Mapper;

/**
 * Created by beaver on 2017/4/14.
 */
@Mapper
public interface CityDtoMapper {
    InsertCityRequestDto cityToDto(City city);
    City cityDto2City(InsertCityRequestDto insertCityRequestDto);
    City cityDto2City(UpdateCityRequestDto updateCityRequestDto);
}

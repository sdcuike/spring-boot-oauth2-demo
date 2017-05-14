package com.sdcuike.practice.domain.dto;

import com.sdcuike.practice.domain.City;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by beaver on 2017/4/14.
 */
@Data
public class InsertCityRequestDto {
    @NotNull
    private String name;
    
    @NotNull
    private String state;
    
    
    public static void main(String[] args) {
        City city = new City();
        city.setId(12L);
        city.setName("na");
        city.setState("shandong");
        CityDtoMapper cityDtoMapper = new CityDtoMapperImpl();
        InsertCityRequestDto insertCityRequestDto = cityDtoMapper.cityToDto(city);
        System.out.println(insertCityRequestDto);
    }
    
}

package com.sdcuike.practice.controller;

import com.doctor.beaver.domain.result.ModelResult;
import com.sdcuike.practice.domain.City;
import com.sdcuike.practice.domain.dto.CityDtoMapper;
import com.sdcuike.practice.domain.dto.InsertCityRequestDto;
import com.sdcuike.practice.domain.dto.UpdateCityRequestDto;
import com.sdcuike.practice.mapper.CityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by beaver on 2017/4/25.
 */
@RestController
@RequestMapping(path = "/city", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class CityController {
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private CityDtoMapper cityDtoMapper;
    
    /**
     * 城市收录
     *
     * @param insertCityRequestDto
     * @return
     */
    @PutMapping("/insert")
    public ModelResult<City> insertCity(@Validated @RequestBody InsertCityRequestDto insertCityRequestDto) {
        ModelResult<City> modelResult = new ModelResult<>();
        City city = cityDtoMapper.cityDto2City(insertCityRequestDto);
        int count = cityMapper.insert(city);
        if (count == 1) {
            modelResult.setData(city);
        } else {
            modelResult.setReturnCode("-1");
            modelResult.setReturnMsg("操作数据库失败");
        }
        return modelResult;
    }
    
    @PostMapping("/update")
    public ModelResult<City> update(@Validated @RequestBody UpdateCityRequestDto updateCityRequestDto) {
        City city = cityDtoMapper.cityDto2City(updateCityRequestDto);
        ModelResult<City> modelResult = new ModelResult<>();
        int count = cityMapper.updateByPrimaryKeySelective(city);
        if (count == 1) {
            city = cityMapper.selectByPrimaryKey(city.getId());
            modelResult.setData(city);
        } else {
            modelResult.setReturnCode("-1");
            modelResult.setReturnMsg("操作数据库失败");
        }
        return modelResult;
    }
    
    @GetMapping("/get/{id}")
    public City queryById(@PathVariable("id") Long id) {
        return cityMapper.selectByPrimaryKey(id);
    }
}

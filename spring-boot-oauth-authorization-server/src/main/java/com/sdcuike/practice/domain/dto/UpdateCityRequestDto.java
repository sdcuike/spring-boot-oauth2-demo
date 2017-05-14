package com.sdcuike.practice.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * Created by beaver on 2017/4/25.
 */
@Data
@NoArgsConstructor
public class UpdateCityRequestDto {
    @NotNull
    private Long id;
    
    private String name;
    
    private String state;
}

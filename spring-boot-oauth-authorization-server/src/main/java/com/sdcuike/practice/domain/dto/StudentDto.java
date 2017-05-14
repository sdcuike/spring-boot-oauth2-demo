package com.sdcuike.practice.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by beaver on 2017/5/2.
 */
@Data
@NoArgsConstructor
public class StudentDto {
    
    private Long studId;
    
    private String name;
    
    private String email;
    
    private String phone;
    
    private LocalDateTime dob;
    
    private List<AddressDto> addresses;
}

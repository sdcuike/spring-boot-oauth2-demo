package com.sdcuike.practice.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class Student {
    private Long studId;
    
    private String name;
    
    private String email;
    
    private String phone;
    
    private LocalDateTime dob;
    
    private List<Address> addresses;
}
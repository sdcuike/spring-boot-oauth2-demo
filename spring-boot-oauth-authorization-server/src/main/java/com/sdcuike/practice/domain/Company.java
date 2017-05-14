package com.sdcuike.practice.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Company {
    private Long id;
    
   
    private String companyOid;
    
   
    private String name;
    
    private Long logoId;
    
    private String createdBy;
    
    private LocalDateTime createdDate;
    
    private Boolean doneRegisterLead;
    
    private String taxId;
    
    private CompanyType companyType;
    
    private LocalDateTime updateDate;
    
  
}
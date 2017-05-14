package com.sdcuike.practice.domain;

import com.sdcuike.mybatis.auditor.AbstractAuditingEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class User extends AbstractAuditingEntity {
    private Long id;
    
    private String loginName;
    
    private String phone;
    
    private String passwordHash;
    
    private String firstName;
    
    private String lastName;
    
    private String email;
    
    private String imageUrl;
    
    private Boolean activated;
    
    private String langKey;
    
    private String activationKey;
    
    private String resetKey;
    
    private Date resetTime;
    
    private Set<Authority> authorities = new HashSet<>();
    
    
}
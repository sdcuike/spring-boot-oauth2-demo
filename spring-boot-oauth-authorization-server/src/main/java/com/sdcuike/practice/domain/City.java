package com.sdcuike.practice.domain;

import com.sdcuike.mybatis.auditor.AbstractAuditingEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class City extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 城市id
     */
    private Long              id;

    private String            name;

    private String            state;
}

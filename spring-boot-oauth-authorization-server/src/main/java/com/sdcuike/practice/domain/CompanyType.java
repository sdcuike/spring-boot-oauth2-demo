package com.sdcuike.practice.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.sdcuike.mybatis.type.IEnumValueType;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by beaver on 2017/4/19.
 */

@Getter
@ToString
public enum CompanyType implements IEnumValueType {
    /**
     * 1, "类型1"
     */
    A(1, "类型1"),
    /**
     * 2, "类型2"
     */
    B(2, "类型2");
    
    private int code;
    private String description;
    
    CompanyType(int code, String description) {
        this.code = code;
        this.description = description;
    }
    
    @Override
    public int getValue() {
        return code;
    }
    
    @JsonCreator
    public static CompanyType ofValue(int value) {
        return IEnumValueType.of(CompanyType.class, value);
    }
}

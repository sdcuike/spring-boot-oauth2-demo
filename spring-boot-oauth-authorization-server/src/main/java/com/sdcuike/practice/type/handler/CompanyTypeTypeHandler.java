package com.sdcuike.practice.type.handler;

import com.sdcuike.mybatis.type.EnumValueTypeHandler;
import com.sdcuike.practice.domain.CompanyType;
import org.apache.ibatis.type.MappedTypes;

/**
 * Created by beaver on 2017/4/19.
 */
@MappedTypes(CompanyType.class)
public class CompanyTypeTypeHandler extends EnumValueTypeHandler {
}

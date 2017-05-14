package com.sdcuike.practice.mapper;

import com.sdcuike.practice.domain.CourseEnrollmentKey;

public interface CourseEnrollmentMapper {
    int deleteByPrimaryKey(CourseEnrollmentKey key);

    int insert(CourseEnrollmentKey record);

    int insertSelective(CourseEnrollmentKey record);
}
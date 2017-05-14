package com.sdcuike.practice.mapper;

import com.sdcuike.practice.domain.Course;

public interface CourseMapper {
    int deleteByPrimaryKey(Long courseId);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Long courseId);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}
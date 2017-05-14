package com.sdcuike.practice.mapper;

import com.sdcuike.practice.domain.Tutor;
import com.sdcuike.practice.domain.TutorWithBLOBs;

public interface TutorMapper {
    int deleteByPrimaryKey(Long tutorId);

    int insert(TutorWithBLOBs record);

    int insertSelective(TutorWithBLOBs record);

    TutorWithBLOBs selectByPrimaryKey(Long tutorId);

    int updateByPrimaryKeySelective(TutorWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TutorWithBLOBs record);

    int updateByPrimaryKey(Tutor record);
}
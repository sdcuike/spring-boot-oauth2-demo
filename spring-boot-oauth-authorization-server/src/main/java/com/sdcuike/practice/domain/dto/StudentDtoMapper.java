package com.sdcuike.practice.domain.dto;

import com.sdcuike.practice.domain.StudentWithBLOBs;
import org.mapstruct.Mapper;

/**
 * Created by beaver on 2017/5/2.s
 */
@Mapper(uses = {AddressDtoMapper.class})
public interface StudentDtoMapper {
    
    StudentDto student2Dto(StudentWithBLOBs studentWithBLOBs);
}

package com.sdcuike.practice.controller;

import com.doctor.beaver.domain.result.ModelResult;
import com.sdcuike.practice.domain.StudentWithBLOBs;
import com.sdcuike.practice.domain.dto.StudentDto;
import com.sdcuike.practice.domain.dto.StudentDtoMapper;
import com.sdcuike.practice.mapper.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by beaver on 2017/5/2.
 */
@RestController
@RequestMapping(path = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class StudentController {
    
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentDtoMapper studentDtoMapper;
    
    @GetMapping("/{id}")
    public ModelResult<StudentDto> queryById(@PathVariable("id") Long id) {
        ModelResult<StudentDto> result = new ModelResult<>();
        
        StudentWithBLOBs studentWithBLOBs = studentMapper.selectByPrimaryKey(id);
        result.setData(studentDtoMapper.student2Dto(studentWithBLOBs));
        
        return result;
    }
}

package com.sdcuike.practice.controller;

import com.doctor.beaver.domain.result.ModelResult;
import com.sdcuike.practice.feign.ExampleServiceFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/example", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class ExampleController {
    @Autowired
    private ExampleServiceFeignClient exampleServiceFeignClient;
    
    @GetMapping("/")
    public ModelResult<String> home() {
        ModelResult<String> modelResult = new ModelResult<>();
        modelResult.setData("hello world spring boot");
        return modelResult;
    }
    
    @GetMapping("/testRemote")
    public ModelResult<String> testRemote() {
        return exampleServiceFeignClient.home();
    }
}

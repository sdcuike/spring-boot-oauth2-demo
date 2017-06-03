package com.sdcuike.practice.controller;

import com.doctor.beaver.domain.result.ModelResult;
import com.sdcuike.practice.feign.ExampleServiceFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping(path = "/example", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExampleController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    
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
    
    @PostConstruct
    public void init(){
        ModelResult<String> home = exampleServiceFeignClient.home();
        log.info("/////////////////////////////");
        log.info("{}",home);
    
    }
}

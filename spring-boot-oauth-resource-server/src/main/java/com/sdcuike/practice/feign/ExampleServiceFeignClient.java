package com.sdcuike.practice.feign;

import com.doctor.beaver.domain.result.ModelResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by beaver on 2017/5/27.<br>
 *
 *  {@linkplain https://jmnarloch.wordpress.com/2015/10/14/spring-cloud-feign-oauth2-authentication  }
 */
@FeignClient(name = "exampleService")
@RequestMapping(value = "/springBoot/example"
        , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
        , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public interface ExampleServiceFeignClient {
    @GetMapping("/")
    ModelResult<String> home();
}

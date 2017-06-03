package com.sdcuike.practice.feign;

import com.doctor.beaver.domain.result.ModelResult;
import com.sdcuike.practice.config.feign.OAuth2FeignAutoConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by beaver on 2017/5/27.<br>
 * <p>
 * {@link https://jmnarloch.wordpress.com/2015/10/14/spring-cloud-feign-oauth2-authentication  }
 */
@FeignClient(name = "exampleService",
        url = "${exampleService.ribbon.listOfServers}",
        configuration = {OAuth2FeignAutoConfiguration.class})
@RequestMapping(value = "/springBoot/example"
        , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
        , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public interface ExampleServiceFeignClient {
    @GetMapping("/")
    ModelResult<String> home();
}

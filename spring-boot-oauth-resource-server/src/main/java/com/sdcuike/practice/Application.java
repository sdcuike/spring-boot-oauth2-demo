package com.sdcuike.practice;

import com.sdcuike.springboot.SpringBootApplicationUtil;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import java.net.UnknownHostException;

/**
 * @author sdcuike
 *         <p>
 *         Created on 2016.12
 *         <p>
 *         We generally recommend that you locate your main application class in a root package above other classes. <br>
 *         <p>
 *         We recommend that you follow Java’s recommended package naming conventions and use a reversed domain name (for example, com.example.project)
 */
@SpringBootApplication(
        exclude = {DataSourceAutoConfiguration.class,
                MybatisAutoConfiguration.class,
                JpaRepositoriesAutoConfiguration.class,
                HibernateJpaAutoConfiguration.class},
        scanBasePackages = {"com.sdcuike.practice",
                "com.sdcuike.spring.controller.advice"})
@EnableFeignClients
@Slf4j
public class Application {
    public static void main(String[] args) throws UnknownHostException {
        SpringBootApplicationUtil.runSpringBootApplication(log, args, Application.class);
        
    }
    
}

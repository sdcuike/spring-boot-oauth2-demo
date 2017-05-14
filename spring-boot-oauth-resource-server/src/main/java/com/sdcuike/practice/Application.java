package com.sdcuike.practice;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;
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
@Slf4j
public class Application {
    public static void main(String[] args) throws UnknownHostException {
        SpringApplication springApplication = new SpringApplication(Application.class);
        ConfigurableEnvironment env = springApplication.run(args).getEnvironment();
        
        printInfo(env);
    }
    
    private static void printInfo(ConfigurableEnvironment env) throws UnknownHostException {
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        log.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\t{}://localhost:{}\n\t" +
                        "External: \t{}://{}:{}\n\t" +
                        "server contextPath:\t{} \n\t" +
                        "Profile(s): \t{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                protocol,
                env.getProperty("server.port"),
                protocol,
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"),
                env.getProperty("server.contextPath"),
                env.getActiveProfiles());
    }
    
}

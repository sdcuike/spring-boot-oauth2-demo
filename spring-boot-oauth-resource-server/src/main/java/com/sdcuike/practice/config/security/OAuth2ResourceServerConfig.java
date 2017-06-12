package com.sdcuike.practice.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

import javax.annotation.PostConstruct;

@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {
    /**
     * @see org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties
     */
    @Value("${security.oauth2.resource.clientId}")
    private String clientId;
    
    @Value("${security.oauth2.resource.clientSecret}")
    private String clientSecret;
    
    @Autowired
    RemoteTokenServices remoteTokenServices;
    
    @PostConstruct
    public void init() {
        remoteTokenServices.setClientId(clientId);
        remoteTokenServices.setClientSecret(clientSecret);
    }
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
        //以下路径认证
        http.antMatcher("/api/**")
            // Add below
            .authorizeRequests()
            .anyRequest().authenticated();
    }
    
    
}

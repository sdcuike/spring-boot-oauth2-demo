package com.sdcuike.practice.config.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;

/**
 * Created by beaver on 2017/6/3.
 */
@Configuration
@EnableConfigurationProperties(Oauth2ClientProperties.class)
public class Oauth2ClientConfig {
    
    @Autowired
    private Oauth2ClientProperties oauth2ClientProperties;
    
    @Bean("practiceClientCredentialsResourceDetails")
    ClientCredentialsResourceDetails resourceDetails() {
        ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
        details.setId(oauth2ClientProperties.getId());
        details.setAccessTokenUri(oauth2ClientProperties.getAccessTokenUrl());
        details.setClientId(oauth2ClientProperties.getClientId());
        details.setClientSecret(oauth2ClientProperties.getClientSecret());
        details.setAuthenticationScheme(AuthenticationScheme.valueOf(oauth2ClientProperties.getClientAuthenticationScheme()));
        return details;
    }
    
    @Bean("practiceOAuth2RestTemplate")
    public OAuth2RestTemplate oAuth2RestTemplate() {
        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails(), new DefaultOAuth2ClientContext());
        
        return restTemplate;
    }
}

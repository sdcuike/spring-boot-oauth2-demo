package com.sdcuike.practice.config.feign;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by beaver on 2017/6/3.
 */
@ConfigurationProperties(prefix = "practice.oauth2.client")
public class Oauth2ClientProperties {
    private String id;
    private String accessTokenUrl;
    private String clientId;
    private String clientSecret;
    private String clientAuthenticationScheme;
    
    public String getClientAuthenticationScheme() {
        return clientAuthenticationScheme;
    }
    
    public void setClientAuthenticationScheme(String clientAuthenticationScheme) {
        this.clientAuthenticationScheme = clientAuthenticationScheme;
    }
    
    public String getAccessTokenUrl() {
        return accessTokenUrl;
    }
    
    public void setAccessTokenUrl(String accessTokenUrl) {
        this.accessTokenUrl = accessTokenUrl;
    }
    
    public String getClientId() {
        return clientId;
    }
    
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    
    public String getClientSecret() {
        return clientSecret;
    }
    
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
    
    
    
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    
}

package com.sdcuike.practice.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

import java.util.Map;

/**
 * Created by beaver on 2017/6/12.
 * <p>
 * 获取用户信息-> oid
 *
 * @see https://stackoverflow.com/questions/35056169/how-to-get-custom-user-info-from-oauth2-authorization-server-user-endpoint/35092561
 */
@Configuration
public class UserInfoTokenServicesConfig {
    
    @Value("${security.oauth2.resource.clientId}")
    private String clientId;
    
    @Autowired
    private ResourceServerProperties sso;
    
    @Bean
    @Primary
    public ResourceServerTokenServices myUserInfoTokenServices() {
        UseOidPrincipalExtractor useOidPrincipalExtractor = new UseOidPrincipalExtractor();
        MyUserInfoTokenServices myUserInfoTokenServices = new MyUserInfoTokenServices(sso.getUserInfoUri(), clientId);
        myUserInfoTokenServices.setPrincipalExtractor(new UseOidPrincipalExtractor());
        return myUserInfoTokenServices;
    }
    
    public static class MyUserInfoTokenServices extends UserInfoTokenServices {
        public MyUserInfoTokenServices(String userInfoEndpointUrl, String clientId) {
            super(userInfoEndpointUrl, clientId);
        }
    }
    
    
    public static class UseOidPrincipalExtractor implements PrincipalExtractor {
        
        private static final String userOID = "id";
        
        @Override
        public Object extractPrincipal(Map<String, Object> map) {
            return map.get(userOID);
        }
    }
}

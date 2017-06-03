/**
 * Copyright (c) 2015 the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sdcuike.practice.config.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.util.Assert;

/**
 * Created by beaver on 2017/6/3.
 */
public class OAuth2FeignRequestInterceptor implements RequestInterceptor {
    
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    
    private static final String AUTHORIZATION_HEADER = "Authorization";
    
    private static final String BEARER_TOKEN_TYPE = "Bearer";
    
    private final OAuth2RestTemplate oAuth2RestTemplate;
    
    
    public OAuth2FeignRequestInterceptor(OAuth2RestTemplate oAuth2RestTemplate) {
        Assert.notNull(oAuth2RestTemplate, "Context can not be null");
        this.oAuth2RestTemplate = oAuth2RestTemplate;
    }
    
    @Override
    public void apply(RequestTemplate template) {
        LOGGER.debug("Constructing Header {} for Token {}", AUTHORIZATION_HEADER, BEARER_TOKEN_TYPE);
        template.header(AUTHORIZATION_HEADER,
                String.format("%s %s",
                        BEARER_TOKEN_TYPE,
                        oAuth2RestTemplate.getAccessToken().toString()));
        
    }
}

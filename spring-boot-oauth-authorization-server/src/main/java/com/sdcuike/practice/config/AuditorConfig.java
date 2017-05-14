package com.sdcuike.practice.config;

import com.sdcuike.mybatis.auditor.AuditorServiceUtis;
import com.sdcuike.practice.mapper.StudentMapper;
import com.sdcuike.spring.extend.web.SpringHandlerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Created by beaver on 2017/4/25.
 *
 * 注入自己的服务，利用AuditorServiceUtis.setUserId 设值。
 */
@SpringHandlerInterceptor
@Slf4j
public class AuditorConfig extends HandlerInterceptorAdapter {
    @Autowired
    private StudentMapper studentMapper;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        AuditorServiceUtis.setUserId(UUID.randomUUID().toString());
        log.debug("AuditorServiceUtis.getUserId:{}", AuditorServiceUtis.getUserId());
        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.debug("AuditorServiceUtis.getUserId:{}", AuditorServiceUtis.getUserId());
        AuditorServiceUtis.remove();
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.debug("AuditorServiceUtis.getUserId:{}", AuditorServiceUtis.getUserId());
    }
}

package com.lsp.config;

import com.lsp.interceptor.JwtValidatorInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: Lee.
 * @Description: TODO
 * @DateTime: 2023/6/12 16:04
 **/

@Configuration
public class MyInterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private JwtValidatorInterceptor jwtValidatorInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(jwtValidatorInterceptor);
        registration.addPathPatterns("/**").excludePathPatterns(
                "/user/login",
                "/user/info",
                "/user/logout",
                "/error",
                "/swagger-ui/**",
                "/swagger-resources/**",
                "/v3/**"
        );
    }
}

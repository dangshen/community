package com.example.community.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class InterceptorConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        //注册拦截器
        InterceptorRegistration ir = registry.addInterceptor(new LoginInterceptor());
        //配置不拦截路径
        ir.excludePathPatterns("/user/loginPage");
        ir.excludePathPatterns("/user/login");
        //配置拦截路径
        ir.addPathPatterns("/**");
    }
}

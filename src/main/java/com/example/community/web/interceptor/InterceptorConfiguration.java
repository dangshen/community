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
        InterceptorRegistration loginInterceptor = registry.addInterceptor(new LoginInterceptor());
        InterceptorRegistration tokenInterceptor = registry.addInterceptor(new TokenInterceptor());
        //配置不拦截路径
        loginInterceptor.excludePathPatterns("/user/loginPage");
        loginInterceptor.excludePathPatterns("/user/login");
        //配置拦截路径
        loginInterceptor.addPathPatterns("/**");
        tokenInterceptor.addPathPatterns("/**");
    }
}

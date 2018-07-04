package com.example.community.web.interceptor;

import com.example.community.web.annotation.Token;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.UUID;

public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            Token annotation = method.getAnnotation(Token.class);
            //注解，进行拦截判断
            if (annotation != null) {
                System.out.println("annotation: " + annotation);
                boolean needSaveSession = annotation.save();
                if (needSaveSession) {
                    System.out.println("addToken------------------");
                    System.out.println("add前的token: " + request.getSession(false).getAttribute("token"));
                    request.getSession(false).setAttribute("token", UUID.randomUUID().toString());
                    System.out.println("add后的token: " + request.getSession(false).getAttribute("token"));
                }
                boolean needRemoveSession = annotation.remove();
                if (needRemoveSession) {
                    //重复提交直接拦截
                    if (isRepeatSubmit(request)) {
                        System.out.println("拦截重复提交------------------");
                        return false;
                    }
                    //非重复提交，删除token
                    request.getSession(false).removeAttribute("token");
                    System.out.println("removeToken------------------");
                }
            }
            //放行
            return true;
        } else {
            return super.preHandle(request, response, handler);
        }
    }

    private boolean isRepeatSubmit (HttpServletRequest request) {
        String serverToken = (String) request.getSession(false).getAttribute("token");
        System.out.println("拦截前的token: " + request.getSession(false).getAttribute("token"));
        if (serverToken == null) {
            //sessionToken为空，重复提交
            System.out.println("serverToken为空");
            return true;
        }
        return false;
    }
}

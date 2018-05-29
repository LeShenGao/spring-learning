package com.leolau.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 检测运行时间拦截器
 *
 * @author LeoGao
 */
public class RunTimeDateInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        Long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Long startTime = (Long) request.getAttribute("startTime");
        Long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) / 1000 + "s");
        request.setAttribute("runTimeDate", endTime - startTime);
        super.postHandle(request, response, handler, modelAndView);
    }
}

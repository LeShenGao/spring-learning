package com.leolau.config;

import com.leolau.interceptor.RunTimeDateInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * springmvc 配置类
 *
 * @author LeoGao
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.leolau")
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }

    @Bean
    public RunTimeDateInterceptor runTimeDateInterceptor() {
        return new RunTimeDateInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(runTimeDateInterceptor());
    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/user/index").setViewName("/index");
    }
}

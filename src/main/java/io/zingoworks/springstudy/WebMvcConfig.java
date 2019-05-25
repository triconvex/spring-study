package io.zingoworks.springstudy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/").addResourceLocations("/static/index.html");
    }

    @Bean
    public HandlerInterceptor testInterceptor() {
        HandlerInterceptor testInterceptor = new TestInterceptor();
        return testInterceptor;
    }

    @Bean
    public HandlerInterceptorAdapter testInterceptor2() {
        HandlerInterceptorAdapter testInterceptor2 = new TestInterceptor2();
        return testInterceptor2;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(testInterceptor2());
        registry.addInterceptor(testInterceptor());
    }

}

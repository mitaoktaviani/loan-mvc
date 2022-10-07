package com.mita.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/home/index");
        registry.addViewController("/home").setViewName("forward:/home/index");
        registry.addViewController("/product").setViewName("forward:/product/index");
        registry.addViewController("/creditor").setViewName("forward:/creditor/index");
    }
}

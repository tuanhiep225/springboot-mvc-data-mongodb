package com.springmvc.springmongodbweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/webjars/**")
          .addResourceLocations("/webjars/");
        registry
        .addResourceHandler("/css/**")
        .addResourceLocations("classpath:/static/css/");
        registry
        .addResourceHandler("/formnhanqua/**")
        .addResourceLocations("classpath:/templates/formnhanqua/");
        registry
        .addResourceHandler("/webview/**")
        .addResourceLocations("classpath:/static/webview/");

    }
    
    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
}

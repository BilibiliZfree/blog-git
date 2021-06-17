package com.may.view;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 紫枫伊
 * @creatDate 2021/6/16 17:03
 * @updateDate 2021/6/16 17:14
 * @description 视图控制器
 */
@Configuration
public class WebViewConfigurer implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        WebMvcConfigurer.super.addViewControllers(registry);

        /*登录页*/
        registry.addViewController("/index.html").setViewName("admin/index");
        /*注册页*/
        registry.addViewController("/register.html").setViewName("admin/register");
    }
}

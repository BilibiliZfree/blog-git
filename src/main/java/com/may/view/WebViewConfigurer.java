package com.may.view;

import com.may.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author : 紫枫伊
 * @since  : creatTime 2021/6/16 17:03
 * @code : updateDate 2021/7/1 17:55
 * @code : description 视图控制器
 */
@Configuration
public class WebViewConfigurer implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 这里前提得有404和500这一个html存在，不然他会返回他默认的404页面
        registry.addViewController("/404").setStatusCode(HttpStatus.NOT_FOUND).setViewName("message/404");
        registry.addViewController("/500").setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR).setViewName("message/500");
        /*登录页*/
        registry.addViewController("/").setViewName("blog/index");
        registry.addViewController("/index.html").setViewName("blog/index");
        /*注册页*/
        registry.addViewController("/register.html").setViewName("blog/register");
        registry.addViewController("/blog").setViewName("/blog/blog");
        registry.addViewController("/archives").setViewName("/blog/archives");
    }

    /**
     * @author : 紫枫伊
     * @since : 2021/6/28 12:07
     * @code : updateTime 2021/6/28 12:07
     * @code : description 拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).
                addPathPatterns("/**").
                excludePathPatterns("/index.html","/","/user/login","/register.html","/user/register").
                excludePathPatterns("/assets/brand/**", "/assets/images/**","/css/**","/iconfont/**","/js/**");
    }
}

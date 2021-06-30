package com.may.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : 紫枫伊
 * @since : 2021/6/28 11:12
 * @code : updateTime 2021/6/28 11:12
 * @code : description 登陆拦截器，未请登陆验证无法访问主页面
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登陆成功后应有用户的session
        Object user = request.getSession().getAttribute("user");
        if (user == null){
            request.setAttribute("message","没有权限,请登陆.");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }
        return true;
    }
}

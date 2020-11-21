package org.zzz.web.shop.web.admin.web.interceptor;

import org.zzz.web.shop.commons.constant.*;
import org.zzz.web.shop.domain.TbUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 * <p>Title: LoginInterceptor</p>
 * <p>Description: </p>
 *
 * @author
 * @version
 * @date
 */

// Spring MVC 拦截器需要实现 HandlerInterceptor 接口，这个接口有三个方法，重写这三个方法对用户的请求进行拦截
public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        TbUser user = (TbUser) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);

        // 判断用户是否登录
        if (user == null) {
            // 用户未登录，重定向到登录页
            httpServletResponse.sendRedirect("/login");

        }

        // 放行
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        // 如果请求来自登录页
/* 这里注释？？？？？？？？？？？？？？？？？？？？
        if (modelAndView.getViewName().endsWith("login")) {
            // 则直接重定向到首页不再显示登录页
            httpServletResponse.sendRedirect("/main");
        }
*/
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
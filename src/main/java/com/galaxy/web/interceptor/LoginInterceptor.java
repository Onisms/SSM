package com.galaxy.web.interceptor;

import com.galaxy.entity.Account;
import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //从session里面拿到  登录成功的值
        Account loginAccount = (Account) request.getSession().getAttribute("LoginAccount");
        if (loginAccount == null) {
            request.setAttribute("errorMsg", "请重新登录！");
            request.getRequestDispatcher("/WEB-INF/pages/account/login.jsp").forward(request,response);
            return false;
        }else {
            return true;
        }
    }
}

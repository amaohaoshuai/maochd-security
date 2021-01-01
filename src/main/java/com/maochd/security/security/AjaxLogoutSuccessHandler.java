package com.maochd.security.security;

import com.alibaba.fastjson.JSON;
import com.maochd.security.entity.ResultInfo;
import com.maochd.security.enums.ResultEnum;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 退出登录处理器
 *
 * @author maochd
 */
@Component
public class AjaxLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.getWriter().write(JSON.toJSONString(ResultInfo.result(ResultEnum.USER_LOGOUT_SUCCESS, true)));
    }

}

package com.maochd.security.security;

import com.alibaba.fastjson.JSON;
import com.maochd.security.entity.ResultInfo;
import com.maochd.security.entity.UserInfo;
import com.maochd.security.enums.ResultEnum;
import com.maochd.security.utils.JwtUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录成功处理器
 *
 * @author maochd
 */
@Component
public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        UserInfo userDetails = (UserInfo) authentication.getPrincipal();

        String jwtToken = JwtUtils.generateToken(userDetails.getUsername(), userDetails.getUserId());

        httpServletResponse.getWriter().write(JSON.toJSONString(ResultInfo.result(ResultEnum.USER_LOGIN_SUCCESS, jwtToken, true)));
    }
}

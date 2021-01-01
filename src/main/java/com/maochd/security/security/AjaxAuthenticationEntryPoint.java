package com.maochd.security.security;

import com.alibaba.fastjson.JSON;
import com.maochd.security.entity.ResultInfo;
import com.maochd.security.enums.ResultEnum;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 未登陆处理器
 *
 * @author maochd
 */
@Component
public class AjaxAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.getWriter().write(JSON.toJSONString(ResultInfo.result(ResultEnum.USER_NEED_AUTHORITIES,false)));
    }
}

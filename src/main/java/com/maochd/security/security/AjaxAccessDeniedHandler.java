package com.maochd.security.security;

import com.alibaba.fastjson.JSON;
import com.maochd.security.entity.ResultInfo;
import com.maochd.security.enums.ResultEnum;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 无权访问返处理器
 *
 * @author maochd
 */
@Component
public class AjaxAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.getWriter().write(JSON.toJSONString(ResultInfo.result(ResultEnum.USER_NO_ACCESS, false)));
    }
}

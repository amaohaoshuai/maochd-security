package com.maochd.security.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;


/**
 * @author maochd
 */
public interface RbacAuthorityService {

    /**
     * 授权
     *
     * @param request
     * @param authentication
     * @return
     */
    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}

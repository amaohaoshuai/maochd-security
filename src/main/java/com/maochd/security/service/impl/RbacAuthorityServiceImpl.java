package com.maochd.security.service.impl;

import com.maochd.security.dao.RbacAuthorityDao;
import com.maochd.security.entity.UserInfo;
import com.maochd.security.service.RbacAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component("rbacauthorityservice")
public class RbacAuthorityServiceImpl implements RbacAuthorityService {

    @Autowired
    private RbacAuthorityDao rbacAuthorityDao;

    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object userInfo = authentication.getPrincipal();
        boolean hasPermission = false;
        if (userInfo instanceof UserInfo) {
            String username = ((UserDetails) userInfo).getUsername();
            List<String> urls = rbacAuthorityDao.getUrlsByUsername(username);
            hasPermission = urls.stream().anyMatch(url -> request.getRequestURI().contains(url));
        }
        return hasPermission;
    }
}

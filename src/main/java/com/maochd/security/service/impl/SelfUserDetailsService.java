package com.maochd.security.service.impl;

import com.maochd.security.dao.SystemManagementDao;
import com.maochd.security.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SelfUserDetailsService implements UserDetailsService {

    @Autowired
    private SystemManagementDao systemManagementDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo user = systemManagementDao.getUser(username);
        if (user == null) {
            throw new UsernameNotFoundException("该用户不存在");
        }
        List<String> roles = systemManagementDao.getRoles(user);

        Set<GrantedAuthority> authoritiesSet = new HashSet<>();
        roles.forEach(role -> authoritiesSet.add(new SimpleGrantedAuthority(role)));

        user.setAuthorities(authoritiesSet);

        return user;
    }
}

package com.maochd.security.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 用户信息实体（实现security的用户实体）
 *
 * @author maochd
 */
@Data
public class UserInfo implements UserDetails, Serializable {
    private String userId;
    private String username;
    private String password;
    private Set<? extends GrantedAuthority> authorities;
    private Date createDate;
    private Date lastUpdateDate;

    /**
     * 账户是否过期
     *
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账户是否锁定
     *
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 凭证是否过期
     *
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 用户是否被禁用
     *
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}

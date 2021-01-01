package com.maochd.security.config;

import com.maochd.security.filter.JwtAuthenticationTokenFilter;
import com.maochd.security.security.*;
import com.maochd.security.service.impl.SelfUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


/**
 * security 配置类
 *
 * @author maochd
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AjaxAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private AjaxAuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private AjaxAuthenticationFailureHandler authenticationFailureHandler; //登录失败返回的 JSON 格式数据给前端（否则为 html）

    @Autowired
    private AjaxLogoutSuccessHandler logoutSuccessHandler;//注销成功返回的 JSON 格式数据给前端（否则为 登录时的 html）

    @Autowired
    private AjaxAccessDeniedHandler accessDeniedHandler;

    @Autowired
    private SelfUserDetailsService userDetailsService; // 自定义user

    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter; // JWT 拦截器

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 加入自定义的安全认证
        // auth.authenticationProvider(provider);

        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // 去掉 CSRF
            .csrf().disable()
            // 使用 JWT，关闭token
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .httpBasic().authenticationEntryPoint(authenticationEntryPoint)
            .and()
            // 过滤所有Options请求
            .authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
            // 任何请求,登录后可以访问
            .anyRequest()
            // RBAC 动态 url 认证
            .access("@rbacauthorityservice.hasPermission(request, authentication)")
            .and()
            // 开启登录
            .formLogin()
            // 登录成功处理器
            .successHandler(authenticationSuccessHandler)
            // 登录失败处理器
            .failureHandler(authenticationFailureHandler)
            .permitAll()
            // 默认注销行为为logout
            .and().logout().logoutUrl("/logout")
            // 退出登录处理器
            .logoutSuccessHandler(logoutSuccessHandler)
            .permitAll();

        // 记住我
        http.rememberMe().rememberMeParameter("remember-me")
                .userDetailsService(userDetailsService).tokenValiditySeconds(1000);
        // 无权访问处理器
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
        // JWT过滤器
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

    }
}

package com.wb.wbao.config;

import com.h3c.common.config.DefaultAuthenticationTokenFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by dell on 2018/3/4.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 由于使用的是JWT，我们这里不需要csrf
                .csrf().disable()
                // 基于token，所以不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                // 允许对于网站静态资源的无授权访问
                .anyRequest().permitAll();

        http.addFilterBefore(new DefaultAuthenticationTokenFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);

        // 禁用缓存
        http.headers().cacheControl();
    }

}

package com.example.springsecurity.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Sam
 * @create 2021-08-28 17:33
 */
@EnableWebSecurity
public class MySecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll()
        .antMatchers("/level1/**").hasRole("vip1")
        .antMatchers("/level2/**").hasRole("vip2")
        .antMatchers("/level3/**").hasRole("vip3");
        http.formLogin().usernameParameter("username").passwordParameter("password").loginPage("/toLogin").loginProcessingUrl("/login");
        http.csrf().disable();
        http.logout().logoutSuccessUrl("/");
        http.rememberMe().rememberMeParameter("remember");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("root").password(new BCryptPasswordEncoder().encode("123")).roles("vip1","vip2","vip3")
                .and()
                .withUser("admin").password(new BCryptPasswordEncoder().encode("123")).roles("vip1","vip2")
                .and()
                .withUser("user").password(new BCryptPasswordEncoder().encode("123")).roles("vip1");
    }
}

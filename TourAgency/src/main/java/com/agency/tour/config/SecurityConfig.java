package com.agency.tour.config;

import java.security.Security;

import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import com.agency.tour.service.LoginService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
   

    private final AuthSuccessHandler authSuccessHandler;
    private final LoginService userDetailsService;
    private final AuthFailureHandler authFailureHandler;

    @Bean
    public BCryptPasswordEncoder encoderPwd() {
        return new BCryptPasswordEncoder();
    }
    
    // CustomAuthenticationProvider 빈 등록
    @Bean
    public CustomAuthenticationProvider customAuthenticationProvider() {
        return new CustomAuthenticationProvider(userDetailsService, encoderPwd());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	 http
         .csrf().disable()
         .authorizeRequests()
         .antMatchers("/login","/js/*", "/css/*", "/img/*","/join").permitAll()
         .anyRequest().hasRole("USER")
         .and()
         .formLogin()
         .loginPage("/login")
         .successHandler(authSuccessHandler)
         .failureHandler(authFailureHandler)
         .usernameParameter("loginId")
         .passwordParameter("loginPassword")
         .and()
         .logout()
         .invalidateHttpSession(true)
         .deleteCookies("JSESSIONID")
         .permitAll();
         
 		http.sessionManagement()
 		.maximumSessions(1)
 		.maxSessionsPreventsLogin(false)
 		.expiredUrl("/login").sessionRegistry(sessionRegistry());
}

/**
* 인증/인가 확인 프로세서 주입
* @param auth the {@link AuthenticationManagerBuilder} to use
* @throws Exception
* @see CustomAuthenticationProvider
*/
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 auth.authenticationProvider(customAuthenticationProvider());
}

@Bean	//전한솔 (중복로그인 방지)
public SessionRegistry sessionRegistry() {
 return new SessionRegistryImpl();
}
@Bean	//전한솔 (중복로그인 방지)
public static ServletListenerRegistrationBean httpSessionEventPublisher() {
 return new ServletListenerRegistrationBean(new HttpSessionEventPublisher());
}
}
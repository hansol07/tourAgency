package com.agency.tour.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AuthFailureHandler implements AuthenticationFailureHandler {


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        // 한글 사용
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String errorMsg = "아이디나 패스워드가 올바르지않습니다.";

        response.getWriter().print(errorMsg);
        response.getWriter().flush();

    }
}

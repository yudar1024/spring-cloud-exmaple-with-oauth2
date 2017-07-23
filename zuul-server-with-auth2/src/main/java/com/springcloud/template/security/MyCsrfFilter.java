package com.springcloud.template.security;

import com.springcloud.template.common.security.lib.MutableHttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Slf4j
public class MyCsrfFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        log.info(" request names: {}",request.getHeaderNames());
        MutableHttpServletRequest mutableHttpServletRequest = new MutableHttpServletRequest(request);
        if(request.getHeader("X-XSRF-TOKEN")==null&&request.getHeader("Authorization")!=null){
            CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class
                    .getName());
            String token= request.getHeader("Authorization").trim().split(" ")[1];
            mutableHttpServletRequest.putHeader("X-XSRF-TOKEN",csrf.getToken());
        }
        filterChain.doFilter(mutableHttpServletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}

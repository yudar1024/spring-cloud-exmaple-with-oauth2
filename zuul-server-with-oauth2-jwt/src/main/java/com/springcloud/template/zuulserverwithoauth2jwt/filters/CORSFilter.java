package com.springcloud.template.zuulserverwithoauth2jwt.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by chenxj on 12/10/16.
 */
//@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class CORSFilter implements Filter {
    private AntPathRequestMatcher tempMatcher =  new AntPathRequestMatcher("/uaa/**");
    public CORSFilter() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        log.info("Get OPTIONS method of request: {}", request.getRequestURL());
        log.info("The Cookies are: ");
        if(request.getCookies() != null){
            for(Cookie tempItem : request.getCookies()){
                log.info("Item: {} -> {}", tempItem.getName(), tempItem.getValue());
            }
        }
        if(!tempMatcher.matches(request)) {
            response.setHeader("Vary", "Origin");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Authorization, Content-Type, responseType");
        }
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())&&!tempMatcher.matches(request)) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }
}

package com.springcloud.template.common.security.jwt;

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
// cors 设置方案。对于微服务体系，在网关zuul 这里设置cors就可以了，如果在其他微服务也设置了cors 那么在最终的返回response中，就有有两条甚至3条同名的header Access-Control-Allow-Origin
//    造成The 'Access-Control-Allow-Origin' header contains multiple values 错误。原因是每个微服务都在response 当中添加了Access-Control-Allow-Origin
//    如果在非网关微服务也想启用cors，需要在URL 上进行设计，一般的方法是/authsec/v1/<微服务代码>/**
//    注意网关服务和微服务之间URL 的变化，假设服务A 在网关被定义为 /AA,在微服务A上有一个API url 为/authsec/v1/codea/
//    从客户端访问的url 就是/AA/authsec/v1/codea/xxx ,微服务A 实际收到的URL 为/authsec/v1/codea/xxx
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

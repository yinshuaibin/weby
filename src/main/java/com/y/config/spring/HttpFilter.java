package com.y.config.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Slf4j
public class HttpFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init filter");
    }

    @Override
    public void destroy() {
        log.info("destroy filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        log.info("do filter thredId {}, servletPath {}", Thread.currentThread().getId(), request.getServletPath());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}

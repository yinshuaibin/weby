package com.y.config.spring;

import com.y.test.thread.example.threadLocal.RequestHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * 如果需要过滤所有请求, 直接Component 或者 Configuration 即可
 * 如果需要过滤指定请求, 使用WebFilter 并且在启动类添加 ServletComponentScan
 * 如果Component和WebFilter同时存在则 WebFilter 无效
 */
@WebFilter(urlPatterns = {"/regional/*"})
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
        log.info("do filter thredId: {}, servletPath: {}", Thread.currentThread().getId(), request.getServletPath());
        RequestHolder.add(Thread.currentThread().getId());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}

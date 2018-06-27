package com.nklongyi;

import com.nklongyi.example.threadLocals.RequestHolder;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 实现servlet Filter
 * Created by longyi on 2018-06-26.
 */
@Slf4j
public class HttpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //先将servletRequest转换为httpservletRequest
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        log.info("do filter {}, {}",Thread.currentThread().getId(),request.getServletPath());//将线程 和 当前请求的路径配置打印
        RequestHolder.add(Thread.currentThread().getId());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}

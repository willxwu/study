package com.example.study.concurrency.concurrency.DemoThrodLocal.filter;

import com.example.study.concurrency.concurrency.DemoThrodLocal.ThreadLock.MyThroldLock;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 自定一自己的filter，实现filter接口，注意是servlet中的
 * 说明：
 * Servlet中的过滤器Filter是实现了javax.servlet.Filter接口的服务器端程序，
 * 主要的用途是设置字符集、控制权限、控制转向、做一些业务逻辑判断等。其工作原理是，
 * 只要你在web.xml文件配置好要拦截的客户端请求，它都会帮你拦截到请求，
 * 此时你就可以对请求或响应(Request、Response)统一设置编码，简化操作；
 * 同时还可进行逻辑判断，如用户是否已经登陆、有没有权限访问该页面等等工作。
 * 它是随你的web应用启动而启动的，只初始化一次，以后就可以拦截相关请求，只有当你的web应用停止或重新部署的时候才销毁。
 * @author: <a href="mailto:batis@foxmail.com">清风</a>
 * @date: 2022/4/22 23:02
 * @version: 1.0
 */
@Slf4j
public class HttpFilter implements Filter {
    //初始化的
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //一般需要强转成HttpServletRequest、HttpServletResponse，这样才能直接获取用户浏览器访问时携带信息
        //比如获取用户session中的用户信息
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //一般登录会将用户信息写入session,这里只是演示一下
//        String userName = (String) request.getSession().getAttribute("userName");

        log.info("do filter，线程id {},请求地址{}", Thread.currentThread().getId(), request.getServletPath());

        //通过向ThreadLock添加共享值
        MyThroldLock.add(Thread.currentThread().getId());

//        所有处理完后，记得执行下面，不然不会往下执行
        filterChain.doFilter(servletRequest, servletResponse);

    }

    //销毁时的
    public void destroy() {

    }
}

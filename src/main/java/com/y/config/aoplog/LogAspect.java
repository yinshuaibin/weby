package com.y.config.aoplog;


import com.y.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Aspect
@Slf4j
@Component
public class LogAspect {

    private static final String START_TIME = "request-start";


    /**
     * 使用切点表达式, 也可使用注解方式(也可使用注解方式, 此处处理所有controller, 使用切点表达式)
     */
    @Pointcut("execution(public * com.y.controller.*Controller*.*(..))")
    public void ferretLog(){}


    /**
     * 环绕增强，相当于MethodInterceptor, 此处没有做处理
     */
    @Around("ferretLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();
        return result;
    }

    /**
     * 前置通知, 这里在进入的时候设置了进入时间, 方便计算用时
     * @param point
     */
    @Before("ferretLog()")
    public void doBeforeFerretLog(JoinPoint point){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        Long start = System.currentTimeMillis();
        log.info("请求 {} 日志记录开始, mark : {}", point.getSignature().getName(), start);
        request.setAttribute(START_TIME, start);

    }

    /**
     * 后置异常通知
     */
    @AfterThrowing(throwing = "e",value = "ferretLog()")
    public void throwss(JoinPoint jp, Exception e){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        Long start = (Long) request.getAttribute(START_TIME);
        log.error("后置异常通知捕获了异常 : {}, mark : {}", e, start);
        log.info("【异常请求 URL】: {}, mark : {}", request.getRequestURL());
        log.info("【异常请求 IP】: {}, mark : {}", request.getRemoteAddr());
        log.info("【异常请求方式】: {}, mark : {}", request.getMethod());
        log.info("【异常请求类名】: {}, mark : {}，【请求方法名】：{}", jp.getSignature().getDeclaringTypeName(), jp.getSignature().getName());
        log.info("【异常请求参数】: {}, mark : {}",jp.getArgs());
    }


    /**
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     */
    @After("ferretLog()")
    public void after(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        Long start = (Long) request.getAttribute(START_TIME);
        User user =(User) request.getSession().getAttribute("user");
        if(user != null){
            log.info("【请求 userId】: {}, mark : {}", user.getUserId(), start);
        }else {
            log.info("该请求为未登录请求!, mark : {}", start);
        }
        log.info("【请求 URL】: {}, mark : {}", request.getRequestURL(), start);
        log.info("【请求 IP】: {}, mark : {}", request.getRemoteAddr(), start);
        log.info("【请求方式】: {}, mark : {}", request.getMethod(), start);
        log.info("【请求类名】: {}, 【请求方法名】: {}, mark : {}", joinPoint.getSignature().getDeclaringTypeName(), start, joinPoint.getSignature().getName());
        log.info("【请求参数】: {}, mark : {}",joinPoint.getArgs(), start);

        Long end = System.currentTimeMillis();
        log.info("【请求耗时】: {}毫秒, mark : {}", end - start, start);
//        String header = request.getHeader("User-Agent");
//        UserAgent userAgent = UserAgent.parseUserAgentString(header);
//        log.info("【浏览器类型】 : {}，【操作系统】 : {}，【原始User-Agent】 : {}", userAgent.getBrowser().toString(), userAgent.getOperatingSystem().toString(), header);
        log.info("请求 {} 日志记录结束, mark : {}", joinPoint.getSignature().getName(), start);
    }

// 使用解析器需要引入以下maven坐标
//    <!-- https://mvnrepository.com/artifact/eu.bitwalker/UserAgentUtils -->
//<dependency>
//    <groupId>eu.bitwalker</groupId>
//    <artifactId>UserAgentUtils</artifactId>
//    <version>1.21</version>
//</dependency>

}

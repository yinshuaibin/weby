package com.y.exception;

import com.y.exception.Yexception;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cheng on 2017/6/21.
 * Description: 管理所有异常,并将友好的异常信息返回到前端.
 */

@ControllerAdvice
@ResponseBody
@Slf4j
public class ExceptionHandlerAdvice {
    private final static String ERROR = "error";

    /**
     * 400 - Bad Request
     * @param e 参数无法解析异常
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity handleHttpMessageNotReadableException(HttpServletRequest request, HttpMessageNotReadableException e) {
        log.error("HttpMessageNotReadableException Handler--- Host: {} invokes url: {} ERROR: {}", request.getRemoteHost(), request
                .getRequestURL(), e.getMessage());
        return response("参数解析失败", e, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity handleIllegalArgumentException(HttpServletRequest request, IllegalArgumentException e) {
        log.error("DefaultException Handler --- Host: {} invokes url: {} ERROR: {}"
                , request.getRemoteHost(), request.getRequestURL(), e.getMessage());
        return response(e.getMessage(), e, HttpStatus.BAD_REQUEST);
    }

    /**
     * 405 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity handleHttpRequestMethodNotSupportedException(HttpServletRequest request, HttpRequestMethodNotSupportedException e) {
        log.error("HttpRequestMethodNotSupportedException Handler --- Host: {} invokes url: {} ERROR: {}"
                , request.getRemoteHost(), request.getRequestURL(), e.getMessage());
        return response("不支持当前请求方法", e, HttpStatus.METHOD_NOT_ALLOWED);
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity handleHttpMediaTypeNotSupportedException(HttpServletRequest request, HttpMediaTypeNotSupportedException e) {
        log.error("HttpMediaTypeNotSupportedException Handler --- Host: {}, invokes url: {}, ERROR: {}"
                , request.getRemoteHost(), request.getRequestURL(), e.getMessage());
        return response("不支持当前媒体格式", e, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException Handler --- Host: {} invokes url: {} ERROR: {}"
                , request.getRemoteHost(), request.getRequestURL(), e.getMessage());
        return response("参数不合法", e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Yexception.class)
    public ResponseEntity handleBusinessException(HttpServletRequest request, Yexception e) {
        log.error("BusinessException Handler --- Host: {} invokes url: {} ERROR: {}"
                , request.getRemoteHost(), request.getRequestURL(), e.getMessage());

        // 定义业务类型,大于100 直接返回 400
        if (e.getErrorCode() > 101){
            return response(e.getMessage(), e, HttpStatus.BAD_REQUEST);
        }else{
            // 否则,其他返回200
            return response(e.getMessage(), e, HttpStatus.OK);
        }
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity handSql(HttpServletRequest request, SQLException e) {
        log.error("SQLException Handler --- Host: {} invokes url: {} ERROR: {}"
                , request.getRemoteHost(), request.getRequestURL(), e.getMessage());
        return response(e.getMessage(), e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(HttpServletRequest request, Exception e) {
        log.error("DefaultException Handler --- Host: {} invokes url: {} ERROR: {}"
                , request.getRemoteHost(), request.getRequestURL(), e.getMessage());
        return response("服务器程序遇到错误,请联系管理员!", e, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    /**
     * 统一异常错误返回格式
     * @param message 异常消息
     * @param e       异常
     * @param status  http状态
     * @return 返回结果实体
     */
    public ResponseEntity response(String message, Exception e, HttpStatus status) {
        log.error(message, e);
        Map<String,String> map = new HashMap<>();
        map.put(ERROR, message);
        return new ResponseEntity<>(map, status);
    }
}

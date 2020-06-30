package com.y.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author yinshuaibin
 * @date 2020/6/3 16:10
 */
public class JacksonUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static <T>T jsonStrToBean(String jsonString, Class<T> valueType) throws IOException {
        T t = objectMapper.readValue(jsonString, valueType);
        return t;
    }

    public static String beanToJsonStr(Object o){
        if (o == null) {
            return null;
        }
        try {
            return o instanceof String ? (String) o : objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}

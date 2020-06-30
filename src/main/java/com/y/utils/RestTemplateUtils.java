package com.y.utils;


import com.y.bean.Authc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 如使用RestTemplate 可以使用@Autowired注入方式, 也可使用RestTemplateUtils.restTemplate
 * postForEntity方法为设置了spplication/json头的utf8编码的http请求
 */
@Configuration
@Order(1)
public class RestTemplateUtils {

    public static RestTemplate restTemplate;

    public static RestTemplate restTemplateHttps;

    private static HttpHeaders httpHeadersXml;

    @Autowired
    private RestTemplate autoRestTemplate;

    public static HttpHeaders httpHeadersXml(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        return headers;
    }

    public static String postForEntityXml(String url, String xml){
        HttpEntity entity = new HttpEntity(xml, httpHeadersXml);
        return restTemplate.postForEntity(url, entity, String.class).getBody();
    }

    public static String postForEntityXmlHttps(String url, String xml){
        HttpEntity entity = new HttpEntity(xml, httpHeadersXml);
        ResponseEntity<String> stringResponseEntity = restTemplateHttps.postForEntity(url, entity, String.class);
        return restTemplateHttps.postForEntity(url, entity, String.class).getBody();
    }

    @PostConstruct
    public void init(){
        restTemplate = this.autoRestTemplate;
        httpHeadersXml = httpHeadersXml();
        restTemplateHttps = new RestTemplate(new HttpsClientRequestFactory());
    }


    public static void main(String[] args)throws Exception {
        RestTemplate r = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        Authc a = new Authc();
        a.setAuthcName("1");
        a.setAuthcId(1);
        HttpEntity entity = new HttpEntity(XmlUtils.beanToXml(a, a.getClass()), headers);
        ResponseEntity<String> stringResponseEntity = r.postForEntity("http://127.0.0.1:8090/t2", entity, String.class);
        System.out.println(stringResponseEntity.getHeaders());
        System.out.println(stringResponseEntity.getHeaders().get("Set-Cookie"));
        System.out.println(stringResponseEntity.getHeaders().get("Set-Cookie").get(0));
        // 获取jid
        System.out.println(stringResponseEntity.getHeaders().get("Set-Cookie").get(0).split(";")[0]);
        List<String> strings = stringResponseEntity.getHeaders().get("Set-Cookie");
        String JSESSIONID = strings.get(0).split(";")[0];
        HttpHeaders h = new HttpHeaders();
        // 为cookie中添加jid
        h.put(HttpHeaders.COOKIE, new ArrayList<String>(){{add(JSESSIONID);}});
        HttpEntity entity2 = new HttpEntity(new HashMap<>(), h);
        ResponseEntity<String> stringResponseEntity2 = r.postForEntity("http://127.0.0.1:8090/t3", entity2, String.class);
        String body = stringResponseEntity.getBody();
        System.out.println(body);

        // 以下为发送表单格式的数据
        HttpHeaders headers2 = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("account", "username");
        map.add("pwd", "password");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
    }

}

package com.y.controller;

import com.y.bean.Authc;
import com.y.dao.ControlpeopleMapper;
import com.y.utils.JacksonUtils;
import com.y.utils.XmlUtils;
import com.y.utils.bean.huawei.Result;
import com.y.utils.bean.huawei.onetomany.response.*;
import com.y.utils.bean.huawei.onetoone.request.Request;
import com.y.utils.bean.huawei.onetoone.response.Response;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author yinshuaibin
 * @date 2020/6/16 9:24
 */
@RestController
public class HuaWeiTestController {

    @RequestMapping("/sdk_service/rest/facematch/1v1")
    public String response(@RequestBody String xmlStr) throws JAXBException {
        Request request = XmlUtils.xmlToJavaBean(xmlStr, Request.class);
        System.out.println(request);
        Response r = new Response();
        r.setSimilarity("88");
        Result result = new Result();
        result.setCode("200");
        result.setErrmsg("200");
        r.setResult(result);
        return XmlUtils.beanToXml(r, r.getClass());
    }
    @RequestMapping("/t3")
    public Object t3(@CookieValue("JSESSIONID") String id){
        System.out.println(id);
        return id;
    }


    @RequestMapping("/t2")
    public Object t2(@RequestHeader("Content-Type") String header, @RequestBody Authc authc){
        System.out.println(authc);
        System.out.println(header);
        String s = "{" +
                "\"status\": 0," +
                "\"memo\": \"\"," +
                "\"result\": [" +
                "{" +
                "\"errorMessage\": \"\"," +
                "\"isFinished\": true," +
                "\"isSuccess\": true," +
                "\"messageId\": \"202005181445505e-af5a-a85708f0eebc\"," +
                "\"messageType\": \"MATRIX_RESULT\"," +
                "\"missionId\": \"202005181445505e-af5a-a85708f0eebc\"," +
                "\"resultRecordCount\": 1," +
                "\"rows\": [" +
                "[" +
                "\"XM\"," +
                "\"GMSFHM\"," +
                "\"ZP\"" +
                "]," +
                "[" +
                "\"张三\"," +
                "\"411002195703031000\"," +
                "\"1da3bac1a82aff28e1477601fd836d98a82aff28e1477601fd836d98753ds\"" +
                "]" +
                "" +
                "]," +
                "\"tags\": {" +
                "\"mainResourceId\": \"MPP_0a3f8914fba742\"," +
                "\"resourceId\": \"MPP_0a3f8914fba742\"" +
                "}" +
                "}" +
                "]}";
        return s;
    }


    @RequestMapping("/sdk_service/rest/staticlibraries/peoples/v1.1")
    public String response2(@RequestBody String xmlStr) throws JAXBException {
        final com.y.utils.bean.huawei.onetomany.request.Request request = XmlUtils.xmlToJavaBean(xmlStr, com.y.utils.bean.huawei.onetomany.request.Request.class);
        System.out.println(request);
        com.y.utils.bean.huawei.onetomany.response.Response r = new com.y.utils.bean.huawei.onetomany.response.Response();
        Result result = new Result();
        r.setTotal("100");
        Peoples ps = new Peoples();
        People people = new People();
        Pictures ps2 = new Pictures();
        Picture picture = new Picture();
        FeatureList fls= new FeatureList();
        picture.setFeatureList(fls);

        Feature feature = new Feature();
        feature.setFeatureId("1");
        feature.setSimilarity("99");
        Feature feature2 = new Feature();
        feature2.setFeatureId("11");
        feature2.setSimilarity("99");
        Feature feature3 = new Feature();
        feature3.setFeatureId("111");
        feature3.setSimilarity("99");
        Feature feature4 = new Feature();
        feature4.setFeatureId("1111");
        feature4.setSimilarity("99");
        Feature feature5 = new Feature();
        feature5.setFeatureId("11111");
        feature5.setSimilarity("99");
        fls.setFeature(new ArrayList<Feature>(){{
            add(feature);
            add(feature2);
            add(feature3);
            add(feature4);
            add(feature5);
        }});
        ps2.setPicture(new ArrayList<Picture>(){{add(picture);}});
        people.setPictures(ps2);
        ps.setPeople(new ArrayList<People>(){{add(people);}});
        result.setCode("200");
        result.setErrmsg("200");
        r.setResult(result);
        r.setPeoples(ps);
        return XmlUtils.beanToXml(r, r.getClass());
    }


    public static void main(String[] args) throws IOException {
        String s = "{" +
                "\"status\": 0," +
                "\"memo\": \"\"," +
                "\"result\": [" +
                "{" +
                "\"errorMessage\": \"\"," +
                "\"isFinished\": true," +
                "\"isSuccess\": true," +
                "\"messageId\": \"202005181445505e-af5a-a85708f0eebc\"," +
                "\"messageType\": \"MATRIX_RESULT\"," +
                "\"missionId\": \"202005181445505e-af5a-a85708f0eebc\"," +
                "\"resultRecordCount\": 1," +
                "\"rows\": [" +
                "[" +
                "\"XM\"," +
                "\"GMSFHM\"," +
                "\"ZP\"" +
                "]," +
                "[" +
                "\"张三\"," +
                "\"411002195703031000\"," +
                "\"1da3bac1a82aff28e1477601fd836d98a82aff28e1477601fd836d98753ds\"" +
                "]" +
                "" +
                "]," +
                "\"tags\": {" +
                "\"mainResourceId\": \"MPP_0a3f8914fba742\"," +
                "\"resourceId\": \"MPP_0a3f8914fba742\"" +
                "}" +
                "}" +
                "]}";

        System.out.println(JacksonUtils.jsonStrToBean(s, Map.class));
    }

    @Resource
    private ControlpeopleMapper controlpeopleMapper;

    @RequestMapping("/t4")
    public String aaa(){
        return controlpeopleMapper.getOne();
    }

}

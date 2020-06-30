package com.y.utils;

import com.alibaba.fastjson.JSONObject;
import com.y.bean.Authc;
import com.y.bean.worinima;
import com.y.bean.TestAuthc;
import com.y.utils.bean.huawei.onetomany.response.Response;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yinshuaibin
 * @date 2020/6/12 9:42
 */
public class XmlUtils {


    /**
     * 不生成xml声明的javaBean转xml(默认无格式, utf8)
     * https://docs.oracle.com/javase/8/docs/api/javax/xml/bind/Marshaller.html
     *
     * @param obj
     * @param load
     * @return
     * @throws JAXBException
     */
    public static String beanToXml(Object obj, Class<?> load) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(load);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        // 不生成xml声明
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        StringWriter writer = new StringWriter();
        marshaller.marshal(obj, writer);
        return writer.toString();
    }

    /**
     * https://docs.oracle.com/javase/8/docs/api/javax/xml/bind/Marshaller.html
     * @param xml xmlString
     * @param c
     * @param <T> 返回值类型
     * @return
     */
    public static <T> T xmlToJavaBean(String xml, Class<T> c) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(c);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (T)unmarshaller.unmarshal(new StringReader(xml));
    }

    public static void main(String[] args) throws JAXBException, Exception {
        String s = "<request>" +
                "<algorithmCodes>" +
                "<algorithmCode/>" +
                "</algorithmCodes>" +
                "<beginTime>1570953881047</beginTime>" +
                "<bornEndTime/>" +
                "<bornStartTime/>" +
                "<domicile/>" +
                "<endTime>1571040285168</endTime>" +
                "<filterOptions>false</filterOptions>" +
                "<gender/>" +
                "<id/>" +
                "<libraryIds>5da39622f89f337890bb67d0</libraryIds>" +
                "<page>" +
                "<no>1</no>" +
                "<orderName>time</orderName>" +
                "<size>10</size>" +
                "<sort>desc</sort>" +
                "</page>" +
                "<picture>" +
                "<fileId>111</fileId>" +
                "</picture>" +
                "<presentPlace/>" +
                "<similarityThreshold/>" +
                "<tag/>" +
                "</request>";
//        System.out.println(xmlToJavaBean(s, Request.class));
//        testResponse();
//        testImageAdd();
        testImageAddSync();
    }

    private static void testImageAddSync() throws Exception{
        String request = "<request>\n" +
                "<callbackURL></callbackURL>\n" +
                "<peoples>\n" +
                "<people>\n" +
                "<bornTime></bornTime>\n" +
                "<country></country>\n" +
                "<credentialNumber></credentialNumber>\n" +
                "<credentialType>0</credentialType>\n" +
                "<description></description>\n" +
                "<gender>-1</gender>\n" +
                "<name></name>\n" +
                "<nationality></nationality>\n" +
                "<occupation></occupation>\n" +
                "<pictures>\n" +
                "<picture>\n" +
                "<fileId>5ad443161d0ecf69d3464a66</fileId>\n" +
                "</picture>\n" +
                "</pictures>\n" +
                "</people>\n" +
                "</peoples>\n" +
                "<sync>false</sync>\n" +
                "</request>\n";
        // 给的返回值结果不对
        String response = "<response>\n" +
                "<result>\n" +
                "<errmsg>Success.</errmsg>\n" +
                "<code>0</code>\n" +
                "</result>\n" +
                "<ids>\n" +
                "<id>5ad445f6d65063f214226ea5</id>\n" +
                "</ids>";
        System.out.println(xmlToJavaBean(request, com.y.utils.bean.huawei.imageadd.request.sync.Request.class));
        //System.out.println(xmlToJavaBean(response, com.y.utils.bean.huawei.imageadd.response.sync.Response.class));
    }

    private static void testImageAdd() throws Exception{
        String request = "<request> \n" +
                "  <callbackURL/>  \n" +
                "  <peoples> \n" +
                "    <people> \n" +
                "      <bornTime/>  \n" +
                "      <country/>  \n" +
                "      <credentialNumber/>  \n" +
                "      <credentialType>0</credentialType>  \n" +
                "      <description/>  \n" +
                "      <gender>-1</gender>  \n" +
                "      <name/>  \n" +
                "      <nationality/>  \n" +
                "      <occupation/>  \n" +
                "      <pictures> \n" +
                "        <picture> \n" +
                "          <fileId>5da42186f89f33c84593289a</fileId> \n" +
                "        </picture> \n" +
                "      </pictures> \n" +
                "    </people> \n" +
                "  </peoples>  \n" +
                "  <sync>true</sync> \n" +
                "</request>\n";

        String response = "<response>\n" +
                "<result>\n" +
                "<errmsg>Success.</errmsg>\n" +
                "<code>0</code>\n" +
                "</result>\n" +
                "<peoples>\n" +
                "<people>\n" +
                "<peopleId>5da42865f89f33232cd82405</peopleId>\n" +
                "<faceList>\n" +
                "<face>\n" +
                "<featureList>\n" +
                "<feature>\n" +
                "<algorithmCode>0204000100</algorithmCode>\n" +
                "<faceState>0</faceState>\n" +
                "<featureId>26357666237867264</featureId>\n" +
                "<fileId>5da42186f89f33c84593289a</fileId>\n" +
                "<peopleId>5da42865f89f33232cd82405</peopleId>\n" +
                "<quality>99</quality>\n" +
                "</feature>\n" +
                "</featureList>\n" +
                "<fileId>5da42186f89f33c84593289a</fileId>\n" +
                "<url>http://192.168.12.26/sdk_service/rest/image-library/get-image?imageSize=1&amp;imageType=1&amp;fileId=5da42186f89f33c84593289a</url>\n" +
                "</face>\n" +
                "</faceList>\n" +
                "</people>\n" +
                "</peoples>\n" +
                "</response>";

        System.out.println(xmlToJavaBean(request, com.y.utils.bean.huawei.imageadd.request.Request.class));
        System.out.println(xmlToJavaBean(response, com.y.utils.bean.huawei.imageadd.response.Response.class));
    }


    private static void testResponse() throws JAXBException {
        String s = "<response>\n" +
                "<result>\n" +
                "<errmsg>Success.</errmsg>\n" +
                "<code>0</code>\n" +
                "</result>\n" +
                "<peoples>\n" +
                "<people>\n" +
                "<bornTime></bornTime>\n" +
                "<country></country>\n" +
                "<creatTime>1571039662684</creatTime>\n" +
                "<credentialType>0</credentialType>\n" +
                "<description></description>\n" +
                "<gender>-1</gender>\n" +
                "<id>5da429aef89f33232cd8240a</id>\n" +
                "<libraryId>5da39622f89f337890bb67d0</libraryId>\n" +
                "<nationality></nationality>\n" +
                "<pictures>\n" +
                "<picture>\n" +
                "<featureList>\n" +
                "<feature>\n" +
                "<algorithmCode>0204000100</algorithmCode>\n" +
                "<faceState>0</faceState>\n" +
                "<featureId>24603816455806982</featureId>\n" +
                "<quality>99</quality>\n" +
                "</feature>\n" +
                "</featureList>\n" +
                "<fileId>5da42186f89f33c84593289a</fileId>\n" +
                "<url>http://192.168.12.26/sdk_service/rest/image-library/get-image?imageSize=1&amp;imageType=1&amp;fileId=5da42186f89f33c84593289a</url>\n" +
                "</picture>\n" +
                "</pictures>\n" +
                "</people>\n" +
                "<people>\n" +
                "<bornTime></bornTime>\n" +
                "<country></country>\n" +
                "<creatTime>1571039333381</creatTime>\n" +
                "<credentialType>0</credentialType>\n" +
                "<description></description>\n" +
                "<gender>-1</gender>\n" +
                "<id>5da42865f89f33232cd82405</id>\n" +
                "<libraryId>5da39622f89f337890bb67d0</libraryId>\n" +
                "<nationality></nationality>\n" +
                "<pictures>\n" +
                "<picture>\n" +
                "<featureList>\n" +
                "<feature>\n" +
                "<algorithmCode>0204000100</algorithmCode>\n" +
                "<faceState>0</faceState>\n" +
                "<featureId>26357666237867264</featureId>\n" +
                "<quality>99</quality>\n" +
                "</feature>\n" +
                "</featureList>\n" +
                "<fileId>5da42186f89f33c84593289a</fileId>\n" +
                "<url>http://192.168.12.26/sdk_service/rest/image-library/get-image?imageSize=1&amp;imageType=1&amp;fileId=5da42186f89f33c84593289a</url>\n" +
                "</picture>\n" +
                "</pictures>\n" +
                "</people>\n" +
                "<people>\n" +
                "<bornTime></bornTime>\n" +
                "<country></country>\n" +
                "<creatTime>1571039278987</creatTime>\n" +
                "<credentialType>0</credentialType>\n" +
                "<description></description>\n" +
                "<gender>-1</gender>\n" +
                "<id>5da4282ef89f33232cd82403</id>\n" +
                "<libraryId>5da39622f89f337890bb67d0</libraryId>\n" +
                "<nationality></nationality>\n" +
                "<pictures>\n" +
                "<picture>\n" +
                "<featureList>\n" +
                "<feature>\n" +
                "<algorithmCode>0204000100</algorithmCode>\n" +
                "<faceState>0</faceState>\n" +
                "<featureId>24603814874554368</featureId>\n" +
                "<quality>99</quality>\n" +
                "</feature>\n" +
                "</featureList>\n" +
                "<fileId>5da42186f89f33c84593289a</fileId>\n" +
                "<url>http://192.168.12.26/sdk_service/rest/image-library/get-image?imageSize=1&amp;imageType=1&amp;fileId=5da42186f89f33c84593289a</url>\n" +
                "</picture>\n" +
                "</pictures>\n" +
                "</people>\n" +
                "<people>\n" +
                "<bornTime>2001-10-14</bornTime>\n" +
                "<country>&#20013;&#22269;</country>\n" +
                "<creatTime>1571037671260</creatTime>\n" +
                "<credentialNumber>01234567890</credentialNumber>\n" +
                "<credentialType>0</credentialType>\n" +
                "<description>test</description>\n" +
                "<gender>0</gender>\n" +
                "<id>5da421e7f89f33232cd823f7</id>\n" +
                "<libraryId>5da39622f89f337890bb67d0</libraryId>\n" +
                "<name>test</name>\n" +
                "<nationality></nationality>\n" +
                "<occupation>test</occupation>\n" +
                "<pictures>\n" +
                "<picture>\n" +
                "<featureList>\n" +
                "<feature>\n" +
                "<algorithmCode>0204000100</algorithmCode>\n" +
                "<faceState>0</faceState>\n" +
                "<featureId>24603808339828736</featureId>\n" +
                "<quality>99</quality>\n" +
                "</feature>\n" +
                "</featureList>\n" +
                "<fileId>5da42186f89f33c84593289a</fileId>\n" +
                "<url>http://192.168.12.26/sdk_service/rest/image-library/get-image?imageSize=1&amp;imageType=1&amp;fileId=5da42186f89f33c84593289a</url>\n" +
                "</picture>\n" +
                "</pictures>\n" +
                "</people>\n" +
                "</peoples>\n" +
                "<total>4</total>\n" +
                "</response>";
        System.out.println(xmlToJavaBean(s, Response.class));
        Response response = xmlToJavaBean(s, Response.class);
        System.out.println(response);
        List list = new ArrayList();
        for (int x = 0; x < 3; x++){
            Authc authc = new Authc();
            authc.setAuthcId(x);
            list.add(authc);
        }
        TestAuthc t = new TestAuthc();
        worinima a = new worinima();
//        t.setAuthc(a);
//        a.setAuthcs(list);
        System.out.println(beanToXml(t, t.getClass()));
        System.out.println(beanToXml(a, a.getClass()));
        System.out.println(JSONObject.toJSONString(a));
    }
}

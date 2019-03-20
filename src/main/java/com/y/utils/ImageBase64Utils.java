package com.y.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;


@Slf4j
@Component
public class ImageBase64Utils {

	//图片转化成base64字符串  
	public static String getImageStr(String url)
	    {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理  
	        String imgFile =url;//待处理的图片  
	        InputStream in = null;  
	        byte[] data = null;  
	        //读取图片字节数组  
	        try   
	        {  
	            in = new FileInputStream(imgFile);          
	            data = new byte[in.available()];  
	            in.read(data);  
	            in.close();  
	        }   
	        catch (IOException e) {
	            //e.printStackTrace();
	        }  finally {
	        	if( null != in){
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
	        //对字节数组Base64编码  
	        BASE64Encoder encoder = new BASE64Encoder();  
	        return encoder.encode(data);//返回Base64编码过的字节数组字符串  
	    }  
	      
	//base64字符串转化成图片  
	public static boolean generateImage(String imgStr, String imgPath)
	    {   //对字节数组字符串进行Base64解码并生成图片  
	        if (imgStr == null) //图像数据为空  
	            return false;  
	        BASE64Decoder decoder = new BASE64Decoder();  
	        try   
	        {  
	            //Base64解码  
	            byte[] b = decoder.decodeBuffer(imgStr);  
	            for(int i=0;i<b.length;++i)  
	            {  
	                if(b[i]<0)  
	                {//调整异常数据  
	                    b[i]+=256;  
	                }  
	            }  
	            //生成jpeg图片  
	            OutputStream out = null;
				try {
					out = new FileOutputStream(imgPath );
					out.write(b);
					out.flush();
					out.close();
				} catch (IOException e){
					e.printStackTrace();
				}finally {
					if(null != out){
						try {
							out.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}

	            return true;  
	        }   
	        catch (IOException e)
	        {  
	            return false;  
	        }  
	    }
}

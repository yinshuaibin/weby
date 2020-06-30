package com.y.utils;

import lombok.extern.slf4j.Slf4j;

import javax.imageio.stream.FileImageInputStream;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;


@Slf4j
public class ImageBase64Utils {

    /**
     * 图片转化成base64字符串
     * @param url
     * @return
     */
	public static String getImageStr(String url) {
	    //将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        byte[] data = null;
        //读取图片字节数组
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(url))){
            data = new byte[in.available()];
            in.read(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //对字节数组Base64编码
        return java.util.Base64.getEncoder().encodeToString(data);
	}

    /**
     * base64字符串转化成图片
      * @param imgStr
     * @param imgPath
     * @return
     */
	public static boolean generateImage(String imgStr, String imgPath) {
	    //对字节数组字符串进行Base64解码并生成图片
	        if (imgStr == null) {
	            //图像数据为空
                return false;
            }
            //Base64解码
            byte[] b = java.util.Base64.getDecoder().decode(imgStr);
            for(int i=0;i<b.length;++i) {
                if(b[i]<0) {
                    //调整异常数据
                    b[i]+=256;
                }
            }
            //生成jpeg图片
            try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(imgPath))){
                out.write(b);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
	    }

	/**
	 *
	 * 图片url地址转base64String编码
	 * @author y
	 * @param imgUrl 图片地址
	 * @return base64 字符串
	 */
	public static String generateBase64ImageURL(String imgUrl){
		byte[] data =null;
		try {
			URL url = new URL(imgUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			//设置超时间为3秒
			conn.setConnectTimeout(3*1000);
			//防止屏蔽程序抓取而返回403错误
			conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			InputStream inStream = conn.getInputStream();
			data = readInputStream(inStream);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("url转base64失败！");
		}
		// 对字节数组Base64编码
		return  java.util.Base64.getEncoder().encodeToString(data);
	}

	private static byte[] readInputStream(InputStream inStream) throws Exception{
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		//创建一个Buffer字符串
		byte[] buffer = new byte[1024];
		//每次读取的字符串长度，如果为-1，代表全部读取完毕
		int len = 0;
		//使用一个输入流从buffer里把数据读取出来
		while( (len=inStream.read(buffer)) != -1 ){
			//用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
			outStream.write(buffer, 0, len);
		}
		//关闭输入流
		inStream.close();
		//把outStream里的数据写入内存
		return outStream.toByteArray();
	}

    /**
     * 图片转byte数组
     * @param path
     * @return
     * @throws Exception
     */
    public static byte[] image2byte(String path){
        byte[] data = null;
        try (FileImageInputStream input = new FileImageInputStream(new File(path)); ByteArrayOutputStream output = new ByteArrayOutputStream()){
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
        }catch (IOException e){
            System.out.println("get img byte[] is error :" + e.getMessage());
        }
        return data;
    }

    /**
     * 16进制图片base64转正常图片base64
     * @param data
     * @return
     */
    public static String base64(String data){
        byte[] bytes = getBytesByHexString(data);
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * 16进图图片保存到本地
     * @param data
     * @param filePath
     */
    public static void base64(String data,String filePath){
        byte[] bytes = getBytesByHexString(data);
        try(BufferedOutputStream bufferedOutputStream  = new BufferedOutputStream(new FileOutputStream(new File(filePath)))) {
            bufferedOutputStream.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 16进制图片数据转byte数组
     * @param data
     * @return
     */
    private static byte[] getBytesByHexString(String data) {
        int length = data.length() / 2;
        byte[] bytes = new byte[length];
        for (int i = 0; i < length; i++) {
            bytes[i] = (byte) (Character.digit(data.charAt(i * 2), 16) << 4 | Character.digit(data.charAt((i * 2) + 1), 16));
        }
        return bytes;
    }
}

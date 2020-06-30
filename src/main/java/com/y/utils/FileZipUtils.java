package com.y.utils;


import java.io.*;
import java.nio.channels.*;
import java.time.Clock;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileZipUtils {

    public static void main(String[] args) {
        String s = "upload/111.jpg";
        String[] split = s.split("/");
        String s1 = split[split.length - 1];
        System.out.println(s1);
        long start = Clock.systemDefaultZone().millis();
        fileToZipBufferInput("d://ddd.jpg", "d://ddd.zip");
        long end = Clock.systemDefaultZone().millis();
        System.out.println("bufferInputStream用时:" + (end - start));
        // fileTOZipInput("d://ddd.jpg", "d:/ddd2.zip");
        long end2 = Clock.systemDefaultZone().millis();
        System.out.println("intpuStream用时: " + (end2 - end));
        fileToZipChannel("d://ddd.jpg", "d:/ddd3.zip");
        long end3 = Clock.systemDefaultZone().millis();
        System.out.println("fileChannel用时: " + (end3 - end2));
    }

    private static void fileToZipBufferInput(String filePath, String zipPath){
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(new File(zipPath)));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(zipOutputStream)){
            for (int x = 0; x < 80000; x++){
                try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath))) {
                    int byts = 0;
                    zipOutputStream.putNextEntry(new ZipEntry(x + "ddd.jpg"));
                    while ((byts = bufferedInputStream.read()) != -1){
                        bufferedOutputStream.write(byts);
                    }
                }catch (IOException e){
                    System.out.println("读取文件出现错误, 请确认要压缩的问题件路径");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void fileTOZipInput(String filePath, String zipPath){
        try(ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(new File(zipPath)))){
            for (int x = 0; x < 80; x++){
                try(FileInputStream f = new FileInputStream(filePath)) {
                    int byts = 0;
                    zipOutputStream.putNextEntry(new ZipEntry(x + "ddd.jpg"));
                    // 一次只读取一个字节, 读取到末尾或出现-1
                    while ((byts = f.read()) != -1){
                        zipOutputStream.write(byts);
                    }
                }catch (IOException e){
                }
            }
        }catch (Exception e){

        }
    }

    private static void fileToZipChannel(String filePath, String zipPath){
        File file = new File(filePath);
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(new File(zipPath)));
             WritableByteChannel writableByteChannel = Channels.newChannel(zipOutputStream)
        ){
            for (int x = 0; x < 80; x++){
                zipOutputStream.putNextEntry(new ZipEntry(x +"_ddd.jpg"));
                try (FileChannel fileChannel = new FileInputStream(filePath).getChannel()){
                    fileChannel.transferTo(0, fileChannel.size(), writableByteChannel);
                }catch (IOException e){

                }
            }
        }catch (Exception e){

        }
    }
}

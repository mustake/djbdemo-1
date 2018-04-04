package com.djb.javademo.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 *  io读取配置文件
 *
 */
public class IOProperties {

    public static Map<String,String> readProperties(String path){
        Map<String,String> resultMap=new HashMap<>();
        try( InputStreamReader isr=new InputStreamReader(new FileInputStream(new File(path)),"GBK")){
           StringBuffer sb=new StringBuffer();

            while (isr.read()!= -1){
                char[] chars=new char[1024];
                isr.read(chars);
                System.out.println(chars);
                sb.append(chars);
            }

            String[] stringArray=sb.toString().split("\\r\\n");
            for (String string:stringArray) {
             //   System.out.println("string---"+string);
                if ( !string.isEmpty() && !"#".equals(string.charAt(0)))
                {
                    String[] tempArray=string.split("=");
                    if (tempArray.length>1){
                        System.out.println(tempArray[0]+"-----"+tempArray[1]);
                        resultMap.put(tempArray[0],tempArray[1]);
                    }

                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return  resultMap;
    }

    public static void main(String[] args) {
        String path="D:\\iworkspace\\djbdemo-1\\javademo\\src\\main\\resources\\properties\\jdbc.properties";
        readProperties(path);

    }


}

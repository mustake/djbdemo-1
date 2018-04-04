package com.djb.javademo.test;

import com.sun.org.apache.xpath.internal.SourceTree;

public class TestStringFactory {

     private volatile StringFactory stringFactory;
     public  StringFactory getStringFactory(){
         return  stringFactory;
     }


    public static void main(String[] args) {
// 0.00   0000    0.0   0  ""   .0  0.0000000
         String[] strArray={"0.00","","0.0","0",null,".0","0.00000","125.7000",".750","1755","zz","中文"};
        for (String str:strArray) {
            try {
                if (null!=str && !str.isEmpty()){
                    Double doubleTemp=Double.valueOf(str);
                    System.out.println(doubleTemp);

                }
            }catch (NumberFormatException e){

                System.out.println("0.00");
            }

        }


    }

}

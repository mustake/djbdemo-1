package com.djb.javademo.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @authot Administrator
 * @date 29
 */
public class Solution {
    //3. 无重复字符的最长子串
    //给定一个字符串，找出不含有重复字符的 最长子串 的长度。

    public static int lengthOfLongestSubstring(String s) {
        char[] arrayString=s.toCharArray();
        Set set=new HashSet();
        int count=0;
        for (int i=0;i<arrayString.length;i++){
            if(!set.add(arrayString[i])) {
                   if(set.size()>count){
                       count=set.size();
                   }
                   set.clear();
                   set.add(arrayString[i]);
            }

        }
        if(set.size()>count){
            count=set.size();
        }
        System.out.println(count);
        return count;
    }


    public static void main(String[] args) {
        String s="pwwkew";
        lengthOfLongestSubstring(s);
    }
}

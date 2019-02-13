package com.company.test2018_001.questions;

import java.util.*;

/*
	题目描述
		输入�?个正整数的字符串，输出与它最接近的对称数�?(不包括它自己)的字符串
		�?1: 输入字符串的长度�?多不会超�?18
		�?2: 当大于输入数字和小于输入数字的对称数字与输入数字距离相同时，取小的数字作为答�? 
	
	输入描述:
		输入为一个正整数的字符串
	输出描述:
		输出为与输入数字�?接近的对称数�?(不包括输入本�?)的字符串
		
	示例1
		输入
			123
		输出
			121
 */
public class Question_011 {
	public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);      
        String str = sc.next();
        char[] t = str.toCharArray();
        if(t.length%2==0) {
        	char a = t[t.length/2-1];
        	char b = t[t.length/2];
        	int mid = Integer.valueOf(""+a+""+b);
        	int aa = Integer.valueOf(""+a+""+a);
        	int bb = Integer.valueOf(""+b+""+b);
        	if(Math.abs(mid-aa)>Math.abs(mid-bb)) {
        		t[t.length/2-1]=t[t.length/2];
        	}else {
        		t[t.length/2]=t[t.length/2-1];
        	}
        	for(int i = t.length/2+1;i<t.length;i++) {
        		t[i] = t[t.length-i-1];
        	}
        }else {
        	for(int i = t.length/2+1;i<t.length;i++) {
        		t[i] = t[t.length-i-1];
        	}
        }
        String s = "";
        for(char a:t){
        	s+=a;
        }
        System.out.println(s);
        sc.close();
    }
}

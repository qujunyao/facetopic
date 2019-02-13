package com.company.test2018_001.questions;

import java.util.*;

/*
	题目描述
		两个int32整数m和n的二进制表达，计算有多少个位(bit)不同？
	
	输入描述:
		一行中给定两个数字
	输出描述:
		输出这两个数字中bit不同的个数
	示例1
		输入
			15 8
		输出
			3
 */
public class Question_013 {
	public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);      
        int a = sc.nextInt();
        int b = sc.nextInt();
        String a2 = Integer.toBinaryString(a);
        String b2 = Integer.toBinaryString(b);
        if(a2.length()>b2.length()) {
        	int time = a2.length()-b2.length();
        	for(int i = 0;i<time;i++) {
        		b2 = "0"+b2;
        	}
        }else if(a2.length()<b2.length()) {
        	int time = b2.length()-a2.length();
        	for(int i = 0;i<time;i++) {
        		b2 = "0"+b2;
        	}
        }
        int count = 0;
        char[] a3 = a2.toCharArray();
        char[] b3 = b2.toCharArray();
        for(int i = 0;i<a3.length;i++) {
        	if(a3[i]==b3[i]) {
        		
        	}else {
        		count++;
        	}
        }
        System.out.println(count);
        sc.close();
    }
}

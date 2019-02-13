package com.company.test2018_001.questions;

import java.util.*;

/*
	题目描述
		有两个字符串（可能包含空格）,请找出其中最长的公共连续子串,输出其长度�??
	
	输入描述:
		给定两行字符�?
		长度�?1000以内
	
	输出描述:
		输出这两个字符串的最长公共连续子串的长度
	示例1
		输入
			abcde
			bcdw
		输出
			3
 */
public class Question_014 {
	public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);     
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int [][]n = new int [s1.length][s2.length];
        int result = 0;
        for(int i = 0;i<s1.length;i++) {
        	for(int j = 0;j<s2.length;j++) {
        		if(s1[i]==s2[j]) {
        			if(i==0||j==0) {
        				n[i][j] = 1;
        			}else {
        				n[i][j] = n[i-1][j-1] + 1;
        			}
        			if(result<n[i][j]) {
        				result = n[i][j];
        			}
        		}
        	}
        }
        System.out.println(result);
        sc.close();
    }
}

package com.company.test2018_001.questions;

import java.util.*;

/*
	题目描述
		小雅同学认为6,8是她的幸运数�?,而其他数字均不是,�?个幸运数是指在十进制表示下只含有幸运数字的数�?
		给定你一个区间（a,b）a和b之间（其中包括a和b幸）运数的个数�??
	
	输入描述:
		输入两个整数a和b，a的取值范围在1�?1000000000之间（其中包�?1�?1000000000），b的取值范围在
		a�?1000000000之间（其中包括a�?1000000000）�??
	输出描述:
		返回a和b之间的幸运数个数，如果入参不合法，请输出-1
		
	示例1
		输入
			1 10
		输出
			2
		说明
			6,8,6666,88888,6668888,68686688均为幸运数字，当a=1，b=10函数返回值为2�?
 */
public class Question_008 {
	public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
        int a = sc.nextInt();
        int b = sc.nextInt();
        int num = 0;
        if(a>b) {
        	System.out.println(-1);
        }else {
        	for(int i = a;i<=b;i++) {
        		if(contain(i)) {
        			num++;
        		}
        	}
        	System.out.println(num);
        }
        sc.close();
    }

	private static boolean contain(int n) {
		String s = n+"";
		char[] str = s.toCharArray();
		for(int i = 0;i<str.length;i++) {
			if(str[i]!='6') {
				if(str[i]!='8') {
					return false;
				}
			}else if(str[i]!='8') {
				if(str[i]!='6') {
					return false;
				}
			}
		}
		return true;
	}
}

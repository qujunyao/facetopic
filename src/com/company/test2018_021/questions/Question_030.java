package com.company.test2018_021.questions;

import java.io.*;

/*
	题目描述
		给定非负整数a, b, m,利用基本的算术运算符(+ - * / % )以及位运算符，计算a^b  mod m

	输入描述:
		一行三个非负整数，空格分隔，分为a b m的值，其中m不为0
	输出描述:
		a^b  mod m的结果
	示例1
		输入
			2 10 5
		输出
			4
	
 */
public class Question_030 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		long temp = Long.valueOf(arr[0]);
		long b = Long.valueOf(arr[1]);
		long m = Long.valueOf(arr[2]);
		long result = 1;
		while(b!=0) {
			if((b&1)!=0) {
				result=(result*temp)%m;
			}
			temp=(temp*temp)%m;
			b>>>=1;
		}
		System.out.println(result);
	}
}

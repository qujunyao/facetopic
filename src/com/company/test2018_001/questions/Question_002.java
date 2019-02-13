package com.company.test2018_001.questions;

import java.util.Scanner;

/*
	题目描述
	某种特殊的数列a1, a2, a3, ...的定义如下：a1 = 1, a2 = 2, ... , an = 2 * an �? 1 + an - 2 (n > 2)�?
	给出任意�?个正整数k，求该数列的第k项模�?32767的结果是多少�?
	输入描述:
		�?1行是测试数据的组数n，后面跟�?n行输入�?�每组测试数据占1行，包括�?个正整数k (1 �? k < 1000000)�?
	输出描述:
		n行，每行输出对应�?个输入�?�输出应是一个非负整数�??
	示例1
		输入
			2
			1
			8
		输出
			1
			408
 */
public class Question_002 {
	public static void main(String[] args) {
		Scanner  scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		for(int i = 0;i<num;i++) {
			int str = scanner.nextInt();
			System.out.println(comp(str));
		}
		scanner.close();
	}
	private static Long comp(int str) {
		if(str == 1) {
			return  1L;
		}else if(str == 2 ){
			return  2L;
		}else {
			Long a = 1L;
			Long b = 2L;
			Long sum = 0L;
			for(int i = 3;i<=str;i++) {
				sum = (2*b+a)%32767;
				a = b;
				b = sum;
			}
			return sum;
		}
	}
}

package com.company.test2017.questions;

import java.util.Scanner;

/*
	题目描述
		给定一个十进制的正整数number，选择从里面去掉一部分数字，希望保留下来的数字组成的正整数最大。
	输入描述:
		输入为两行内容，第一行是正整数number，1 ≤ length(number) ≤ 50000。第二行是希望去掉的
		数字数量cnt 1 ≤ cnt < length(number)。
	输出描述:
		输出保留下来的结果。
	示例1
		输入
		325 1
		输出
		35
 */
public class Question_010 {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			String number = s.next();
			int cnt = s.nextInt();
			s.close();
			boolean flag = false;
			for (int i = 0; i < cnt; i++) {
				flag = false;
				for (int j = 1; j < number.length(); j++) {
					char a = number.charAt(j - 1);
					char b = number.charAt(j);
					if (a < b) {
						number = sub(number, j - 1);
						flag = true;
						break;
					}
				}
				if(!flag) {
					number = number.substring(0,number.length()-1);
				}
			}
			System.out.println(number);
		} catch (Exception e) {
			System.out.println(1);
		}
	}

	private static String sub(String number, int j) {
		String a = number.substring(0, j);
		String b = number.substring(j + 1);
		return a + b;
	}

}

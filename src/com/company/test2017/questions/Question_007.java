package com.company.test2017.questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/*
	题目描述
		数列的第一项为n，以后各项为前一项的平方根，求数列的前m项的和。
	输入描述:
		输入数据有多组，每组占一行，由两个整数n（n < 10000）和m(m < 1000)组成，n和m的含义如前所述。
	输出描述:
		对于每组输入数据，输出该数列的和，每个测试实例占一行，要求精度保留2位小数。
	
	示例1
		输入
		81 4
		2 2
		输出
		94.73
		3.41
 */
public class Question_007 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		while ((str = bf.readLine()) != null) {
			String[] arr = str.split(" ");
			double m = Integer.valueOf(arr[0]);
			int n = Integer.valueOf(arr[1]);
			double sum = m+0;
			for(int i = 1;i<n;i++) {
				m = Math.sqrt(m);
				sum+=m;
			}
			DecimalFormat df = new DecimalFormat("#.00");
			System.out.println(df.format(sum));
		}
	}
}

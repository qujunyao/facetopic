package com.company.test2018_021.questions;

import java.io.*;

/*
	题目描述
		小Q从牛博士那里获得了一个数字转换机，这台数字转换机必须同时输入两个正数a和b，并且这台数字转换
		机有一个红色的按钮和一个蓝色的按钮：
		当按下了红色按钮，两个数字同时加1。
		当按下了蓝色按钮，两个数字同时乘2。
		小Q现在手中有四个整数a，b，A，B，他希望将输入的两个整数a和b变成A，B（a对应A，b对应B）。因为
		牛博士允许小Q使用数字转换机的时间有限，所以小Q希望按动按钮的次数越少越好。请你帮帮小Q吧。
		
	输入描述:
		输入包括一行，一行中有四个正整数a，b，A，B，（1≤a，b，A，B≤10^9）。
	输出描述:
		如果小Q可以完成转换，输出最少需要按动按钮的次数，否则输出-1。
	示例1
		输入
			100  1000  202  2002
		输出
			2
 */
public class Question_027 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] t = br.readLine().split(" ");
		int a = Integer.valueOf(t[0]);
		int b = Integer.valueOf(t[2]);
		int c = Integer.valueOf(t[1]);
		int d = Integer.valueOf(t[3]);
		int r = check(a, b);
		int r2 = check(c,d);
		if(r==r2) {
			System.out.println(r);
		}else {
			System.out.println(-1);
		}
    }

	private static int check(int a, int b) {
		int a1 = b/a;
		int num = 0;
		while(true) {
			if(a1/2>=1) {
				num++;
				a1 /= 2;
			}else {
				break;
			}
		}
		int result = num;
		int b1 = (int) (b-a*Math.pow(2, num));
		for(int i = 0;i<num;i++) {
			if(b1%2==1) {
				b1--;
				result++;
			}
			b1/=2;
		}
		result+=b1;
		return result;
	}
}

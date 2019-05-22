package com.company.test2018_021.questions;

import java.io.*;

/*
	题目描述
		小Q搜寻了整个魔法世界找到了四块魔法石所在地，当4块魔法石正好能构成一个正方形的时候将启动魔法阵，小Q就可以借此实现一个愿望。
		现在给出四块魔法石所在的坐标，小Q想知道他是否能启动魔法阵
	输入描述:
		输入的第一行包括一个整数（1≤T≤5）表示一共有T组数据
		每组数据的第一行包括四个整数x[i](0≤x[i]≤10000)，即每块魔法石所在的横坐标
		每组数据的第二行包括四个整数y[i](0≤y[i]≤10000),即每块魔法石所在的纵坐标
	输出描述:
		对于每组数据，如果能启动魔法阵输出“Yes”否则输出“No”。
	示例1
		输入
			3
			0022
			0202
			0156
			1605
			0077
			0303
		输出
			Yes
			Yes
			No
 */
public class Question_026 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(br.readLine());
		for(int i=0;i<t;i++) {
			String[] x = br.readLine().split("");
			String[] y = br.readLine().split("");
			int [][] a = new int [x.length][2];
			for(int j = 0;j<x.length;j++) {
				a[j][0] = Integer.valueOf(x[j]); 
				a[j][1] = Integer.valueOf(y[j]); 
				//System.out.println(a[j][0]+","+a[j][1]);
			}
			String result = check(a);
			System.out.println(result);
		}
		
    }
	private static String check(int[][] a) {
		int a1 = (a[1][1]-a[0][1])*(a[1][1]-a[0][1])+(a[1][0]-a[0][0])*(a[1][0]-a[0][0]);
		int a2 = (a[2][1]-a[0][1])*(a[2][1]-a[0][1])+(a[2][0]-a[0][0])*(a[2][0]-a[0][0]);
		int a3 = (a[3][1]-a[0][1])*(a[3][1]-a[0][1])+(a[3][0]-a[0][0])*(a[3][0]-a[0][0]);
		if((a1+a2==a3)||(a3+a2==a1)||(a3+a1==a2)){
			if((a1==a2)||(a3==a2)||(a1==a3)) {
				return "Yes";
			}
		}
		return "No";
	}
}

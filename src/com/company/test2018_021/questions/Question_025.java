package com.company.test2018_021.questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
	题目描述
		小Q和牛博士在玩一个石子合并的游戏，初始一共有n堆石子，每堆石子有w[i]个石子。
		小Q和牛博士他们需要对石子堆进行合并，每次他们可以任意选择两堆石子进行合并。一
		堆有x个石子的石子堆和一堆有y个石子的石子堆合并将得到一堆x+y个石子的石子堆，
		这次合并得分为x*y，当只剩下一堆石子的时候游戏结束。小Q和牛博士希望采取优秀的
		策略获得最大得分，希望你能来帮他们算算最大得分多少。

	输入描述:
		输入包括两行，第一行一个正整数n(2≤n≤100)。
		第二行包括n个正整数w[i](1≤w[i]≤100)，即每堆石子的个数。
	输出描述:
		输出一个正整数，即小Q和牛博士最大得分是多少。
	示例1
		输入
			3
			1 2 3
		输出
			11
 */
public class Question_025 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int sum = 0;
		int temp = 0;
		int result = 0;
		String[] str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
        	temp = Integer.parseInt(str[i]);
			if(i==0) {
				result = temp;
				sum = 0;
			}else {
				sum = sum + result * temp;
				result += temp;
			}
        }
		System.out.println(sum);
		sc.close();
    }
}

package com.company.nowcoder.question;

import java.util.Scanner;

/*
	题目描述
	小AA找到了一个数列，她想要知道这个数列中所有长度为偶数的区间异或和之和 。
	后来她发现这个问题太简单了，于是她加了一个限制，要求区间长度在[L,R]之间，
	然后她就不会了。。。
	请你告诉她问题的答案。
	
	输入描述:
	第一行三个数 n, L, R(n<=105,1<=L<=R<=n)
	第二行n个数表示这个数列。(ai<=109)
	输出描述:
	输出一行表示答案，由于答案可能很大，请输出答案模109+7的值。
	
	示例1
	输入
	5 1 5
	1 2 3 4 5
	输出
	16
	
	示例2
	输入
	4 1 4
	4 4 4 4
	输出
	0
 */
public class Question_002 {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int n = input.nextInt();
		int m = input.nextInt();
		int k = input.nextInt();
		int s1 = n * m / result(n, m);
		int s2 = s1 *k /result(s1, k);
		System.out.println(s2);
		input.close();
	}
	
	static int result(int a,int b)
	{
	    return b==0?a:result(b,a%b);
	}

}

package com.company.test2018_021.questions;

import java.util.*;

/*
	题目描述
		小Q在学习许多排序算法之后灵机一动决定自己发明一种排序算法，小Q希望能将n个不同的数排
		序为升序。小Q发明的排序算法在每轮允许两种操作：
		1、 将当前序列中前n-1个数排为升序
		2、 将当前序列中后n-1个数排为升序
		小Q可以任意次使用上述两种操作，小Q现在想考考你最少需要几次上述操作可以让序列变为升序。
	
	输入描述:
		输入包括两行，第一行包括一个正整数n(3≤n≤10^5)，表示数字的个数
		第二行包括n个正整数a[i](1≤a[i]≤10^9)，即需要排序的数字，保证数字各不相同。
	输出描述:
		输出一个正整数，表示最少需要的操作次数
	示例1
		输入
			6
			4 3 1 6 2 5
		输出
			2
 */
public class Question_024 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int maxIndex = 0;
		int minIndex = 0;
		for(int i = 0;i<n;i++) {
			int temp = sc.nextInt();
			if(temp>max) {
				max = temp;
				maxIndex = i;
			}
			if(temp<min) {
				min = temp;
				minIndex = i;
			}
		}
		if(minIndex==0&&maxIndex==n-1) {
			System.out.println(1);
		}else if(maxIndex==n-1&&minIndex>0&&minIndex<n-1) {
			System.out.println(1);
		}else if(minIndex==0&&maxIndex>0&&maxIndex<n-1) {
			System.out.println(1);
		}else if(minIndex>0&&minIndex<n-1&&maxIndex>0&&maxIndex<n-1) {
			System.out.println(2);
		}else if(minIndex>0&&minIndex<n-1&&maxIndex==0) {
			System.out.println(2);
		}else if(maxIndex>0&&maxIndex<n-1&&minIndex==0) {
			System.out.println(2);
		}else if(maxIndex==0&&minIndex==n-1) {
			System.out.println(3);
		}
		sc.close();
    }
}

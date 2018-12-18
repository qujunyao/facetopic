package com.company.test.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
	题目描述
		设有n个正整数，将他们连接成一排，组成一个最大的多位整数。
		如:n=3时，3个整数13,312,343,连成的最大整数为34331213。
		如:n=4时,4个整数7,13,4,246连接成的最大整数为7424613。
	输入描述:
		有多组测试样例，每组测试样例包含两行，第一行为一个整数N（N<=100），第二行包含N个数(每个数不超过1000，空格分开)。
	输出描述:
		每组数据输出一个表示最大的整数。
	
	示例1
	输入
		2
		12 123
		4
		7 13 4 246
	输出
		12312
		7424613
 */
public class Question_005 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			list.add(scanner.nextInt());
		}
		int[][] str = new int[2][k];
		for (int i = 0; i < k; i++) {
			int lentemp = 4;
			str[0][i] = makelenght(lentemp,list.get(i));
			str[1][i] = list.get(i);
		}
		String s = "";
		for(int is :sort(str[0])) {
			s+=str[1][is];
		}
		System.out.println(s);
		scanner.close();
	}

	private static int makelenght(int lentemp, Integer integer) {
		int nl = lentemp-(integer+"").length();
		StringBuffer sb = new StringBuffer(""+integer);
		for(int i = 0;i<nl;i++) {
			sb.append(""+integer);
		}
		int t = Integer.valueOf(sb.toString().substring(0,lentemp));
		return t;
	}

	public static int[] sort(int[] a) {
		int[][]arr = new int[a.length][2];
		for(int i = 0;i<a.length;i++) {
			arr[i][0] = a[i];
			arr[i][1] = i;
		}
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j][0] < arr[j + 1][0]) {
					int temp = arr[j][0];
					arr[j][0] = arr[j + 1][0];
					arr[j + 1][0] = temp;
					temp = arr[j][1];
					arr[j][1] = arr[j + 1][1];
					arr[j + 1][1] = temp;
				}
			}
		}
		int [] result = new int[a.length];
		for(int i = 0;i<a.length;i++) {
			result[i] = arr[i][1];
		}
		return result;
	}
}

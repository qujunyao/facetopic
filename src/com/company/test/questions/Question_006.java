package com.company.test.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
	题目描述
		春天是鲜花的季节，水仙花就是其中最迷人的代表，数学上有个水仙花数，他是这样定义的： “水仙花数”是指一个三位数，
		它的各位数字的立方和等于其本身，比如：153=1^3+5^3+3^3。 现在要求输出所有在m和n范围内的水仙花数。
	输入描述:
		输入数据有多组，每组占一行，包括两个整数m和n（100 ≤ m ≤ n ≤ 999）。
	输出描述:
		对于每个测试实例，要求输出所有在给定范围内的水仙花数，就是说，输出的水仙花数必须大于等于m,并且小于等于n，
		如果有多个，则要求从小到大排列在一行内输出，之间用一个空格隔开;
		如果给定的范围内不存在水仙花数，则输出no;
		每个测试实例的输出占一行。
		
	示例1
		输入
			100 120
			300 380
		输出
			no
			370 371
 */
public class Question_006 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
	        int m = scanner.nextInt();
	        int n = scanner.nextInt();
			List<Integer> list = new ArrayList<>();
			for (int i = m; i <= n; i++) {
				if (i == math3(i)) {
					list.add(i);
				}
			}
			if (list.size() == 0) {
				System.out.println("no");
			} else {
				for (int t = 0;t<list.size();t++) {
					if(t==0) {
						System.out.print(list.get(t));
					}else {
						System.out.print(" "+list.get(t));
					}
				}
				System.out.println();
			}
		}
		scanner.close();
	}
	private static int math3(int num) {
		int a1 = num/100;
		int a2 = num/10-(num/100)*10;
		int a3 = num%10;
		int result = a1 * a1 * a1 + a2 * a2 * a2 + a3 * a3 * a3;
		return result;
	}
}

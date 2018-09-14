package com.company.baidu.answers;

import java.util.Scanner;

public class Answer_004 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		//第一层循环输入的个数
		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			System.out.println("Case #" + (i + 1) + ":");
			//创建一个十字架行数长度的数组。
			String[] result = new String[(int) Math.pow(3, n - 1)];
			//先给第一个元素赋值“o”。
			result[0] = "o";
			//第二层循环n个数。
			for (int j = 1; j < n; j++) {
				//计算空格的个数。
				int m = (int) Math.pow(3, j - 1);
				String blank = "";
				//第三层循环累加空格
				for (int k = 0; k < m; k++) {
					blank += " ";
				}
				//第三层循环，先从第二层的位置开始画图，他是第一层图的三倍。
				for (int k = m; k < 2 * m; k++) {
					result[k] = result[k - m] + result[k - m] + result[k - m];
				}
				//第三层循环，然后从第三层的位置开始画图，他是在第一次图形的两边加上空格。
				for (int k = 2 * m; k < 3 * m; k++) {
					result[k] = blank + result[k - 2 * m] + blank;
				}
				//第三层循环，最后再画第一层的图，他是在第一次图形的两边加上空格。
				for (int k = 0; k < m; k++) {
					result[k] = blank + result[k] + blank;
				}
			}
			for (int k = 0; k < result.length; k++) {
				System.out.println(result[k]);
			}
		}
		scanner.close();
	}
}

package com.company.baidu.questions;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

/*
	 分数序列和（百度2017秋招真题）
	
										题目描述
										
	有一个分数序列 2/1,3/2,5/3,8/5,13/8,21/13,.... 求这个分数序列的前n项之和。
	
	输入
	测试数据有多组，其第一行为一个正整数k(0＜k＜=90)，表示测试数据的组数。每组测试数据为一行，为单个正整数n（0＜n＜=90）。
	样例输入
	1 
	2
	输出
	每组测试数据单独输出有一行：分数序列的和（精确到小数点后4位）。
	样例输出
	3.5000
 */
public class Question_007 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = Integer.valueOf(scanner.nextLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.valueOf(scanner.nextLine());
			double sum = 0;
			switch (n) {
			case 1:
				System.out.println(format(2, 4));
				return;
			case 2:
				System.out.println(format(3.5, 4));
				return;
			default:
				sum = 3.5;
				for (int j = 3; j <= n; j++) {
					sum += compt(j + 1) / compt(j);
				}
			}
			System.out.println(format(sum, 4));
		}

	}
	
	/**
	 * 四色五入
	 * @param v
	 * @param scale 保留小数的精度
	 * @return
	 */
	public static double format(double v, int scale) {
		DecimalFormat decimalFormat = new DecimalFormat("0.#############");
		BigDecimal b1 = new BigDecimal(decimalFormat.format(v)).setScale(scale, BigDecimal.ROUND_HALF_UP);
		return b1.doubleValue();
	}

	/**
	 * 计算第j个数是几。
	 * @param j
	 * @return
	 */
	private static double compt(int j) {
		if (j == 1) {
			return 1;
		}
		if (j == 2) {
			return 2;
		}
		double arr[] = new double[j];
		arr[0] = 1;
		arr[1] = 2;
		for (int i = 2; i < arr.length; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		return arr[arr.length - 1];
	}

}

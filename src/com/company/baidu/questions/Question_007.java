package com.company.baidu.questions;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

/*
	 �������кͣ��ٶ�2017�������⣩
	
										��Ŀ����
										
	��һ���������� 2/1,3/2,5/3,8/5,13/8,21/13,.... ������������е�ǰn��֮�͡�
	
	����
	���������ж��飬���һ��Ϊһ��������k(0��k��=90)����ʾ�������ݵ�������ÿ���������Ϊһ�У�Ϊ����������n��0��n��=90����
	��������
	1 
	2
	���
	ÿ��������ݵ��������һ�У��������еĺͣ���ȷ��С�����4λ����
	�������
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
	 * ��ɫ����
	 * @param v
	 * @param scale ����С���ľ���
	 * @return
	 */
	public static double format(double v, int scale) {
		DecimalFormat decimalFormat = new DecimalFormat("0.#############");
		BigDecimal b1 = new BigDecimal(decimalFormat.format(v)).setScale(scale, BigDecimal.ROUND_HALF_UP);
		return b1.doubleValue();
	}

	/**
	 * �����j�����Ǽ���
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

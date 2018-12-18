package com.company.test.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
	��Ŀ����
		����n�������������������ӳ�һ�ţ����һ�����Ķ�λ������
		��:n=3ʱ��3������13,312,343,���ɵ��������Ϊ34331213��
		��:n=4ʱ,4������7,13,4,246���ӳɵ��������Ϊ7424613��
	��������:
		�ж������������ÿ����������������У���һ��Ϊһ������N��N<=100�����ڶ��а���N����(ÿ����������1000���ո�ֿ�)��
	�������:
		ÿ���������һ����ʾ����������
	
	ʾ��1
	����
		2
		12 123
		4
		7 13 4 246
	���
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

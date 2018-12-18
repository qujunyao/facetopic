package com.company.test.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
	��Ŀ����
		�������ʻ��ļ��ڣ�ˮ�ɻ��������������˵Ĵ�����ѧ���и�ˮ�ɻ�����������������ģ� ��ˮ�ɻ�������ָһ����λ����
		���ĸ�λ���ֵ������͵����䱾�����磺153=1^3+5^3+3^3�� ����Ҫ�����������m��n��Χ�ڵ�ˮ�ɻ�����
	��������:
		���������ж��飬ÿ��ռһ�У�������������m��n��100 �� m �� n �� 999����
	�������:
		����ÿ������ʵ����Ҫ����������ڸ�����Χ�ڵ�ˮ�ɻ���������˵�������ˮ�ɻ���������ڵ���m,����С�ڵ���n��
		����ж������Ҫ���С����������һ���������֮����һ���ո����;
		��������ķ�Χ�ڲ�����ˮ�ɻ����������no;
		ÿ������ʵ�������ռһ�С�
		
	ʾ��1
		����
			100 120
			300 380
		���
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

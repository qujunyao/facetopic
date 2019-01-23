package com.company.test2017.questions;

import java.util.Scanner;

/*
	��Ŀ����
		����һ��ʮ���Ƶ�������number��ѡ�������ȥ��һ�������֣�ϣ������������������ɵ����������
	��������:
		����Ϊ�������ݣ���һ����������number��1 �� length(number) �� 50000���ڶ�����ϣ��ȥ����
		��������cnt 1 �� cnt < length(number)��
	�������:
		������������Ľ����
	ʾ��1
		����
		325 1
		���
		35
 */
public class Question_010 {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			String number = s.next();
			int cnt = s.nextInt();
			s.close();
			boolean flag = false;
			for (int i = 0; i < cnt; i++) {
				flag = false;
				for (int j = 1; j < number.length(); j++) {
					char a = number.charAt(j - 1);
					char b = number.charAt(j);
					if (a < b) {
						number = sub(number, j - 1);
						flag = true;
						break;
					}
				}
				if(!flag) {
					number = number.substring(0,number.length()-1);
				}
			}
			System.out.println(number);
		} catch (Exception e) {
			System.out.println(1);
		}
	}

	private static String sub(String number, int j) {
		String a = number.substring(0, j);
		String b = number.substring(j + 1);
		return a + b;
	}

}

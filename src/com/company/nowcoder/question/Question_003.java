package com.company.nowcoder.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
	��Ŀ����
	��������[-2��31�η�, 2��31�η�]�ڵ�3������A��B��C�����ж�A+B�Ƿ����C��
	
	��������:
	�����1�и���������T(<=10)���ǲ��������ĸ�����������T�����������ÿ��ռһ�У�˳�����A��B��C���������Կո�ָ���
	
	
	�������:
	��ÿ�������������һ���������Case #X: true�����A+B>C�����������Case #X: false��������X�ǲ��������ı�ţ���1��ʼ����
	
	��������:
4
1 2 3
2 3 4
2147483647 0 2147483646
0 -2147483648 -2147483647
	
	�������:
	Case #1: false
	
	Case #2: true
	
	Case #3: true
	
	Case #4: false
 */
public class Question_003 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = Integer.valueOf(scanner.nextLine());
		List<Long[]> list = new ArrayList<>();
		for (int i = 0; i < t; i++) {
			Long a = Long.valueOf(scanner.next());
			Long b = Long.valueOf(scanner.next());
			Long c = Long.valueOf(scanner.next());
			list.add(new Long[] { a, b, c });
		}
		for (int i = 0; i < list.size(); i++) {
			Long[] n = list.get(i);
			System.out.println("Case #" + (i + 1) + ": " + (n[0] + n[1] > n[2]));
		}
	}
}

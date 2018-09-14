package com.company.baidu.answers;

import java.util.*;

public class Answer_003 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String s = sc.next();
//		sc.close();
//		Set<String> set = new HashSet<String>();
//		String temp = "";
//
//		for (int i = 0; i < s.length(); i++) {
//			if (i == 0) {
//				temp = s.charAt(i) + "";
//				set.add(temp);
//			} else {
//				if (s.charAt(i) == s.charAt(i - 1)) {
//					temp = temp + String.valueOf(s.charAt(i));
//					set.add(temp);
//				} else {
//					temp = String.valueOf(s.charAt(i));
//					set.add(temp);
//				}
//			}
//		}
//		System.out.print(set.size());
//	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.next();
			if (s == null || s.length() == 0) {
				System.out.println(0);
				continue;
			}
			//��ȡ��һ���ַ���
			char c = s.charAt(0);
			//�ظ��ַ�������
			int cnt = 0;
			//Ҫ���ص��ܹ����еĸ�����
			int res = 0;
			//��������Ƕ�Ӧ�ַ���ascii������顣
			int[] num = new int[256];
			//���ַ���ת�����ַ����顣ѭ��ÿ���ַ���
			for (char ch : s.toCharArray()) {
				if (ch == c) {
					//�Ƚ���һ���ַ��͵�ǰ�ַ��Ƿ���ȣ�������������һ��
					cnt++;
				} else {
					/*
					 * ����ȣ����ж�num�����е�ǰ�ַ�λ�õ�ֵ���������õ�ascii��ķ����ԣ�a��Ӧascii����97�������ж�sum[97]��ֵ��cnt�������Ĵ�С��
					 * ��cnt�������Ĵ�С�����ظ��ַ��ĳ��ȣ������ߵ����ֵ�����뵽sum�����У�������һ���жϡ�֪��ѭ���������ҵ���󳤶ȵ�����
					 * �������������ϵĸ�����
					 */
					if (num[c] < cnt) {
						//�ܸ����ȼ����µĳ���
						res += cnt;
						//Ȼ��ԭ���ĳ��ȼ����������Ͱ����³��ȼ��뵽�ܸ�������
						res -= num[c];
						num[c] = cnt;
					}
					//Ȼ�����ü�����
					cnt = 1;
					//����Ҫ�Ƚϵ��ַ���������һ��ѭ��
					c = ch;
				}
			}
			//�������һ�Σ���Ϊ�����һ��ѭ��û�����Ƚϳ��ȵĲ���������Ҫ�ڱȽ�һ�Σ���ֹ�����ַ�������Ŀ����ԡ�
			if (num[c] < cnt) {
				res += cnt;
				res -= num[c];
				num[c] = cnt;
			}
			System.out.println(res);
		}
	}
}

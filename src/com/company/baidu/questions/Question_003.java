package com.company.baidu.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/*
								�ȶ������Ӵ����ٶ�2017�������⣩
	
										��Ŀ����
										
	�ȶ����յ���һ��ֻ��Сд��ĸ���ַ���S������S���Ӵ���������Ȥ��S���Ӵ�ΪS������������һ�Ρ������֣�һЩ�Ӵ�ֻ��һ����ĸ���ɣ�����֪����S��һ���ж������������Ӵ���
	�����ڴ���aaabbaa���У��ȶ������ҵ��Ӵ��С�a��,��aa��,��aaa��,��b��,��bb�����֡�
	
	������ֻ�����Ӵ�����������ͬ���Ӵ��ڶ��λ�ó���ֻ��һ�Σ�
 */
public class Question_003 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String sb = scanner.nextLine();
		scanner.close();
		Map<String, String> map = new HashMap<>();
		map.put(String.valueOf(sb.charAt(0)), String.valueOf(sb.charAt(0)));
		boolean f = false;
		StringBuffer temp = new StringBuffer();
		for (int i = 1; i < sb.length(); i++) {
			if (map.containsKey(String.valueOf(sb.charAt(i)))) {
				if (sb.charAt(i) == sb.charAt(i - 1)) {
					f = true;
				} else {
					f = false;
				}
				if (temp.length() == 0 && f) {
					temp.append("" + sb.charAt(i) + sb.charAt(i));
					continue;
				}
				if (f) {
					temp.append("" + sb.charAt(i));
				} else {
					if (temp.length() > 0 && temp.length() > map.get(String.valueOf(temp.charAt(0))).length()) {
						map.put(String.valueOf(temp.charAt(0)), temp.toString());
					}
					temp = new StringBuffer();
				}
			} else {
				map.put(String.valueOf(sb.charAt(i)), String.valueOf(sb.charAt(i)));
				f = false;
				if (temp.length() > 0) {
					if (temp.length() > map.get(String.valueOf(temp.charAt(0))).length()) {
						map.put(String.valueOf(temp.charAt(0)), temp.toString());
					}
					temp = new StringBuffer();
				}
			}
		}
		if (temp.length() > 0) {
			if (temp.length() > map.get(String.valueOf(temp.charAt(0))).length()) {
				map.put(String.valueOf(temp.charAt(0)), temp.toString());
			}
			temp = new StringBuffer();
		}
		int sum = 0;
		for (Entry<String, String> entry : map.entrySet()) {
			sum += entry.getValue().length();
		}
		System.out.println(sum);
	}
}

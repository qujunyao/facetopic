package com.company.test2017.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
	��Ŀ����
		����һ��Ӣ���ַ���,��дһ�δ����ҳ�����ַ��������ȳ������ε��Ǹ�Ӣ���ַ�(��Ҫ���ִ�Сд)��
	��������:
		��������һ���ַ�����������ĸ,���ֵȡ�
	�������:
		������ȳ������ε��Ǹ�Ӣ���ַ�
	ʾ��1
		����
		Have you ever gone shopping and
		���
		e
 */
public class Question_011 {
	public static void main(String[] args) {
		Scanner  scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		scanner.close();
		Map<String, Integer> map = new HashMap<String, Integer>();
		char []arr = str.toCharArray();
		for(int i = 0;i<arr.length;i++) {
			if(arr[i]<'A'||arr[i]>'z'||(arr[i]>'Z'&&arr[i]<'a')){
				continue;
			}
			if(" ".equals(arr[i]+"")) {
				continue;
			}else {
				if(map.containsKey(arr[i]+"")) {
					if(map.get(arr[i]+"") >=2) {
						System.out.println(arr[i]);
						break;
					}else {
						map.put(arr[i]+"", map.get(arr[i]+"")+1);
					}
				}else {
					map.put(arr[i]+"", 1);
				}
			}
		}
	}
}

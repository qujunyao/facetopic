package com.company.test2017.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
	题目描述
		给定一个英文字符串,请写一段代码找出这个字符串中首先出现三次的那个英文字符(需要区分大小写)。
	输入描述:
		输入数据一个字符串，包括字母,数字等。
	输出描述:
		输出首先出现三次的那个英文字符
	示例1
		输入
		Have you ever gone shopping and
		输出
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

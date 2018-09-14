package com.company.baidu.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/*
								度度熊找子串（百度2017秋招真题）
	
										题目描述
										
	度度熊收到了一个只有小写字母的字符串S，他对S的子串产生了兴趣，S的子串为S中任意连续的一段。他发现，一些子串只由一种字母构成，他想知道在S中一共有多少种这样的子串。
	例如在串”aaabbaa”中，度度熊想找的子串有”a”,”aa”,”aaa”,”b”,”bb”五种。
	
	（本题只考虑子串的种数，相同的子串在多个位置出现只算一次）
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

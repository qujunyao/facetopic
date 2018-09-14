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
			//获取第一个字符。
			char c = s.charAt(0);
			//重复字符计数器
			int cnt = 0;
			//要返回的总共所有的个数。
			int res = 0;
			//这个数组是对应字符的ascii码的数组。
			int[] num = new int[256];
			//将字符串转换成字符数组。循环每个字符。
			for (char ch : s.toCharArray()) {
				if (ch == c) {
					//比较上一个字符和当前字符是否相等，相等则计数器加一。
					cnt++;
				} else {
					/*
					 * 不相等，则判断num数组中当前字符位置的值（这里利用的ascii码的方便性，a对应ascii码是97，所以判断sum[97]的值和cnt计数器的大小，
					 * 而cnt计数器的大小就是重复字符的长度，把两者的最大值，存入到sum数组中，用于下一次判断。知道循环结束，找到最大长度的数，
					 * 这个就是所有组合的个数）
					 */
					if (num[c] < cnt) {
						//总个数先加最新的长度
						res += cnt;
						//然后将原来的长度减掉，这样就把最新长度加入到总个数中了
						res -= num[c];
						num[c] = cnt;
					}
					//然后重置计数器
					cnt = 1;
					//重置要比较的字符。进入下一次循环
					c = ch;
				}
			}
			//最后在做一次，因为，最后一次循环没有做比较长度的操作，所以要在比较一次，防止最后的字符串是最长的可能性。
			if (num[c] < cnt) {
				res += cnt;
				res -= num[c];
				num[c] = cnt;
			}
			System.out.println(res);
		}
	}
}

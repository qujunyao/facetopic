package com.company.test2017.answers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Answer_005 {

	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().toString());
		String[] str = bf.readLine().toString().split(" ");
		mySort(str, 0, str.length - 1);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++) {
			sb.append(str[i]);
		}
		System.out.println(sb.toString());

	}

	public static void mySort(String[] str, int start, int end) {
		if (start < 0 || start > end || end > str.length - 1)
			return;
		String cen = str[start];
		int i = start;
		int j = end;
		while (i < j) {

			while (i < j) {
				if (comp(str[j], cen)) {
					str[i] = str[j];
					i++;
					break;
				} else {
					j--;
				}
			}

			while (i < j) {
				if (comp(cen, str[i])) {
					str[j] = str[i];
					j--;
					break;
				} else {
					i++;
				}
			}
		}
		str[i] = cen;
		mySort(str, start, i - 1);
		mySort(str, i + 1, end);

	}

	public static boolean comp(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		int min = len1 > len2 ? len2 : len1;
		for (int i = 0; i < min; i++) {
			char c1 = str1.charAt(i);
			char c2 = str2.charAt(i);
			if (c1 < c2) {
				return false;
			} else if (c1 > c2) {
				return true;
			}
		}
		if (min == len2 && min < len1) {
			if (str1.charAt(0) > str1.charAt(min)) {
				return false;
			} else if (str1.charAt(0) == str1.charAt(min)) {
				if (min + 1 <= len1 - 1) {
					if (str1.charAt(0) > str1.charAt(min + 1)) {
						return false;
					} else {
						return true;
					}
				}
			} else {
				return true;
			}
		} else if (min == len1 && min < len2) {
			if (str2.charAt(0) > str2.charAt(min)) {
				return true;
			} else if (str2.charAt(0) == str2.charAt(min)) {
				if (min + 1 <= len2 - 1) {
					if (str2.charAt(0) > str2.charAt(min + 1)) {
						return true;
					} else {
						return false;
					}
				}

			} else {
				return false;
			}
		}
		return true;

	}

}

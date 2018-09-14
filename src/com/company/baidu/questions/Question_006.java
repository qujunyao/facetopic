package com.company.baidu.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/*
	敏感词（百度2017秋招真题）
	
										题目描述
										
	大部分论坛、网站等，为了方便管理，都进行了关于敏感词的设定。
	在多数网站，敏感词一般是指带有敏感政治倾向、暴力倾向、不健康色彩的词或不文明语，也有一些网站根据自身实际情况，设定一些只适用于本网站的特殊敏感词。
	比如，当你发贴的时候带有某些事先设定的词时，这个贴是不能发出的。或者这个词被自动替换为星号 (*)，或者说是被和谐掉了。请注意敏感词只有小写字母，
	文本如果中的大写字母当做小写字母处理，出现敏感单词，即使作为子串出现也要被和谐，多个子串重叠他们都要被和谐。
	
	例如当敏感词是gre，eat 是
	Your English is Great.
	将被和谐成
	Your English is *****.
	
	请编程，输入给定的文本和关键字，将所有被和谐的部分都打上星号 (*)
	
	输入
	输入的第一行包含一个整数 n，表示敏感词的总数。
	接下来的 n 行，每行包含一个长度不超过 100 的敏感词，单词不区分大小写。
	接下来的一行包含一段长度不超过 10000的字符串表示待处理的文本。
	
	样例输入
	4
	revolution
	greatwall
	democracy
	science
	Cross the greatwall, we can reach every corner of the world.
	
	输出
	输出一行，表示和谐过后的文本。
	样例输出
	Cross the *********, we can reach every corner of the world.
	
 */
public class Question_006 {
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Integer t = scanner.nextInt();
		List<String> list = new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		while (scanner.hasNextLine() && t-- > 0) {
			String s = scanner.next();
			if (!map.containsKey(s)) {
				String value = "";
				for (int i = 0; i < s.length(); i++) {
					value += "*";
				}
				map.put(s, value);
			}
		}
		String s = "";
		if (scanner.hasNext()) {
			s = scanner.nextLine();
			s = scanner.nextLine();
		}
		String[] arr = s.split(" ");
		for (int j = 0; j < arr.length; j++) {
			List<String> temp = new ArrayList<>();
			for (Entry<String, String> e : map.entrySet()) {
				if (arr[j].toLowerCase().contains(e.getKey())) {
					if (arr[j].contains(e.getKey())) {
						temp.add(arr[j].replaceAll(e.getKey(), e.getValue()));
					}else {
						temp.add(arr[j].toLowerCase().replaceAll(e.getKey(), e.getValue()));
					}
				}
			}
			if (temp.size() > 0) {
				arr[j] = union(temp);
			}
		}
		String s1 = "";
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				s1 += arr[i];
			} else {
				s1 += arr[i] + " ";
			}
		}
		System.out.println(s1);
	}
	
	private static String union(List<String> temp) {
		String s = temp.get(0);
		Map<Integer, String> map = compter(s);
		String[] as = new String[s.length()];
		for (int i = 0; i < as.length; i++) {
			as[i] = "*";
		}
		for (int i = 1; i < temp.size(); i++) {
			char[] arr = temp.get(i).toCharArray();
			Set<Integer> st = map.keySet();
			Iterator<Integer> iterator = st.iterator();
			while (iterator.hasNext()) {
				Integer integer = iterator.next();
				if (arr[integer] == '*') {
					iterator.remove();
				}
			}
		}
		for (Entry<Integer, String> e : map.entrySet()) {
			as[e.getKey()] = e.getValue();
		}
		String result = "";
		for (int i = 0; i < as.length; i++) {
			result += as[i];
		}
		return result;
	}

	private static Map<Integer, String> compter(String s) {
		Map<Integer, String> map = new HashMap<>();
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != '*') {
				map.put(i, arr[i] + "");
			}
		}
		return map;
	}
}

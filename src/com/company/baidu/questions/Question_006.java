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
	���дʣ��ٶ�2017�������⣩
	
										��Ŀ����
										
	�󲿷���̳����վ�ȣ�Ϊ�˷�������������˹������дʵ��趨��
	�ڶ�����վ�����д�һ����ָ���������������򡢱������򡢲�����ɫ�ʵĴʻ������Ҳ��һЩ��վ��������ʵ��������趨һЩֻ�����ڱ���վ���������дʡ�
	���磬���㷢����ʱ�����ĳЩ�����趨�Ĵ�ʱ��������ǲ��ܷ����ġ���������ʱ��Զ��滻Ϊ�Ǻ� (*)������˵�Ǳ���г���ˡ���ע�����д�ֻ��Сд��ĸ��
	�ı�����еĴ�д��ĸ����Сд��ĸ�����������е��ʣ���ʹ��Ϊ�Ӵ�����ҲҪ����г������Ӵ��ص����Ƕ�Ҫ����г��
	
	���統���д���gre��eat ��
	Your English is Great.
	������г��
	Your English is *****.
	
	���̣�����������ı��͹ؼ��֣������б���г�Ĳ��ֶ������Ǻ� (*)
	
	����
	����ĵ�һ�а���һ������ n����ʾ���дʵ�������
	�������� n �У�ÿ�а���һ�����Ȳ����� 100 �����дʣ����ʲ����ִ�Сд��
	��������һ�а���һ�γ��Ȳ����� 10000���ַ�����ʾ��������ı���
	
	��������
	4
	revolution
	greatwall
	democracy
	science
	Cross the greatwall, we can reach every corner of the world.
	
	���
	���һ�У���ʾ��г������ı���
	�������
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

package com.company.nowcoder.question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
	��Ŀ����
	
	��һ��n*m�ĵأ�ÿ���Ҫô�����Ӳ�(��'W'��ʾ)��Ҫô�ǿյ�(��'G'��ʾ)��������һ����վ��(1,1)������(1,m),�����԰��������ַ�ʽ�ƶ���
	
	1�����泯�ķ����ƶ�һ�񣬺ķ�1��λʱ��
	
	2�������ƶ�һ�񣬲���ת�泯�ķ���(�ұ��������)���ķ�1��λʱ��
	
	��������֪��������е��Ӳ�������Ҫ���ٵ�λʱ��(������Ӳ�֮���÷���(1,1))
	��������:
	��һ��n,m
	������n��ÿ��һ���ַ�����ʾ����
	n,m<=150
	�������:
	һ��һ��������ʾ�𰸡�
	
	����

	4 5
GGGGWGG
GGGGWGG
GGGGGGG
GGGGGWG
8
	���
	
GGGGWGGGGG
GGGGGGGGGW
WGGGWGGGGG
GGGGGGGGGW
GGGGGGGGGW
21

������
GGGGWGGGGG
GGGGGGGGGW
WGGGWGGGGG
24

ż����
GGGGGGGGGG
GGGGGWGGGW
GGGGGWGGGW
19


GWGG
GGWG
GWGG
GGWG
7

WGGGG
GGGGG
GWGWG
GGGGG
5

WGGGG
GGGGG
GGGGG
GWGWG
GGGGG
8

WWWWW
WWWWW
WWWWW
WWWWW
19

WGGGG
GGGGG
GGGGG
GGGGG
0

GGGGG
GGGWG
GGGGG
GWGGG
8

GGGGG
GGGGG
GGGGG
GWGGG
4


WGGGGWG
GGGWWGG
GGGGGGG
GGWGGGG
GGGGGGG
11

WGGGGWG
GGGWWGG
GGGGGGG
GGWGGGW
GWGGGGG
19

 */
public class Question_001 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		Map<Integer, List<String>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			List<String> list = new ArrayList<>();
			list.add(scanner.next());
			map.put(i, list);
		}
		scanner.close();
		// System.out.println(list);
		int sum = 0;
		int[] t = { 1, 0 };
		for (int i = 0; i < n;) {
			List<String> list = map.get(i);
			if (list == null) {
				sum++;
				continue;
			}
			List<String> list2 = new ArrayList<>();
			int index = 0;
			int ts = 0;
			for (int j = i + 1; j < n; j++) {
				list2 = map.get(j);
				if (!list2.get(0).contains("W")) {
					int temp = 1;
					if (j == n - 1) {
						index = j + 1;
						ts = 0;
						temp = 0;
						list2.set(0, "");
					}
					ts += temp;
					continue;
				}
				index = j;
				break;
			}
			sum += ts;
			t = comp2(i == 0 ? 1 : t[0], list.get(0), i == n - 1 ? "" : list2.get(0), i % 2 == 0, (index) % 2 == 0);
			if (index == 0) {
				i++;
			} else {
				i = index;
			}
			sum += t[1];
			if (i < n) {
				sum++;
			}
		}
		System.out.println(sum);
	}

	private static int[] comp2(int i, String string, String next, boolean b, boolean ne) {
		int[] result = new int[2];
		int start = string.indexOf('W') + 1;
		int end = string.lastIndexOf('W') + 1;
		int start2 = next.indexOf('W') + 1;
		int end2 = next.lastIndexOf('W') + 1;
		if ("".equals(next)) {
			end2 = end;
			start2 = start;
			ne = !b;
		}
		if (b) {// ������
			if (ne) {
				if (end > start2) {
					result[0] = start2;
					result[1] = end * 2 - i - start2;
				} else {
					result[0] = end;
					result[1] = end - i;
				}
			} else {
				if (end < end2) {
					result[0] = end2;
					result[1] = end2 - i;
				} else {
					result[0] = end;
					result[1] = end - i;
				}
			}
		} else {// ż����
			if (!ne) {
				if (start < end2) {
					result[0] = end2;
					result[1] = i - start + end2 - start;
				} else {
					result[0] = start;
					result[1] = i - start;
				}
			} else {
				if (start > start2) {
					result[0] = start2;
					result[1] = i - start2;
				} else {
					result[0] = start;
					result[1] = i - start;
				}
			}
		}
		 System.out.println("��ʼλ�ã�" + i);
		 System.out.println("��ֹλ�ã�" + result[0]);
		 System.out.println("������" + result[1]);
		return result;
	}
}

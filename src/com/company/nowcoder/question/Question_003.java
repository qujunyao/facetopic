package com.company.nowcoder.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
	题目描述
	给定区间[-2的31次方, 2的31次方]内的3个整数A、B和C，请判断A+B是否大于C。
	
	输入描述:
	输入第1行给出正整数T(<=10)，是测试用例的个数。随后给出T组测试用例，每组占一行，顺序给出A、B和C。整数间以空格分隔。
	
	
	输出描述:
	对每组测试用例，在一行中输出“Case #X: true”如果A+B>C，否则输出“Case #X: false”，其中X是测试用例的编号（从1开始）。
	
	输入例子:
4
1 2 3
2 3 4
2147483647 0 2147483646
0 -2147483648 -2147483647
	
	输出例子:
	Case #1: false
	
	Case #2: true
	
	Case #3: true
	
	Case #4: false
 */
public class Question_003 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = Integer.valueOf(scanner.nextLine());
		List<Long[]> list = new ArrayList<>();
		for (int i = 0; i < t; i++) {
			Long a = Long.valueOf(scanner.next());
			Long b = Long.valueOf(scanner.next());
			Long c = Long.valueOf(scanner.next());
			list.add(new Long[] { a, b, c });
		}
		for (int i = 0; i < list.size(); i++) {
			Long[] n = list.get(i);
			System.out.println("Case #" + (i + 1) + ": " + (n[0] + n[1] > n[2]));
		}
	}
}

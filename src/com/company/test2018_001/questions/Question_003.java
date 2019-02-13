package com.company.test2018_001.questions;

import java.util.Scanner;

/*
	题目描述
		受到小人的设计，主人公暮小云落入�?个名为神凛幻域的奇特地方。对于迷失在这里的人而言这个空间没有绝对的方向，
		想要脱离这个地方就必须向前走出n步�?�由于在这个空间内没有方向的概念，无论何时向任何方向迈出�?步都是等效的
		（哪怕你是原地转圈，只要走出N步即可脱离幻境）。不过，由于空间壁垒的原因，不同时刻向不同方向走�?耗费的体
		力不同�?�现在已知不同时刻向某个方向跨出�?步所�?耗费的体力，请你告诉暮小云�?�么走最省体力，以及�?要�?�费的最
		小体力�??
	
	输入描述:
		有多个输入样例，输入的第�?行是样例个数T(1≤T�?50)。每个样例的第一行是�?个整数n(1≤n�?100000)。紧接着�?
		四行，依次表示东南西北四个方向的体力耗费情况，每行n个数字，分别表示第n步向该方向走�?要花费的体力�?
		xi(0≤xi�?1000000)。某�?步的多个方向体力值均为最小�?�时按照东南西北的顺序取优先方向�?
		
	输出描述:
		第一行输出需要的�?小体力�?�，第二行输出行走方案分别用符号ESWN表示东南西北�?
		
	示例1
		输入
			1
			15
			54 66 60 24 100 24 2 67 74 80 55 61 1 51 78
			6 52 18 100 95 10 14 15 55 1 8 70 33 2 63
			44 24 28 43 52 8 18 58 16 93 67 80 16 33 20
			79 2 47 53 88 88 25 59 89 45 89 45 3 72 52
		输出
			220
			SNSEWWESWSSNESW
 */
public class Question_003 {
	public static void main(String[] args) {
		Scanner  scanner = new Scanner(System.in);
		int num = Integer.valueOf(scanner.nextLine());
		while (num-->0) {
			String fang = "";
			int sum = 0;
			int nt = Integer.valueOf(scanner.nextLine());
			String line1 = scanner.nextLine();
			String line2 = scanner.nextLine();
			String line3 = scanner.nextLine();
			String line4 = scanner.nextLine();
			String[]e = line1.split(" ");
			String[]s = line2.split(" ");
			String[]w = line3.split(" ");
			String[]n = line4.split(" ");
			for(int i = 0;i<nt;i++) {
				String[] result = comp(Integer.valueOf(e[i]),Integer.valueOf(s[i]),Integer.valueOf(w[i]),Integer.valueOf(n[i]));
				fang = fang + result[0];
				sum += Integer.valueOf(result[1]);
			}
			System.out.println(sum);
			System.out.println(fang);
		}
		scanner.close();
	}

	private static String[] comp(int e, int s, int w, int n) {
		if(e>s) {
			if(s>w) {
				if(w>n) {
					return new String[] {"N",n+""};
				}else {
					return new String[] {"W",w+""};
				}
			}else {
				if(s>n) {
					return new String[] {"N",n+""};
				}else {
					return new String[] {"S",s+""};
				}
			}
		}else {
			if(e>w) {
				if(w>n) {
					return new String[] {"N",n+""};
				}else {
					return new String[] {"W",w+""};
				}
			}else {
				if(e>n) {
					return new String[] {"N",n+""};
				}else {
					return new String[] {"E",e+""};
				}
			}
		}
	}
}

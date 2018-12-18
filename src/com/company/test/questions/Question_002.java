package com.company.test.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 	题目描述
		继MIUI8推出手机分身功能之后，MIUI9计划推出一个电话号码分身的功能：首先将电话号码中的每个数字加上8取个位，
		然后使用对应的大写字母代替 （"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"），
		 然后随机打乱这些字母，所生成的字符串即为电话号码对应的分身。
	输入描述:
		第一行是一个整数T（1 ≤ T ≤ 100)表示测试样例数；接下来T行，每行给定一个分身后的电话号码的分身（长度在3到10000之间）。
	输出描述:
		输出T行，分别对应输入中每行字符串对应的分身前的最小电话号码（允许前导0）。
		
	示例1
		输入
			4
			EIGHT
			ZEROTWOONE
			OHWETENRTEO
			OHEWTIEGTHENRTEO
		输出
			0
			234
			345
			0345
 */
public class Question_002 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		List<String> list = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			String n = scanner.next();
			list.add(checkString(n));
		}
		for(String m:list) {
			System.out.println(m);
		}
		scanner.close();
	}

	private static String checkString(String n) {
		char[] arr = n.toCharArray();
		int numW = 0,numG = 0,numZ = 0,numU = 0,numX = 0,numH = 0,numF = 0,numO = 0,numS = 0,numI = 0;
		for(int i = 0;i<arr.length;i++) {
			switch (arr[i]) {
			case 'W':				numW++;				break;
			case 'G':				numG++;				break;
			case 'Z':				numZ++;				break;
			case 'U':				numU++;				break;
			case 'X':				numX++;				break;
			case 'H':				numH++;				break;
			case 'F':				numF++;				break;
			case 'O':				numO++;				break;
			case 'S':				numS++;				break;
			case 'I':				numI++;				break;
			}
		}	
		StringBuffer result = new StringBuffer();
		for(int i = 0;i<numG;i++) {
			result.append("0");
		}
		for(int i = 0;i<numI-numG-numX-numF+numU;i++) {
			result.append("1");
		}
		for(int i = 0;i<numZ;i++) {
			result.append("2");
		}
		for(int i = 0;i<numO-numW-numZ-numU;i++) {
			result.append("3");
		}
		for(int i = 0;i<numW;i++) {
			result.append("4");
		}
		for(int i = 0;i<numH-numG;i++) {
			result.append("5");
		}
		for(int i = 0;i<numU;i++) {
			result.append("6");
		}
		for(int i = 0;i<numF-numU;i++) {
			result.append("7");
		}
		for(int i = 0;i<numX;i++) {
			result.append("8");
		}
		for(int i = 0;i<numS-numX;i++) {
			result.append("9");
		}
		
		return result.toString();
	}

}

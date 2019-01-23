package com.company.test2018.questions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
	题目描述
	小明同学最近开发了一个网站，在用户注册账户的时候，需要设置账户的密码，为了加强账户的安全性，小明对密码强度有一定要求：
	
	1. 密码只能由大写字母，小写字母，数字构成；
	
	2. 密码不能以数字开头；
	
	3. 密码中至少出现大写字母，小写字母和数字这三种字符类型中的两种；
	
	4. 密码长度至少为8
	
	现在小明受到了n个密码，他想请你写程序判断这些密码中哪些是合适的，哪些是不合法的。
	
	输入描述:
		输入一个数n，接下来有n(n≤100)行，每行一个字符串，表示一个密码，输入保证字符串中只出现大写字母，小写字母和数字，字符串长度不超过100。
	输出描述:
		输入n行，如果密码合法，输出YES，不合法输出NO
		
	示例1
		输入
			1
			CdKfIfsiBgohWsydFYlMVRrGUpMALbmygeXdNpTmWkfyiZIKPtiflcgppuR
		输出
			YES
 */
public class Question_001 {
	public static void main(String[] args) {
		Scanner  scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		for(int i = 0;i<num;i++) {
			String str = scanner.next();
			System.out.println(checkPWD(str));
		}
		scanner.close();
	}

	private static String checkPWD(String str) {
		String regEx1 = "^[A-Za-z]{1}[a-zA-Z0-9]{7,}$";
		String regEx2 = "^([a-z]+)$";
		String regEx3 = "^([A-Z]+)$";
		Pattern pattern = Pattern.compile(regEx1);
		Pattern pattern2 = Pattern.compile(regEx2);
		Pattern pattern3 = Pattern.compile(regEx3);
		Matcher matcher = pattern.matcher(str);
		boolean rs = matcher.matches();
		if(rs){
			matcher = pattern2.matcher(str);
			boolean a = matcher.matches();
			matcher = pattern3.matcher(str);
			boolean b = matcher.matches();
			if(a||b) {
				return "NO";
			}else {
				return "YES";
			}
		}else {
			return "NO";
		}
	}
}

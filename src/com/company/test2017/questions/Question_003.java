package com.company.test2017.questions;

import java.util.Scanner;

/*
	题目描述
		给定一个句子（只包含字母和空格）， 将句子中的单词位置反转，单词用空格分割, 单词之间只有一个空格，前后没有空格。 
		比如： （1） “hello xiao mi”-> “mi xiao hello”
	
	输入描述:
		输入数据有多组，每组占一行，包含一个句子(句子长度小于1000个字符)
	输出描述:
		对于每个测试示例，要求输出句子中单词反转后形成的句子
	
	示例1
	输入
		hello xiao mi
	输出
		mi xiao h
 */
public class Question_003 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			String str = scanner.nextLine();
			String [] arr = str.split(" ");
			StringBuffer sb = new StringBuffer();
			for(int i = arr.length-1;i>=0;i--) {
				sb.append(arr[i]+" ");
			}
			str = sb.toString();
			str = str.substring(0,str.length()-1);
			System.out.println(str);
		}
		scanner.close();
	}

}

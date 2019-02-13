package com.company.test2018_001.questions;

import java.util.*;

/*
	题目描述
		在日常书面表达中，我们经常会碰到很长的单词，比如"localization"�?"internationalization"等�?�为了书写方便，
		我们会将太长的单词进行缩写�?�这里进行如下定义：如果�?个单词包含的字符个数超过10则我们认为它是一个长单词。所有的
		长单词都�?要进行缩写，缩写的方法是先写下这个单词的首尾字符，然后再在首尾字符中间写上这个单词去掉首尾字符后�?包含
		的字符个数�?�比�?"localization"缩写后得到的�?"l10n"�?"internationalization"缩写后得到的�?"i18n"。现给出
		n个单词，将其中的长单词进行缩写，其余的按原样输出�?	
	输入描述:
		第一行包含要给整数n�?1≤n�?100
		接下来n行每行包含一个由小写英文字符构成的字符串，字符串长度不超�?100�?
	输出描述:
		按顺序输出处理后的每个单词�??
	
	示例1
		输入
			4
			word
			localization
			internationalization
			pneumonoultramicroscopicsilicovolcanoconiosis
		输出
			word
			l10n
			i18n
			p43s
 */
public class Question_007 {
	public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0;i<n;i++) {
        	String s = sc.next();
        	String num = "";
        	if(s.length()>=10) {
        		num = s.substring(0,1)+(s.length()-2)+""+s.substring(s.length()-1);
        	}else {
        		num = s;
        	}
        	System.out.println(num);
        }
        sc.close();
    }
}

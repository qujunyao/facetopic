package com.company.test2017.questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
	题目描述
		有一条彩色宝石项链，是由很多种不同的宝石组成的，包括红宝石，蓝宝石，钻石，翡翠，珍珠等。
		有一天国王把项链赏赐给了一个学者，并跟他说，你可以带走这条项链，但是王后很喜欢红宝石，
		蓝宝石，紫水晶，翡翠和钻石这五种，我要你从项链中截取连续的一小段还给我，这一段中必须包
		含所有的这五种宝石，剩下的部分你可以带走。如果无法找到则一个也无法带走。请帮助学者找出如
		何切分项链才能够拿到最多的宝石。
	输入描述:
		我们用每种字符代表一种宝石，A表示红宝石，B表示蓝宝石，C代表紫水晶，D代表翡翠，E代表钻石，
		F代表玉石，G代表玻璃等等，我们用一个全部为大写字母的字符序列表示项链的宝石序列，注意项链
		是首尾相接的。每行代表一种情况。
	输出描述:
		输出学者能够拿到的最多的宝石数量。每行一个
	示例1
		输入
		ABCYDYE
		ATTMBQECPD
		
		输出
		1
		3
 */
public class Question_009 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null){
        	str = str+str;
        	char[]temp = str.toCharArray();
        	int[] index= {-1,-1,-1,-1,-1};
        	int maxlen = Integer.MAX_VALUE;
        	for(int i = 0;i<temp.length;i++) {
        		if(temp[i]<='E'&&temp[i]>='A') {
        			index[temp[i]-'A']=i;
        			if(isFull(index)) {
        				int len = compet(index);
        				if(maxlen>len) {
        					maxlen = len;
        				}
        			}
        		}
        	}
        	System.out.println((temp.length/2)-maxlen);
        }
	}

	private static int compet(int[] index) {
		int minlen = Integer.MAX_VALUE;
		int maxlen = Integer.MIN_VALUE;
		for(int i=0;i<index.length;i++) {
			if(index[i]>maxlen) {
				maxlen = index[i];
			}
			if(index[i]<minlen) {
				minlen = index[i];
			}
		}
		return maxlen-minlen+1;
	}

	private static boolean isFull(int[] index) {
		for(int i = 0;i<index.length;i++) {
			if(index[i]<0) {
				return false;
			}
		}
		return true;
	}
	
}

package com.company.baidu.questions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
	 						编号转换（百度2016实习生真题）
	 
									题目描述
									
	小B最近对电子表格产生了浓厚的兴趣，她觉得电子表格很神奇，功能远比她想象的强大。她正在研究的是单元格的坐标编号，她发现表格单元一般是按列编号的，第1列编号为A，第2列为B，以此类推，
	第26列为Z。之后是两位字符编号的，第27列编号为AA，第28列为AB，第52列编号为AZ。之后则是三位、四位、五位……字母编号的，规则类似。
	表格单元所在的行则是按数值从1开始编号的，表格单元名称则是其列编号和行编号的组合，如单元格BB22代表的单元格为54列中第22行的单元格。
	小B感兴趣的是，编号系统有时也可以采用RxCy的规则，其中x和y为数值，表示单元格位于第x行的有第y列。上述例子中的单元格采用这种编码体系时的名称为R22C54。
	小B希望快速实现两种表示之间的转换，请你帮忙设计程序将一种方式表示的坐标转换为另一种方式。
 */
public class Question_002 {
	public static String[] cha = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	public static Map<String, Integer> map = new HashMap<>();
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		for(int i = 0;i<cha.length;i++) {
			map.put(cha[i], i+1);
		}
		Scanner scanner = new Scanner(System.in);
		Integer t = Integer.valueOf(scanner.nextLine());
		List<String> list = new LinkedList<>();
		for(int i = 0;i<t;i++) {
			list.add(scanner.nextLine());
		}
		if(list==null||list.size()<=0) {
			return;
		}
		comp(list);
	}

	
	private static void comp(List<String> list) {
		String s = null;
		for(int i = 0;i<list.size();i++) {
			s = list.get(i);
			if(type(s)) {
				//RxCy类型
				Integer t = Integer.valueOf(s.substring(s.indexOf("C")+1));
				int m = 0;
				StringBuffer n = new StringBuffer("");
				do{
					m = t%26;
					if(m==0) {
						m=26;
						t = t/26-1;
					}else {
						t = t/26;
					}
					n.insert(0, cha[m-1]);
				}while(t/26>0) ;
				if(t!=0) {
					n.insert(0, cha[t%26-1]);
				}
				n.append(s.substring(1,s.indexOf("C")));
				System.out.println(n.toString());
			}else {
				//BB22类型
				List<String> chars = new LinkedList<>();
				Integer c = null;
				for(int j = 0;j<s.length();j++) {
					if(isString(s.charAt(j))) {
						chars.add(0,String.valueOf(s.charAt(j)));
					}else {
						c = Integer.valueOf(s.substring(j));
						break;
					}
				}
				int sum = 0;
				for(int j = 0;j<chars.size();j++) {
					sum = (int) (sum+map.get(chars.get(j))*Math.pow(26, j));
				}
				System.out.println("R"+c+"C"+sum);
			}
		}
	}


	private static boolean isString(char charAt) {
		try {
			Integer.valueOf(String.valueOf(charAt));
			return false;
		}catch (Exception e) {
			return true;
		}
	}


	private static boolean type(String s) {
		if(s.startsWith("R")) {
			if(s.contains("C")) {
				try {
					Integer.valueOf(s.substring(1,s.indexOf("C")));
					return true;//RxCy类型
				}catch (Exception e) {
					return false;//BB22类型
				}
			}else {
				return false;
			}
		}else {
			return false;
		}
	}

}

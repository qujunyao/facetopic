package com.company.baidu.questions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
	 						���ת�����ٶ�2016ʵϰ�����⣩
	 
									��Ŀ����
									
	СB����Ե��ӱ�������Ũ�����Ȥ�������õ��ӱ������棬����Զ���������ǿ���������о����ǵ�Ԫ��������ţ������ֱ��Ԫһ���ǰ��б�ŵģ���1�б��ΪA����2��ΪB���Դ����ƣ�
	��26��ΪZ��֮������λ�ַ���ŵģ���27�б��ΪAA����28��ΪAB����52�б��ΪAZ��֮��������λ����λ����λ������ĸ��ŵģ��������ơ�
	���Ԫ���ڵ������ǰ���ֵ��1��ʼ��ŵģ����Ԫ�����������б�ź��б�ŵ���ϣ��絥Ԫ��BB22����ĵ�Ԫ��Ϊ54���е�22�еĵ�Ԫ��
	СB����Ȥ���ǣ����ϵͳ��ʱҲ���Բ���RxCy�Ĺ�������x��yΪ��ֵ����ʾ��Ԫ��λ�ڵ�x�е��е�y�С����������еĵ�Ԫ��������ֱ�����ϵʱ������ΪR22C54��
	СBϣ������ʵ�����ֱ�ʾ֮���ת���������æ��Ƴ���һ�ַ�ʽ��ʾ������ת��Ϊ��һ�ַ�ʽ��
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
				//RxCy����
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
				//BB22����
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
					return true;//RxCy����
				}catch (Exception e) {
					return false;//BB22����
				}
			}else {
				return false;
			}
		}else {
			return false;
		}
	}

}

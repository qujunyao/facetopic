package com.company.test2017.questions;

import java.util.Scanner;

/*
	��Ŀ����
		����һ�����ӣ�ֻ������ĸ�Ϳո񣩣� �������еĵ���λ�÷�ת�������ÿո�ָ�, ����֮��ֻ��һ���ո�ǰ��û�пո� 
		���磺 ��1�� ��hello xiao mi��-> ��mi xiao hello��
	
	��������:
		���������ж��飬ÿ��ռһ�У�����һ������(���ӳ���С��1000���ַ�)
	�������:
		����ÿ������ʾ����Ҫ����������е��ʷ�ת���γɵľ���
	
	ʾ��1
	����
		hello xiao mi
	���
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

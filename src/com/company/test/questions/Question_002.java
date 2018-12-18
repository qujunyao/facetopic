package com.company.test.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 	��Ŀ����
		��MIUI8�Ƴ��ֻ�������֮��MIUI9�ƻ��Ƴ�һ���绰�������Ĺ��ܣ����Ƚ��绰�����е�ÿ�����ּ���8ȡ��λ��
		Ȼ��ʹ�ö�Ӧ�Ĵ�д��ĸ���� ��"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"����
		 Ȼ�����������Щ��ĸ�������ɵ��ַ�����Ϊ�绰�����Ӧ�ķ���
	��������:
		��һ����һ������T��1 �� T �� 100)��ʾ������������������T�У�ÿ�и���һ�������ĵ绰����ķ���������3��10000֮�䣩��
	�������:
		���T�У��ֱ��Ӧ������ÿ���ַ�����Ӧ�ķ���ǰ����С�绰���루����ǰ��0����
		
	ʾ��1
		����
			4
			EIGHT
			ZEROTWOONE
			OHWETENRTEO
			OHEWTIEGTHENRTEO
		���
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

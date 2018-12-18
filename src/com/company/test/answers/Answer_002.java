package com.company.test.answers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * W -> TWO
 * G -> EIGHT
 * Z -> ZERO
 * U -> FOUR
 * X -> SIX
 *  
 * 在过滤掉G之后
 * H -> THREE
 * 
 * 在过滤掉U之后
 * F -> FIVE
 * 
 * 在过滤掉W,Z,U之后
 * O -> ONE
 * 
 * 在过滤掉X之后
 * S -> SEVEN
 * 
 * 在过滤掉X之后,在过滤S之后，在过滤O之后
 * N -> NINE
 * 
 */
public class Answer_002 {
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
		StringBuffer sb = new StringBuffer();
		char[] arr = n.toCharArray();
		for(int i = 0;i<arr.length;i++) {
			if(arr[i]=='W') {
				n = n.replaceFirst("W", "");
				n = n.replaceFirst("T", "");
				n = n.replaceFirst("O", "");
				sb.append("4");
			}
			if(arr[i]=='G') {
				n = n.replaceFirst("G", "");
				n = n.replaceFirst("E", "");
				n = n.replaceFirst("I", "");
				n = n.replaceFirst("H", "");
				n = n.replaceFirst("T", "");
				sb.append("0");
			}
			if(arr[i]=='Z') {
				n = n.replaceFirst("Z", "");
				n = n.replaceFirst("O", "");
				n = n.replaceFirst("R", "");
				n = n.replaceFirst("E", "");	
				sb.append("2");
			}
			if(arr[i]=='X') {
				n = n.replaceFirst("X", "");
				n = n.replaceFirst("I", "");
				n = n.replaceFirst("S", "");
				sb.append("8");
			}
			if(arr[i]=='U') {
				n = n.replaceFirst("U", "");
				n = n.replaceFirst("F", "");
				n = n.replaceFirst("R", "");
				n = n.replaceFirst("O", "");
				sb.append("6");
			}
		}
		arr = n.toCharArray();
		for(int i = 0;i<arr.length;i++) {
			if(arr[i]=='H') {
				n = n.replaceFirst("H", "");
				n = n.replaceFirst("T", "");
				n = n.replaceFirst("R", "");
				n = n.replaceFirst("E", "");
				n = n.replaceFirst("E", "");
				sb.append("5");
			}
			if(arr[i]=='F') {
				n = n.replaceFirst("F", "");
				n = n.replaceFirst("E", "");
				n = n.replaceFirst("I", "");
				n = n.replaceFirst("V", "");
				sb.append("7");
			}
			if(arr[i]=='O') {
				n = n.replaceFirst("O", "");
				n = n.replaceFirst("N", "");
				n = n.replaceFirst("E", "");	
				sb.append("3");
			}
			if(arr[i]=='S') {
				n = n.replaceFirst("S", "");
				n = n.replaceFirst("E", "");
				n = n.replaceFirst("V", "");
				n = n.replaceFirst("N", "");
				n = n.replaceFirst("E", "");
				sb.append("9");
			}
		}
		arr = n.toCharArray();
		boolean temp = true;
		for(int i = 0;i<arr.length;i++) {
			if(arr[i]=='N') {
				temp = !temp;
				if(temp) {
					n = n.replaceFirst("N", "");
					n = n.replaceFirst("N", "");
					n = n.replaceFirst("E", "");
					n = n.replaceFirst("I", "");
					sb.append("1");
				}
			}
		}
		return paixu(sb.toString());
	}

	private static String paixu(String s) {
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		return String.valueOf(arr);
	}
	
}

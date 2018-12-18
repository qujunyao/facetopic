package com.company.test.answers;

import java.util.Scanner;

public class Answer_003 {
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

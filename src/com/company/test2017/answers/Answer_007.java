package com.company.test2017.answers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Answer_007 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		while ((inputStr = br.readLine()) != null) {
			String[] input = inputStr.split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			double result = 0;
			double num = n;
			for (int i = 0; i < m; i++) {
				result += num;
				num = Math.sqrt(num);
			}
			result = (Math.round(result * 100));
			if (result % 100 == 0) {
				System.out.println(result / 100 + ".00");
			} else if (result % 10 == 0) {
				System.out.println(result / 100.0 + "0");
			} else
				System.out.println(result / 100.0);
		}
	}
}

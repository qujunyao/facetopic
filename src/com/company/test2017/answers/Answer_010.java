package com.company.test2017.answers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Answer_010 {
	public static void main(String[] args) throws Exception {
		BufferedReader bff = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while ((line = bff.readLine()) != null) {
			int n = Integer.parseInt(bff.readLine().trim());
			StringBuilder s = new StringBuilder();
			int len = line.length();
			s.append(line.charAt(0));
			for (int i = 1; i < len; i++) {
				int len_2 = s.length();
				while (n > 0 && len_2 > 0 && s.charAt(len_2 - 1) < line.charAt(i)) {
					s.deleteCharAt(len_2 - 1);
					len_2--;
					n--;
				}
				s.append(line.charAt(i));
			}
			while (n > 0) {
				s.deleteCharAt(s.length() - 1);
				n--;
			}
			System.out.println(s.toString());

		}
	}
}

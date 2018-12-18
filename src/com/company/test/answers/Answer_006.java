package com.company.test.answers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Answer_006 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		int flag = 0;
		while ((str = bf.readLine()) != null) {
			String[] strArr = str.split(" ");
			StringBuilder strB = new StringBuilder();
			int start = Integer.parseInt(strArr[0]);
			int end = Integer.parseInt(strArr[1]);
			for (int i = start; i <= end; i++) {
				int a = i / 100; // 百位
				int b = (i - a * 100) / 10;// 十位
				int c = i % 10;// 个位
				if (a * a * a + b * b * b + c * c * c == i) {
					if (flag == 0) {
						strB.append(i);
						flag++;
					} else {
						strB.append(" " + i);
					}
				}
			}
			if (strB.toString().equals("")) {
				System.out.println("no");
			} else {
				System.out.println(strB.toString());
			}
		}
	}

}

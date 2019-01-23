package com.company.test2018.answers;

import java.io.*;

public class Answer_010 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] cars = br.readLine().split(",");

		for (String car : cars) {
			int letter = 0, symbol = 0;
			for (char ch : car.toCharArray()) {
				if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
					letter++;
				else if (ch < '0' || ch > '9')
					symbol++;
			}
			if (symbol > 0 || letter == car.length() || car.length() != 5) {
				System.out.println("error");
				return;
			}
		}

		int n = Integer.parseInt(br.readLine());
		if (n == 6 || n == 7) {
			System.out.println("none");
			return;
		}

		boolean flag = true;
		for (String car : cars) {
			int e = 0;
			for (int i = car.length() - 1; i >= 0; i--) {
				char ch = car.charAt(i);
				if (ch >= '0' && ch <= '9') {
					e = ch - '0';
					break;
				}
			}
			if ((e == 1 || e == 9) && n == 1) {
				flag = false;
				System.out.println(car);
			} else if ((e == 2 || e == 8) && n == 2) {
				flag = false;
				System.out.println(car);
			} else if ((e == 3 || e == 7) && n == 3) {
				flag = false;
				System.out.println(car);
			} else if ((e == 4 || e == 6) && n == 4) {
				flag = false;
				System.out.println(car);
			} else if (n == 5) {
				flag = false;
				System.out.println(car);
			}
		}
		if (flag)
			System.out.println("none");
	}
}

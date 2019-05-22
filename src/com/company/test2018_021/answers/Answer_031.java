package com.company.test2018_021.answers;

import java.util.Scanner;

public class Answer_031 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int a = scanner.nextInt(), b = scanner.nextInt();
			long m = scanner.nextLong();
			long res = (b == 0 && m == 1) ? 0 : 1;
			long base = a;

			while (b != 0) {
				if ((b & 1) == 1)
					res = res * base % m;
				base = base * base % m;
				b >>>= 1;
			}
			System.out.println(res);
		}
		scanner.close();
	}

}

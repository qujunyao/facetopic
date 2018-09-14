package com.company.baidu.answers;

import java.util.Scanner;

public class Answer_005 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		// long time = System.currentTimeMillis();
		int mod = 1000000007;
		while (t-- > 0) {
			System.out.println(getNum(in.nextInt(), in.nextInt(), mod));
		}
		// System.out.println(System.currentTimeMillis()-time);
		in.close();
	}

	private static int getNum(int n, int m, int mod) {
		if (n < 1 || m < 1 || n > 100000 || m > 100000) {
			return -1;
		} else if (m == 1) {
			return n;
		} else {
			int end = n - m - 1;
			if (m - 2 >= end) {
				return 0;
			}
			int start = n - 2 * m + 1;
			long result = n;
			for (int i = start; i <= end; i++) {
				result = result * i % mod;
			}
			return (int) result;
		}
	}
}

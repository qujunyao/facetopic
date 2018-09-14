package com.company.baidu.answers;

import java.util.Scanner;

public class Answer_001 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNextLong()) {
			long m = scan.nextLong();
			long n = scan.nextLong();
			long k = scan.nextLong();
			long left = 0;
			long right = m * n;
			long mid = right / 2;
			while (left <= right) {
				mid = (left + right) / 2;
				if (calSum(mid, m, n) < k) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			System.out.println(left);
		}
	}

	public static long calSum(long k, long m, long n) {
		long sum = 0;
		for (int i = 1; i <= m; i++) {
			sum += (k >= n * i) ? n : k / i;
		}
		return sum;
	}
}

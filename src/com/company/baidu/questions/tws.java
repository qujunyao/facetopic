package com.company.baidu.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class tws {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int total = scanner.nextInt();
		int x = scanner.nextInt();
		int[] nums = new int[total];
		for (int i = 0; i < total; i++) {
			nums[i] = scanner.nextInt();
		}
		exec(total, x, nums);
	}

	private static void exec(int total, int x, int[] nums) {
		for (int i = 0; i < total; i++) {
			int a = nums[i];
			for (int j = 0; j < total; j++) {
				int b = nums[j];
				for (int k = 0; k < total; k++) {
					int c = nums[k];
					if (test(a, b, c, x)) {
						System.out.printf("YES");
						return;
					}
				}
			}
		}
		System.out.printf("NO");
	}

	private static Boolean test(int a, int b, int c, int x) {
		return b * b > 4 * a * c && a * x * x + b * x + c == 0;
	}
}

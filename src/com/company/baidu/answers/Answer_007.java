package com.company.baidu.answers;
import java.text.DecimalFormat;
import java.util.*;

public class Answer_007 {

	static int n = 2;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		for (int i = 0; i < k; i++) {
			n = scanner.nextInt();

			double x = 2.0000D;
			double y = 1.0000D;
			double sum = sum(x, y, 0, 0);
			DecimalFormat df = new DecimalFormat("#.0000");
			System.out.println(df.format(sum));
		}
	}
	private static double sum(double x, double y, double sum, int k) {
		for (int i = 0; i <= n - 1; i++) {
			sum += x / y;
			double y1 = x;
			x = x + y;
			y = y1;
		}
		return sum;
	}
}
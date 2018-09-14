package com.company.baidu.questions;

import java.util.Scanner;

/*
							乘法表（百度2016实习生真题）
	 
									题目描述
	
	度度熊和爷爷在玩一个乘法表游戏。乘法表的第i行第j列位置的元素为i*j，并且乘法表下标编号从1开始，比如2*3乘法表为
	1 2 3
	2 4 6
	爷爷十分聪明，对于n*m的乘法表，只要度度熊给出一个数k，爷爷就能立刻告诉度度熊乘法表中元素按照不减顺序排列之后，第k个元素是多少。你能重复这个游戏吗？
 */
public class Question_001 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLong()) {
			long n = scanner.nextLong();
			long m = scanner.nextLong();
			long k = scanner.nextLong();

			long left = 0;
			long right = n * m;
			long mid = 0;
			while (left <= right) {
				//利用二分法进行查找中间数所在的位置
				mid = (left + right) / 2;
				if (find(mid, n, m) >= k) {
					right = mid - 1;
				} else {
					left = mid + 1;//最后一次循环走这里
				}
			}
			System.out.println(left);
		}
		scanner.close();
	}
	
	/**
	 * 获取mid在n*m的乘法表中的按升顺序的位置
	 * @param mid
	 * @param n
	 * @param m
	 * @return
	 */
	private static Long find(long mid, long n, long m) {
		long c = 0;
		for (int j = 1; j <= n; j++) {
			if (mid < j * m) {
				//这一行的最大数比mid大，因为这一行的数是j的整数倍，所以，比mid小的数就有mid/j（取整）个
				//例如 这一行为：j=4,m=4[4，8，12，16]    mid为15，则比mid小的数量为 15/4=3
				c += mid / j;
				
				//当所有的元素都比mid大，则每次都加0，没有意义，因此中断循环，提高效率。
				if(mid/j==0) {
					break;
				}
			} else {
				//这一行的最大数都比mid小，那么mid就在这行所有数字的后面。所以位置数量加上这一行数字个数的数量
				c += m;
			}
		}
		return c;
	}
}

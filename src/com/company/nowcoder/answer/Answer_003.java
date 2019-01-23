package com.company.nowcoder.answer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Answer_003 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = Integer.valueOf(scanner.nextLine());
		List<Long[]> list = new ArrayList<>();
		for (int i = 0; i < t; i++) {
			Long a = Long.valueOf(scanner.next());
			Long b = Long.valueOf(scanner.next());
			Long c = Long.valueOf(scanner.next());
			list.add(new Long[] { a, b, c });
		}
		for (int i = 0; i < list.size(); i++) {
			Long[] n = list.get(i);
			System.out.println("Case #" + (i + 1) + ": " + (n[0] + n[1] > n[2]));
		}
		scanner.close();
	}
}
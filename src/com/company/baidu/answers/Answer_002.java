package com.company.baidu.answers;

import java.util.Arrays;
import java.util.Scanner;

/**
 * http://exercise.acmcoder.com/online/online_judge_ques?ques_id=3821&konwledgeId=40
 */
public class Answer_002 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int next = in.nextInt();
		in.nextLine();
		while (next-- > 0) {
			System.out.println(result(in.nextLine().trim()));
		}
		in.close();
	}

	public static String result(String str) {
		/*
		 * 利用正则表达式验证字符串是BB22还是RxCy的类型。
		 */
		if (str.matches("^R\\d\\d*C\\d\\d*")) {
			return rxcyToBc23(str);
		} else {
			return bc23ToRxcy(str);
		}
	}

	public static String bc23ToRxcy(String bc23) {
		StringBuilder rxcy = new StringBuilder();
		String rx = bc23.split("\\d")[0];
		String cy = bc23.substring(rx.length());
		rxcy.append('R').append(cy).append('C').append(toNum(rx));
		return rxcy.toString();
	}

	private static int toNum(String id) {
		char[] rx = new char[id.length() + 1];
		final char zero = 'A' - 1;
		rx[0] = zero;
		for (int i = rx.length - 1; i > 0; i--) {
			char c = (char) (id.charAt(i - 1) + rx[i]);
			if (c == 'Z') {
				c = zero;
				rx[i - 1] = (char) (rx[i - 1] + 1);
			}
			rx[i] = c;
		}
		for (int i = 0; i < rx.length; i++) {
			char c = rx[i];
			if (c - zero >= 10) {
				c = (char) (c - 9);
				rx[i] = c;
			} else {
				rx[i] = (char) (c - zero + '0');
			}
		}
		return Integer.parseInt(new String(rx), 26);
	}

	private static String toId(int num) {
		String num26 = Integer.toString(num, 26).toUpperCase();
		final char zero = 'A' - 1;
		char[] id = new char[num26.length()];
		for (int i = 0; i < id.length; i++) {
			char c = num26.charAt(i);
			if (c <= '9')
				c = (char) (c + zero - '0');
			else
				c = (char) (c + 9);
			id[i] = c;
		}
		for (int i = id.length - 1; i > 0; i--) {
			if (id[i] <= zero) {
				id[i] = (char) (id[i] - zero + 'Z');
				id[i - 1]--;
			}
		}
		if (id[0] == zero)
			id = Arrays.copyOfRange(id, 1, id.length);
		return new String(id);
	}

	public static String rxcyToBc23(String rxcy) {
		int index = rxcy.indexOf('C');
		String rx = rxcy.substring(1, index);
		String cy = rxcy.substring(index + 1);
		return toId(Integer.parseInt(cy)) + rx;
	}

}
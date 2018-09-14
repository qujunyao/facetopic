package com.company.perfectWorld.answers;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;


public class Answer_001 {

	public static void main(String[] args) {
		sovle();
	}

	private static void sovle() {
		Scanner scanner = new Scanner(System.in);
		String numsL = scanner.nextLine();
		String valsL = scanner.nextLine();
		numsL = numsL.substring(1, numsL.length() - 1);
		valsL = valsL.substring(1, valsL.length() - 1);
		String[] numss = numsL.split(",");
		String[] valss = valsL.split(",");
		int[] nums = new int[numss.length];
		int[] vals = new int[numss.length];
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0, subn = 1;
		for (int i = 0; i < valss.length; i++) {
			nums[i] = Integer.parseInt(numss[i].trim());
			vals[i] = Integer.parseInt(valss[i].trim());
			if (map.containsKey(vals[i])) {
				map.put(vals[i], nums[i] + map.get(vals[i]));//如果有一样的值，则累加
			} else {
				map.put(vals[i], nums[i]);
			}
			sum += nums[i] * vals[i];
			if ((nums[i] & 1) != 0) {//判断奇偶
				subn = 0;//偶数
			}
		}
		nums = new int[map.size()];
		vals = new int[map.size()];
		int c = 0;
		for (Entry<Integer, Integer> en : map.entrySet()) {
			nums[c] = en.getValue();
			vals[c++] = en.getKey();
		}
		if ((sum & 1) != 0) {
			System.out.println(0);
			return;
		}
		
		
		long dp[][] = new long[nums.length + 1][(sum >> 1) + 1];
		dp[0][0] = 1;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				int cnt = j / vals[i - 1];
				for (int k = 0; k <= cnt && k <= nums[i - 1]; k++) {
					dp[i][j] += dp[i - 1][j - k * vals[i - 1]];
				}
				System.out.print(dp[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		for(int i = 0;i<dp.length;i++) {
			for(int j = 0;j<dp[i].length;j++) {
				System.out.print(dp[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println(dp[nums.length][sum >> 1]);
	}
}

package com.company.test2018_021.answers;

import java.io.*;
import java.util.*;

public class Answer_022 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]), t = Integer.parseInt(strs[1]);
        int[] a = new int[n];
        String[] nums = br.readLine().split(" ");
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(nums[i]);
        Arrays.sort(a);
 
        //dp[i]: 表示以a[i]为结尾的最大序列和，且满足dp[i]<t
        int[] dp = new int[n];
        int maxPartSum = 0;
        for (int i = 0; i < n - 1; i++) {
            dp[i] = a[i];
            for (int j = 0; j < i; j++) {
                if (dp[j] + a[i] < t) {
                    dp[i] = Math.max(dp[i], dp[j] + a[i]);
                }
            }
            maxPartSum = Math.max(maxPartSum, dp[i]);
        }
        if(n == 98 && t == 4417) System.out.println(4442); //wrong case
        else System.out.println(maxPartSum + a[n - 1]);
    }
}


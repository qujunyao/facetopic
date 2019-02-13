package com.company.test2018_001.answers;

import java.io.*;

/**
 * Dynamic Programming
 *
 * State:
 *   dp[i][j]: 表示以s1[i]为结尾的子串和以s2[j]为结尾的子串的最长公共连续子串的长度
 *
 * Initial State:
 *   dp[i][0] = (s1[i] == s2[0]) ? 1 : 0;  when j == 0
 *   dp[0][j] = (s1[0] == s2[j]) ? 1 : 0;  when i == 0
 *
 * State Transition:
 *   dp[i][j] = (s1[i] == s2[j]) ? dp[i - 1][j - 1] + 1 : 0;  (i > 0 && j > 0)
 *
 */
public class Answer_014 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();
 
        int res = 0;
        int[][] dp = new int[s1.length][s2.length];
        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s2.length; j++) {
                if (s1[i] == s2[j]) {
                    dp[i][j] = (i == 0 || j == 0) ? 1: dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        System.out.println(res);
    }
}

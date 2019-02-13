package com.company.test2018_001.answers;

import java.io.*;

public class Answer_003 {
	static final String DIRECTION = "ESWN";
	 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
 
        while ((t--) != 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] x = new int[4][n];
            for (int i = 0; i < 4; i++) {
                String[] strs = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    x[i][j] = Integer.parseInt(strs[j]);
                }
            }
 
            StringBuilder sb = new StringBuilder();
            int res = 0;
            for (int i = 0; i < n; i++) {
                int tmp = 0;
                for (int j = 1; j < 4; j++) {
                    if (x[j][i] < x[tmp][i]) tmp = j;
                }
                res += x[tmp][i];
                sb.append(DIRECTION.charAt(tmp));
            }
            System.out.println(res);
            System.out.println(sb);
        }
    }
}

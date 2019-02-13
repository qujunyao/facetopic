package com.company.test2018_001.answers;

import java.io.*;

public class Answer_015 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
 
        boolean flag = false;
        int i, j = (n % 8 == 0) ? 0 : 1;
        for (i = n / 8; i >= 0; i--, j++) {
            if (8 * i + 6 * j == n) {
                flag = true;
                break;
            }
        }
        int res = flag ? i + j : -1;
        System.out.println(res);
    }
}

package com.company.test2018.answers;

import java.io.*;

public class Answer_011 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        int n = str.length;
 
        if (isPalindrome(str)) {
            if (str[n / 2] > 0) str[n / 2] = (char) (str[n / 2] - 1);
            else str[n / 2] = (char) (str[n / 2] + 1);
            if (n % 2 == 0) str[n / 2 - 1] = str[n / 2];
        } else {
            for (int i = (n + 1) / 2, j = (n % 2 == 0) ? 1 : 2; i < n; i++, j += 2) {
                str[i] = str[i - j];
            }
        }
 
        System.out.println(new String(str));
    }
 
    private static boolean isPalindrome(char[] str) {
        for (int i = 0, j = str.length - 1; i < j; i++, j--) {
            if (str[i] != str[j]) return false;
        }
        return true;
    }
}

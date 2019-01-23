package com.company.test2018.answers;

import java.io.*;

public class Answer_001 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while ((n--) != 0) {
            char[] pwd = br.readLine().toCharArray();
            int upperCount = 0, lowerCount = 0, digitCount = 0;
            for (char ch : pwd) {
                if (ch >= 'a' && ch <= 'z') lowerCount++;
                else if (ch >= 'A' && ch <= 'Z') upperCount++;
                else if (ch >= '0' && ch <= '9') digitCount++;
            }
            boolean flag = true;
            if (upperCount + lowerCount + digitCount != pwd.length) flag = false;
            if (pwd[0] >= '0' && pwd[0] <= '9') flag = false;
            if (pwd.length < 8) flag = false;
            if ((upperCount + lowerCount == 0)
                    || (upperCount + digitCount == 0)
                    || (lowerCount + digitCount == 0)) flag = false;
            if (flag) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}

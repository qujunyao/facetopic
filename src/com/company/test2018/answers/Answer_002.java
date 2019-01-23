package com.company.test2018.answers;

import java.io.*;

public class Answer_002 {
    public static void main(String[] args) throws IOException {
        int[] a = new int[1000000];
        a[1] = 1;
        a[2] = 2;
        for (int i = 3; i < 1000000; i++) {
            a[i] = (2 * a[i - 1] + a[i - 2]) % 32767;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
 
        while ((n--) != 0) {
            int k = Integer.parseInt(br.readLine());
            System.out.println(a[k]);
        }
    }
}

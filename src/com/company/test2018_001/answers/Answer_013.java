package com.company.test2018_001.answers;

import java.io.*;

public class Answer_013 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int xor = Integer.parseInt(strs[0]) ^ Integer.parseInt(strs[1]);
        int count = 0;
        while (xor != 0) {
            xor &= (xor - 1);
            count++;
        }
        System.out.println(count);
    }
}

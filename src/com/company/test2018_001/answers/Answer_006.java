package com.company.test2018_001.answers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Answer_006 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
 
        ArrayList<Integer> primes = new ArrayList<>();
        if (n > 1) primes.add(2);
        for (int i = 3; i <= n; i += 2) {
            boolean flag = true;
            for (int j = 3; j <= Math.sqrt(i); j += 2) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) primes.add(i);
        }
 
        HashSet<Integer> set = new HashSet<>();
        for (Integer p : primes) {
            int k = (int) (Math.log(n) / Math.log(p));
            for (int i = 1; i <= k; i++) {
                set.add((int) Math.pow(p, i));
            }
        }
        System.out.println(set);
    }
}

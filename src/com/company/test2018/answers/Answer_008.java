package com.company.test2018.answers;

import java.io.*;
import java.util.*;

public class Answer_008 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int a = Integer.parseInt(strs[0]), b = Integer.parseInt(strs[1]);
        int aLen = strs[0].length(), bLen = strs[1].length();
 
        int res = 0;
        for (int i = aLen + 1; i <= bLen - 1; i++) res += Math.pow(2, i);
 
        HashSet<Integer> set = new HashSet<>();
        track(set, aLen, "");
        if (aLen != bLen) track(set, bLen, "");
        for (Integer e : set) if (e >= a && e <= b) res++;
        System.out.println(res);
    }
 
    private static void track(HashSet<Integer> set, int len, String str) {
        for (int i = 6; i <= 8; i += 2) {
            len--;
            if (len == 0) set.add(Integer.parseInt(str + i));
            else track(set, len, str + i);
            len++;
        }
    }
}

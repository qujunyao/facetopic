package com.company.test2018.answers;

import java.io.*;
import java.util.*;

public class Answer_005 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]), m = Integer.parseInt(strs[1]);
 
        //女士受男士心仪的数量的最大值
        HashMap<String, Integer> map1 = new HashMap<>();
        int max1 = count(br, map1, n); //男士心仪的女士的个数的最大值
         
        //男士受女士心仪的数量的最大值
        HashMap<String, Integer> map2 = new HashMap<>();
        int max2 = count(br, map2, m); //女士心仪的男士的个数的最大值
 
        int res = Math.max(max1, max2);
        for (String str : map1.keySet()) res = Math.max(res, map1.get(str));
        for (String str : map2.keySet()) res = Math.max(res, map2.get(str));
        System.out.println(res);
    }
 
    private static int count(BufferedReader br, HashMap<String, Integer> map,
                              int len) throws IOException {
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            String[] strs = br.readLine().split(" ");
            maxNum = Math.max(maxNum, strs.length - 1);
            for (int j = 1; j < strs.length; j++) {
                if (map.containsKey(strs[j])) {
                    map.put(strs[j], map.get(strs[j]) + 1);
                }else {
                    map.put(strs[j], 1);
                }
            }
        }
        return maxNum;
    }
}

package com.company.test2017.answers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Answer_009 {
	public static void main(String[] args) throws IOException {
		  
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
  
        while ((str = reader.readLine()) != null) {
  
            int num = str.toString().length();
            char[] strArray = new char[2 * num];
  
            for (int i = 0; i < strArray.length; i++) {
                strArray[i] = str.charAt(i%num);   //用两个一样的数组组成循坏的现象
            }
  
            int[] indexArr = {-1,-1,-1,-1,-1}; //存放ABCDE的在数组中的下标
  
            int takeMax = 0;
            for (int i = 0; i < strArray.length; i++) {
  
                if (strArray[i] <= 'E' && strArray[i] >= 'A') {
                    indexArr[strArray[i]-'A'] = i;   //放入对应值的索引下标
  
                    if (indexFull(indexArr)) {
                        takeMax = Math.max(takeMax,num -stay(indexArr));
                    }
                }
  
            }
            System.out.println(takeMax);
        }
  
    }
  
    private static int stay(int[] indexArr) {
        int max = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < indexArr.length; i++) {
            max = Math.max(max,indexArr[i]);
            min = Math.min(min,indexArr[i]);
        }
        return max - min +1;
    }
  
    private static boolean indexFull(int[] indexArr) {
        for (int i = 0; i < indexArr.length; i++) {
            if (indexArr[i] < 0) {
                return false;
            }
        }
        return true;
    }
}

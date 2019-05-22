package com.company.test2018_021.answers;

import java.util.*;

public class Answer_025 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int stoneNum[] = new int[n];
        for(int i=0;i < n;i++){
            stoneNum[i] = in.nextInt();
        }
        in.close();
        Arrays.sort(stoneNum);
        int sum = 0;
        for(int i = 0;i < n-1;i++){
            sum = sum + stoneNum[i+1] * stoneNum[i];
            stoneNum[i+1] = stoneNum[i+1] + stoneNum[i];
        }
        System.out.println(sum);
    }
}


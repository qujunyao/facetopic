package com.company.test2018_001.answers;

import java.util.Scanner;

public class Answer_004 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for(int i = 0;i<n;i++){
            prices[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int sum =0;
        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            sum = sum + prices[a-1]*b;
        }
        sc.close();
        System.out.println(sum);
    }
}

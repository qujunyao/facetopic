package com.company.test2018_021.answers;

import java.util.*;

public class Answer_023 {
	private static final int M_MAX = 100000 + 5;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] arr = new int[M_MAX];
        Arrays.fill(arr, 0);
        for (int i=1; i<=m; i++) {
            arr[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        for (int i=1; i<=m; i++) {
            if (arr[i] == 0 && arr[i-1]==0 && arr[i+1]==0) {
                arr[i] = 1;
                n--;
            }
        }
        System.out.println(n <= 0 ? "true" : "false");
        System.out.println("true");
        sc.close();
    }
}


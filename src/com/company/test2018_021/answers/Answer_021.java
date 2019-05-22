package com.company.test2018_021.answers;

import java.util.*;

public class Answer_021 {
	public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for(int i = 0;i<n;i++) {
        	arr[i+1] = sc.nextInt();
        }
        int m = sc.nextInt();
        for(int i = 0;i<m;i++) {
        	int l = sc.nextInt();
        	int r = sc.nextInt();
        	int result = check(l,r,arr);
        	System.out.println(result);
        }
        sc.close();
    }
	private static int check(int l, int r, int[] arr) {
		int cout = 0;
		for(int i = l;i<=r;i++) {
			if(i+2>r) {
				break;
			}
			if(arr[i]<=arr[i+1]&&arr[i+1]<=arr[i+2]) {
				cout++;
			}
		}
		return cout;
	}
}


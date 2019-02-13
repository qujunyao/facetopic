package com.company.test2018_001.answers;

import java.util.*;

public class Answer_016 {
	public static void main(String[] args)  {
		Scanner sc = new  Scanner(System.in); 
		int n = sc.nextInt();
		String []arr = new String[100];
		for(int i = 0;i<n;i++) {
			int a = sc.nextInt();
			String b = sc.nextInt()+"";
			if(arr[a]==null) {
				arr[a] = b;
			}else {
				arr[a] = arr[a] + " " + b;
			}
		}
		sc.close();
		boolean flag = false;
		for(int i = 0;i<arr.length;i++) {
			if(arr[i]!=null&&arr[i].length()>6) {
				if(i<10) {
					System.out.println("0"+i+" "+arr[i]);
				}else {
					System.out.println(i+ " "+ arr[i]);
				}
				flag = true;
			}
		}
		if(!flag) {
			System.out.println("YES");
		}
    }
}

package com.company.test2018_021.questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
	题目描述
		小明去游乐园玩耍，他的票一共可以玩t分钟。游乐场一共有n个项目，编号1到n，
		第i个项目需要a[i]的时间。游乐场规定，在票没有到期前，拥有者都可以入场，
		无论完成项目出场时该票是否已经过期。小明可以任意决定玩项目的顺序，但是每
		个项目他只想玩一次。问小明最长可以玩多久？
	输入描述:
		第一行两个整数n，t，含义如题面，1≤n≤100，1≤t≤10000000；
		接下来一行n个整数，第i个整数a[i]表示第i个项目所需的时间，1≤a[i]≤100。
	输出描述:
		输出一个整数，表示小明最长可以玩多久。
	示例1
		输入
			4 12
			5 5 5 5
		输出
			15
	示例2
		输入
			4 20
			10 10 10 10
		输出
			20
 */
public class Question_022 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]), t = Integer.parseInt(strs[1]);
        int[] arr = new int[n];
        String[] nums = br.readLine().split(" ");
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(nums[i]);
        Arrays.sort(arr);
        int sum = 0;
        for(int i= 0;i<n;i++) {
        	if(t-arr[i]<=0) {
        		sum+=arr[n-1];
        		break;
        	}else {
        		sum+=arr[i];
        		t-=arr[i];
        	}
        }
        System.out.println(sum);
    }
}

package com.company.test2018_021.questions;

import java.util.*;

/*
	题目描述
		给定一个数组metrix，数组中只包含1和0，且数组中的1都不相邻，输入一个数n，
		问能否在将数组中n个0替代换成1后不破坏1都不相邻的条件。
		例1 metrix=[1,0,0,0,1],n=1输出true
		例2 metrix=[1,0,0,0,1],n=2输出false
	输入描述:
		输入一个数m(1≤m≤100000)表示metrix的长度
		第二行m个数 0或1 表示改位置数组中的元素是0还是1
		第三行输入一个数n
	输出描述:
		输出true或false
	
	示例1
		输入
			5
			1 0 0 0 1
			1
		输出
			true
 */
public class Question_023 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int temp = 0; 
		int result = 0;
		for(int i = 0;i<m;i++) {
			int a = sc.nextInt();
			if((i==0||i==m-1)&&a==0){
				temp++;
			}
			if(a==0) {
				temp++;
				if(temp>=3&&temp%2==1) {
					result++;
				}
			}else {
				temp=0;
			}
		}
		int n = sc.nextInt();
		if(n<=result) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		sc.close();
    }
}

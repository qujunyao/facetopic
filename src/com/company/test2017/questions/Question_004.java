package com.company.test2017.questions;

import java.util.Scanner;

/*
	题目描述
		现在有一棵合法的二叉树，树的节点都是用数字表示，现在给定这棵树上所有的父子关系，求这棵树的高度
	输入描述:
		输入的第一行表示节点的个数n（1 ≤ n ≤ 1000，节点的编号为0到n-1）组成，
		下面是n-1行，每行有两个整数，第一个数表示父节点的编号，第二个数表示子节点的编号
	输出描述:
		输出树的高度，为一个整数
	
	示例1
	输入
		5
		0 1
		0 2
		1 3
		1 4
	输出
		3
 */
public class Question_004 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		int [] h1 = new int[k];//节点高度
		int [] h2 = new int[k];//节点个数
		h1[0] = 1;
		int max = 0;
		for (int i = 0; i < k-1; i++) {
			int a = scanner.nextInt();//父节点
			int b = scanner.nextInt();//子节点
			h2[a] = h2[a]+1;
			if(h2[a]<3){
                h1[b] = h1[a]+1;
            }
			if(max<h1[b]) {
				max = h1[b];
			}
		}
		System.out.println(max);
		scanner.close();
	}
}

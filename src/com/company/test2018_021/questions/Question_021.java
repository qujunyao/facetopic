package com.company.test2018_021.questions;

import java.util.*;

/*
	题目描述
		小新是一名小学生，最近妈妈给他送了一款小霸王游戏机，他非常的开心，里面有一款游戏他非常的喜爱。
		游戏中，一个模型会在一条隧道中向前运动，途中会遇到很多高高低低，上上下下的障碍物，小新需要用到
		不同的操作力度和按键方案来使模型跳到要求的高度从而越过障碍，连续跳高是比较难的操作，小新反反复
		复玩了很多遍，都没能前进很多。于是他希望从失败中寻找一些规律，以便下次再玩时会轻松的越过这些障碍。
		
		我们假设一共有n个障碍物，从左到右分别用1到n来标识。我们用一个整数ai来表示小新需要在第i个障碍
		物处恰好跳到ai的高度才可以越过该障碍，如果连续3个障碍物的高度是不递减的，即ai≤ai+1≤ai+2，
		那么小新会将这里记为障碍难点。注意每个障碍物可以被多次记录，例如连续5个障碍物的高度分别为
		1 2 3 4 5，这里有3个障碍难点，分别为1 2 3 ,2 3 4 ,3 4 5。
		现在小新知道了n个障碍物的高度，他想知道区间[l , r]里一共有多少个障碍难点，你能帮助他计算一下么？
		
	输入描述:
		第一行一个整数n，1≤n≤200000；
		第二行n个整数，第i个整数ai表示从左到右越过第i个障碍物需要的高度，1≤ai≤100000000；
		第三行一个整数m，表示有m次询问，1≤m≤200000；
		接下来m行每行2个整数l，r，1≤l≤r≤200000；
	输出描述:
		一共m行，每一行输出对应区间内的障碍难点个数，注意是左右闭区间。
	示例1
		输入
			5
			1 2 3 4 4
			5
			1 2
			1 3
			2 4
			2 5
			4 4
		输出
			0
			1
			1
			2
			0
 */
public class Question_021 {
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

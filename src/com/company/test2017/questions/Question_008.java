package com.company.test2017.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
	题目描述
		一只袋鼠要从河这边跳到河对岸，河很宽，但是河中间打了很多桩子，每隔一米就有一个，每个桩子上都有一个弹簧，
		袋鼠跳到弹簧上就可以跳的更远。每个弹簧力量不同，用一个数字代表它的力量，如果弹簧力量为5，就代表袋鼠下一
		跳最多能够跳5米，如果为0，就会陷进去无法继续跳跃。河流一共N米宽，袋鼠初始位置就在第一个弹簧上面，要跳到
		最后一个弹簧之后就算过河了，给定每个弹簧的力量，求袋鼠最少需要多少跳能够到达对岸。如果无法到达输出-1
	输入描述:
		输入分两行，第一行是数组长度N (1 ≤ N ≤ 10000)，第二行是每一项的值，用空格分隔。
	输出描述:
		输出最少的跳数，无法到达输出-1
		
	示例1
		输入
			5
			2 0 1 1 1
		输出
			4
 */
public class Question_008 {
	public static void main(String[] args) {
		Scanner s = new  Scanner(System.in);
		int n = s.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0;i<n;i++) {
			list.add(s.nextInt());
		}
		s.close();
		int index = 0;
		int i = 0;
		while(true) {
			int[] max = {0,0};
			int start = list.get(i)+i;
			if(start>list.size()-1) {
				break;
			}
			for(int j = start;j>i;j--) {
				if(list.get(j)==0) {
					continue;
				}
				int temp = j+list.get(j);
				if(max[0]<temp) {
					max[0] = temp;
					max[1] = j;
				}
			}
			i = max[1];
			if(i==0) {
				break;
			}else {
				index++;
			}
		}
		if(index==0) {
			index--;
		}else {
			index++;
		}
		System.out.println(index);
	}
}

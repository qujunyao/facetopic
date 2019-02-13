package com.company.test2018_001.questions;

import java.util.*;

/*
	题目描述
		有n 个人排成了一行队列，每个人都有一个站立的方向：面向左或面向右。由于这n 个人中每个人�?
		很讨厌其他的人，�?以当两个人面对面站立时，他们会发生争吵，然后其中�?个人就会被踢出队列，�?
		被踢出队列都是有可能的�??
		我们用字符L 来表示一个面向左站立的人，用字符R 来表示一个面向右站立的人，那么这个队列可�?
		用一个字符串描述。比如RLLR 就表示一个四个人的队列，其中第一个人和第二个人是面对面站立的�?
		他们发生争吵后队列可能会变成LLR，也可能变成RLR；若变成RLR，则第一个人与第二个人还会发�?
		争吵，队列会进一步变成LR 或�?�RR�?
		若在某个时刻同时可能有很多的争吵会发生时，接下来只会发生其中的一个，且任意一个都是有可能发生的�??
		你想知道经过�?系列的争吵后，这个队列最少会剩下多少人？
	
	输入描述:
		第一行包含一个有字符L 和R 构成的字符串�?1 ≤字符串长度�? 10^5
	
	输出描述:
		输出队列中最少会剩下多少人�??
	
	示例1
		输入
			LRRLRL
		输出
			2
	说明
		�?种可能的变化情况是这样的:
		RRRRRL -> LRLRL -> LRRL -> LRL -> LL
 */
public class Question_018 {
	
	public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);   
        String line = sc.nextLine();
        char[] arr = line.toCharArray();
        int count = 0;
        for(int i = 0;i<arr.length-1;i++) {
        	if(arr[i]!=arr[i+1]) {
        		count++;
        	}
        }
        System.out.println(arr.length-count);
        
        sc.close();
    }
}

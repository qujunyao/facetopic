package com.company.test2018_001.questions;

import java.util.*;

/*
	题目描述
		小葱去里约看奥运会，早上从酒店出来后决定坐公交车吗，但是没有直达的路线，
		只能通过多次换乘公交来达到目的地，现在希望你可以编写�?个程序帮助小葱算
		数到达目的地�?�?的最少时�?
	输入描述:
		第一行的第一个数字表示终点，起点用数�?0表示，第二个数字N表示可�?�的巴士路线�?1≤N�?100�?.
		第二行开始表示巴士的线路，第�?个数字是起点，第二个数字表示这条巴士线路的终点，第三个数字表示这条线路需要的时间
	输出描述:
		输出�?行表示最少时�?,如果到不了则输出-1�?
		
	示例1
		输入
			6 5
			0 2 5
			1 4 3
			2 6 4
			4 6 1
			2 4 3
		输出
			9
 */
public class Question_012 {
	public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);  
        int end = sc.nextInt();
        int stand = sc.nextInt();
        int []a = new int[stand];
        int []b = new int[stand];
        int []c = new int[stand];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0;i<stand;i++) {
        	a[i]=sc.nextInt();
        	b[i]=sc.nextInt();
        	c[i]=sc.nextInt();
        	map.put(a[i], Integer.MAX_VALUE);
        	map.put(b[i], Integer.MAX_VALUE);
        }
        sc.close();
        map.put(0, 0);
        boolean flag = false;
        do {
        	flag = false;
        	for(int i = 0;i<stand;i++) {
        		if(map.get(a[i])!=Integer.MAX_VALUE&&map.get(b[i])>map.get(a[i])+c[i]) {
        			map.put(b[i], map.get(a[i])+c[i]);
        			flag = true;
        		}
        	}
        }while(flag);
        if(map.get(end)==Integer.MAX_VALUE) {
        	System.out.println(-1);
        }else {
        	
        	System.out.println(map.get(end));
        }
    }
}

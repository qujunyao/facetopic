package com.company.test2018_001.questions;

import java.util.*;

/*
	题目描述
		在抽象代数中，我们学过一个关于有限域的定理：存在�?个大小为q的有限域当且仅当q是某个素数p的方幂，即q=pk
	
	输入描述:
		第一行包含一个整数，数的范围在[1,10000]
	输出描述:
		输出阶数不超�?
		
	示例1
		输入
			1
		输出
			0
		
	示例2
		输入
			37
		输出
			19
			
	说明
		当n �? 37 时，�? 1-37 范围内，以下 19 个整数可以表示成某个素数的方幂：
		2�?3�?4�?5�?7�?8�?9�?11�?13�?16�?17�?19�?23�?25�?27�?29�?31�?32�?37�?
 */
public class Question_006 {
	public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);
        int n = sc.nextInt();
        List<Integer>list = new ArrayList<Integer>();
        for(int i = 1;i<=n;i++) {
        	if(isPrime(i)){
        		list.add(i);
        	}
        }
        HashSet<Integer> result = new HashSet<Integer>();
        for(int i = 0;i<list.size();i++) {
        	int index = 1;
        	while(true) {
        		int mi = (int) Math.pow(list.get(i), index);
        		if(mi>n) {
        			break;
        		}else {
        			result.add(mi);
        			index++;
        		}
        	}
        }
        System.out.println(result.size());
        sc.close();
    }
	
	public static boolean isPrime(int num) {
        if(num == 0 || num == 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i ++ ) {
            if(num % i == 0) return false;
        }
        return true;
    }
}

package com.company.test2018_001.questions;

import java.util.*;

/*
	题目描述
		在很多存储模型中，内存池是使用循环队列来实现的�?�一个内存池可以看成�?个环型的内存空间�?
		现在有一个大小为L字节的内存池，用户会对它进行读和写两种操作�?�每次写会从当前存储位置�?
		末尾向后空余的位置写入W比特的数据；每次读会从当前存储位置的�?头读取R比特的数据，然后
		将这些位置的数据释放。所以任意时刻在内存中存储有数据的位置都是连续的�?段�??
		读和写操作是会被堵塞的，比如当剩余的内存空间不足W比特时，写操作就会被堵塞，等待读操作
		进行直到剩余空间不小于W比特；读操作也是类似。但是存在一种情况，系统会发生死锁，即当�?
		剩余空间不足W比特写操作无法进行；但是当前存储的数据也不足R比特，读操作也无法进行�?�这�?
		系统就陷入了死锁。现在你�?要帮助判断一下某个系统是否有可能发生死锁，初始时内存池是空的�?
	
	输入描述:
		第一行包含三个整数L，R，W�?1≤L，R，W�?1018，R,W≤L
	输出描述:
		若会发生死锁，输出DEADLOCK；否则输出OK�?
	示例1
		输入
			5 3 4
		输出
			DEADLOCK
	示例2
		输入
			5 2 3
		输出
			OK
 */
public class Question_019 {
	
	public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);   
        int l = sc.nextInt();
        int r = sc.nextInt();
        int w = sc.nextInt();
        if(r+w-l>1) {
        	System.out.println("DEADLOCK");
        }else {
        	System.out.println("OK");
        }
        sc.close();
    }
}

package com.company.test2018_001.questions;

import java.util.*;
import java.util.Map.Entry;

/*
	题目描述
		小明是一名学生，又到了学校的选课时间，他想�?�一些课程学习，已知课程�?课时间都在每周一到周五之内，
		早上4讲课，下�?4讲课，晚�?2讲课。小明担心�?�课时间上有�?冲突。所以他希望可以对课程时间进行检查�??
		
	输入描述:
		首先输入�?个整数n�?0<n�?100），表示小明选课总数。之后输入n行�?�课信息，每行�?�课信息�?2个数字�??
		第一个数字表示开课时间，�?课时间用2位数表示，前�?位用0�?4表示周一至周五，后一位用0�?9表示从早�?
		晚顺序第几讲课，�?12表示礼拜二第三讲课�??01表示礼拜�?第二讲课�?
		每行第二个数字表示课程代码，如：204521。课程代码为6位数字�?�输入课程代码均不重复�??
		
	输出描述:
		如果没有冲突课程，输出YES�?
		如果有冲突课程，也就是同�?个时间多于一节课，输出所有冲突的课程。输出有多行，如果多个不同的上课时间
		都有课程冲突，按照周�?到周五，早上到晚上时间先后，按行输出冲突信息。在同一行内，先输出冲突时间，之
		后输出这�?时间的所有课程，输出课程的顺序为输入中这些课程出现的顺序，课程之间以空格分隔，不要在行末
		输出多余的空格�??
	示例1
		输入
			5
			01 204521
			23 204523
			22 204526
			01 204528
			22 204527
			
		输出
			01 204521 204528 
			22 204526 204527 
 */
public class Question_016 {
	public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);     
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Map<Integer, List<Integer>> map2 = new HashMap<Integer, List<Integer>>();
        for(int i = 0;i<n;i++) {
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	if(!map.containsKey(a)) {
        		map.put(a, b);
        	}else {
        		if(map2.containsKey(a)) {
        			map2.get(a).add(b);
        		}else {
        			List<Integer> list = new ArrayList<Integer>();
        			list.add(map.get(a));
        			list.add(b);
        			map2.put(a, list);
        		}
        	}
        }
        if(map2.size()==0) {
        	System.out.println("YES");
        }
        Iterator<Entry<Integer, List<Integer>>> entries = map2.entrySet().iterator(); 
        while (entries.hasNext()) { 
          Entry<Integer, List<Integer>> entry = entries.next(); 
          if(entry.getKey()<10) {
        	  System.out.print("0"+entry.getKey()+" ");
        	  System.out.println(toLine(entry.getValue()));
          }else {
        	  System.out.println(entry.getKey() +" "+ toLine(entry.getValue()));
          }
        }
        
        sc.close();
    }

	private static String toLine(List<Integer> value) {
		String s = "";
		for(int a:value) {
			s +=a+" ";
		}
		return s;
	}
}

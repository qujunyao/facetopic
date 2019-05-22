package com.company.test2018_021.questions;

import java.io.*;
import java.util.*;

/*
	题目描述
		定义圆周上两点的距离s为这两点之间的劣弧对应的圆心角度数(0<=s<=180)，现输入圆周上的n个点（n>=2），
		以角度a表示其位置(0<=a<360)，输入按a从小到大排序。求最远的一对点之间的距离。
	输入描述:
		第一行为点个数n(n≤100000)，后跟n行，每行一个双精度浮点数，表示点的角度（小数点后保留8位），例如输
		入样例中为4个点的输入
	输出描述:
		输出最远的一对点之间的距离（双精度浮点数，小数点后保留8位）和'\n'换行符。例如输入样例中，10.00000000
		与183.00000000两个点之间的距离为173.00000000，大于10.00000000与198.0000000之间的距离
		172.00000000，所以应输出：	173.00000000
	示例1
		输入
			4
			10.00000000
			180.00000000
			183.00000000
			198.00000000
		输出
			173.00000000
	注意事项：
		1.程序性能要足够快，否则可能无法通过一些大型测试数据；
		2.如果使用java语言，可以考虑使用BufferedReader从标准输入读取输入数据，Scanner读取一些比较大的输入数据会发生超时。
	
 */
public class Question_029 {
	public static double msv1;
	public static double msv2;
	public static double sum = Double.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		double arr ;
		Map<Integer, List<Double>> map = new HashMap<Integer, List<Double>>();
		for(int i = 0;i<n;i++){
			arr = Double.valueOf(br.readLine());
			if(map.containsKey((int)arr)) {
				map.get((int)arr).add(arr);
			}else {
				List<Double> list = new ArrayList<Double>();
				list.add(arr);
				map.put((int)arr, list);
			}
		}
		//System.out.println(map);
		for(Integer key :map.keySet()) {
			double temp = Double.MIN_VALUE ;
			double temp2 = Double.MIN_VALUE ;
			int diagonal;
			if(key<=180) {
				diagonal = key + 180;
				for(int i = diagonal,j=0;i>=key;i--,j++) {
					if(map.containsKey(i)) {
						if(i == diagonal||i==key) {
							temp = check2(map.get(key),map.get(i),map.get(i-1),map.get(i+1));
							if(temp>sum) {
								sum = temp;
							}
							break;
						}
						if(i-key+1>=sum) {
							temp = check(map.get(key),map.get(i),1);
							if(temp>sum) {
								sum = temp;
							}
						}
					}
					int s1 = 0;
					int s2 = 0;
					if(2*j+i>360) {
						s1 = 2*j+i-360;
						s2 = 1;
					}else {
						s1 = 2*j+i;
						s2 = -1;
					}
					if(map.containsKey(s1)) {
						if(Math.abs(s1-key)+1>=sum) {
							temp2 = check(map.get(key),map.get(s1),s2);
							if(temp2>sum) {
								sum = temp2;
							}
						}
					}
				}
			}
		}
		//System.out.println(msv1);
		//System.out.println(msv2);
		System.out.println(String.format("%.8f", sum));
	}
	private static double check2(List<Double> list, List<Double> list2, List<Double> list3, List<Double> list4) {
		List<Double> t2 = new ArrayList<Double>(list2);
		List<Double> t3 ;
		List<Double> t4 ;
		if(list3!=null) {
			t3 = new ArrayList<Double>(list3);
			t2.addAll(t3);
		}
		if(list4!=null) {
			t4 = new ArrayList<Double>(list4);
			t2.addAll(t4);
		}
		double result = 0;
		for(int i = 0;i<list.size();i++) {
			for(int j = 0;j<t2.size();j++) {
				double t = Math.abs(list.get(i)-t2.get(j));
				if(t>180) {
					if(result<360-t) {
						result = 360-t;
					}
				}else {
					if(result<t) {
						result = t;
					}
				}
			}
		}
//		if(result>180) {
//			System.out.println("--------check2--------"+result);
//		}
		return result;
	}
	private static double check(List<Double> list, List<Double> list2, int i) {
		list.sort(new Comparator<Double>() {
			public int compare(Double o1, Double o2) {
				if(o1>o2){
					return 1;
				}else {
					return -1;
				}
			}
		});
		list2.sort(new Comparator<Double>() {
			public int compare(Double o1, Double o2) {
				if(o1>o2){
					return 1;
				}else {
					return -1;
				}
			}
		});
		List<Double> temp;
		if(list.get(0)>list2.get(0)) {
			temp = list;
			list = list2;
			list2 = temp;
		}
		double result = 0;
		if(i>=1) {
			result = list2.get(list2.size()-1)-list.get(0);
			if(result > sum) {
				msv1 = list2.get(list2.size()-1);
				msv2 = list.get(0);
			}
		}else {
			result = 180-(list2.get(0)-(list.get(list.size()-1)+180));
			if(result > sum) {
				msv1 = list.get(list.size()-1);
				msv2 = list2.get(0);
			}
		}
//		if(result>180) {
//			System.out.println("--------check--------"+result);
//		}
		return result;
	}
}

package com.company.test2018_021.questions;

import java.io.*;
import java.util.*;

/*
	题目描述
		小Q十分富有，拥有非常多的硬币，小Q拥有的硬币是有规律的，对于所有的非负整数K，小Q恰好各有两个
		面值为2^K的硬币，所以小Q拥有的硬币就是1,1,2,2,4,4,8,8,…。小Q有一天去商店购买东西需要支付
		n元钱，小Q想知道有多少种方案从他拥有的硬币中选取一些拼凑起来恰好是n元（如果两种方案某个面值的
		硬币选取的个数不一样就考虑为不一样的方案）。

	输入描述:
		输入包括一个整数n(1≤n≤10^18)，表示小Q需要支付多少钱。注意n的范围。
	输出描述:
		输出一个整数，表示小Q可以拼凑出n元钱放的方案数。
	示例1
		输入
			6
		输出
			3
			
	个人说明：
		没太懂什么意思，但是推导出来的公式应该是：
		a(n) = a(n-2^(log2(n)))+a(2^(log2(n)+1)-n-2)   所有计算的对数和指数均取整
	
 */
public class Question_028 {
	static Map<Long, Long> map = new HashMap<Long, Long>();
	public static void main(String[] args) throws Exception {
		map.put(-1L, 0L);
		map.put(0L, 1L);
		map.put(1L, 1L);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Long n = Long.valueOf(br.readLine());
		long result = check(n);
		System.out.println(result);
	}
	private static long check(Long n) {
		if(map.containsKey(n)) {
			return map.get(n);
		}
		Long log = log2(n);
		Long r = check(n-(long)Math.pow(2, log))+check((long)Math.pow(2, log+1)-n-2);
		map.put(n, r);
		return r;
	}
	private static Long log2(Long n) {
		return (long) (Math.log(n)/Math.log(2));
	}
	
}

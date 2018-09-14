package com.company.baidu.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
	 比赛组队（百度2017秋招真题）

									题目描述
									
	为活跃公司文化，公司计划组织一场比赛，让员工一展才艺。现有n个员工，欲选出不少于k人组成一支队伍，1＜=n＜ =12,1＜=k＜=n。
	每个员工有个value值，表示其对队伍水平的贡献，-1000＜=value＜=1000，给出一个矩阵对角线为0的对称矩阵A， A[i][j]表示i,j
	同在队伍中时对队伍水平的贡献，为取得最好成绩，公司领导希望知道水平最高的组队方式能够达到的水平和组队方案数。
	
	
	输入
	第一行为测试样例组数Te（Te＜=100）。每组测试样例的第一行是两个数 n,k，第二行为n个数，表示每个人对队伍水平的贡献值，接下来有n行，每行有n个数，表示构成矩阵A的元素。
	样例输入
	1
	2 1
	100 -5
	0 10
	10 0
	输出
	每组测试样例输出一行，分别为能够达到的最高水平值和组队方案数。
	样例输出
	105 1
	
 */
public class Question_008 {

	public static <E> List<E> arrangeSelect(List<E> data, List<E> target, int k, List<E> result) {
		List<E> copyData;
		List<E> copyTarget;
		if (target.size() == k) {
			StringBuffer buffer = new StringBuffer();
			for (E i : target) {
				buffer.append(i);
			}
			result.add((E) buffer);
		}

		for (int i = 0; i < data.size(); i++) {
			copyData = new ArrayList<E>(data);
			copyTarget = new ArrayList<E>(target);

			copyTarget.add(copyData.get(i));
			copyData.remove(i);

			result = arrangeSelect(copyData, copyTarget, k, result);
		}
		return result;
	}

	/**
	 * 组合公式递归算法；计算C(n,m)
	 * 
	 * @param cs
	 *            传入的集合
	 * @param begin
	 *            第一个元素开始位置
	 * @param number
	 *            总共要取的元素个数
	 * @param list
	 *            临时集合
	 * @param result
	 *            返回的结果
	 * @return
	 */
	public static List<List<Character>> combine(char[] cs, int begin, int number, List<Character> list,
			List<List<Character>> result) {
		if (number == 0) {
			result.add(clone(list));
			// System.out.println(list.toString());
			return result;
		}
		if (begin == cs.length) {
			return result;
		}
		list.add(cs[begin]);
		result = combine(cs, begin + 1, number - 1, list, result);
		list.remove((Character) cs[begin]);
		result = combine(cs, begin + 1, number, list, result);
		return result;
	}

	public static List<Character> clone(List<Character> result) {
		List<Character> list = new ArrayList<>();
		list.addAll(result);
		return list;
	}

	public static void main(String args[]) {
		char chs[] = { 'a', 'b', 'c', 'd' };
		List<Character> list = new ArrayList<Character>();
		List<List<Character>> res = new ArrayList<List<Character>>();
		// res = combine(chs, 0, 3, list, res);
		// System.out.println(res);
		// System.out.println(res.size());
		List<Character> data = new ArrayList<Character>();
		data.add('a');
		data.add('b');
		data.add('c');
		data.add('d');
		List<Character> result = new ArrayList<Character>();

		result = arrangeSelect(data, new ArrayList<Character>(), 3,result);
		System.out.println(result);
		System.out.println(result.size());
	}

}

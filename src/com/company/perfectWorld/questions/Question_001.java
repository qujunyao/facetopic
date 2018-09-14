package com.company.perfectWorld.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/*
 * 即时战略游戏编队（完美世界2017秋招真题）
 *
 *									题目描述
 *								
 * 你正在玩一个RST（即时战略）游戏。此时你已经有很多队士兵，每一队里的士兵战队力相同。该游戏士兵种类以战斗力区分，既战斗力一样的士兵算作一种。你想重新调整编队，
 * 将现有的队列合并成战斗力相同的两队，请想出有多少种编队方法吧。
 * 
 * 比如：你现在有两队士兵，第一队有4个士兵，每个士兵战斗力都是1，第二队有2个士兵，每个士兵战斗力都是2. 这时你有三种编队方法，
 * 可以将这些士兵合并成战斗力相同的两个队伍：
 * 方法一：队伍1有4个战斗力为1的士兵，队伍2有2个战斗力为2的士兵，两队的战斗力都是4
 * 方法二：队伍1有2个战斗力为2的士兵，队伍2有4个战斗力为1的士兵，两队的战斗力都是4
 * 方法三：队伍1有2个战斗力为1的士兵和1个战斗力为2的士兵，队伍2有2个战斗力为1的士兵和1个战斗力为2的士兵，两队的战斗力都是4
 *
 * 时间限制
 * C/C++语言：2000MS其它语言：4000MS
 * 
 * 内存限制
 * C/C++语言：65536KB其它语言：589824KB
 * 
 * http://exercise.acmcoder.com/online/online_judge_ques?ques_id=3353&konwledgeId=157
 *
 */
public class Question_001 {

	/*
	 * 我的答案
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String numsL = scanner.nextLine();
		String valsL = scanner.nextLine();
		numsL = numsL.substring(1, numsL.length() - 1);
		valsL = valsL.substring(1, valsL.length() - 1);
		String[] numss = numsL.split(",");
		String[] valss = valsL.split(",");
		int[] nums = new int[numss.length];
		int[] vals = new int[numss.length];
		int m = 0;
		Map<Integer, Integer> map = new HashMap<>();
		long count = 1;
		for (int i = 0; i < valss.length; i++) {
			nums[i] = Integer.parseInt(numss[i].trim());
			vals[i] = Integer.parseInt(valss[i].trim());
			if (map.containsKey(vals[i])) {
				map.put(vals[i], nums[i] + map.get(vals[i]));
			} else {
				map.put(vals[i], nums[i]);
			}
			m += (nums[i] * vals[i]);
			count = count * (nums[i] + 1);
		}
		if (m % 2 != 0) {
			System.out.println(0);
			scanner.close();
			return;
		}
		nums = new int[map.size()];
		vals = new int[map.size()];
		int c = 0;
		for(Entry<Integer, Integer> key :map.entrySet()) {
			nums[c] = key.getValue();
			vals[c++] = key.getKey();
		}
		m = m / 2;
		int result = 0;
		int[] arg = nums;
		for (int i = 1; i <= count; i++) {
			arg = getArgs(arg, nums, 0);
			if (call(arg, vals) == m) {
				print(arg);
				result++;
			}
		}
		scanner.close();
		System.out.println(result);
	}

	/**
	 * 打印数组
	 * @param arg
	 */
	private static void print(int[] arg) {
		for (int t : arg) {
			System.out.print(t + " ");
		}
		System.out.println();
	}

	/**
	 * 计算arg中的下标元素乘以对应vals中下标元素的总和
	 * 
	 * 例：arg{1,2,3}
	 *    vals{2,3,4}
	 *    总和为：1*2+2*3+3*4=20
	 * @param arg
	 * @param vals
	 * @return
	 */
	private static int call(int[] arg, int[] vals) {
		int sum = 0;
		for (int i = 0; i < arg.length; i++) {
			sum = sum + arg[i] * vals[i];
		}
		return sum;
	}

	/**
	 * 数组的数，递减一个单位。
	 * 
	 * 例如： 原数组为{3，4，7，7} 从第一个元素开始递减。 当前数组为{2，3，4，5}，递减一个单位后变成{1，3，4，5}
	 * 当前数组为{0，0，1，6}，递减一个单位后变成{3，4，0，6} 当前数组为{0，0，0，0}，不递减，直接返回{0，0，0，0}
	 * 
	 * @param arg
	 *            当前数组
	 * @param nums
	 *            原数组
	 * @param length
	 *            从第几个元素开始递减
	 * @return
	 */
	private static int[] getArgs(int[] arg, int[] nums, int length) {
		if (arg[length] - 1 < 0) {
			int[] result = new int[arg.length];
			result[length] = nums[length];
			for (int i = 1; i < arg.length - length; i++) {
				if (i == arg.length - 1) {
					if (arg[i] - 1 < 0) {
						return new int[arg.length];
					}
				}
				if (arg[length + i] - 1 < 0) {
					result[length + i] = nums[length + i];
				} else {
					result[length + i] = arg[length + i] - 1;
					for (int j = length + i + 1; j < arg.length; j++) {
						result[j] = arg[j];
					}
					break;
				}
			}
			return result;
		} else {
			int[] result = new int[arg.length];
			result[length] = arg[length] - 1;
			for (int i = length + 1; i < arg.length; i++) {
				result[i] = arg[i];
			}
			return result;
		}
	}
}

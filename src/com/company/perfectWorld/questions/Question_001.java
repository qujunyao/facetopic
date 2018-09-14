package com.company.perfectWorld.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/*
 * ��ʱս����Ϸ��ӣ���������2017�������⣩
 *
 *									��Ŀ����
 *								
 * ��������һ��RST����ʱս�ԣ���Ϸ����ʱ���Ѿ��кܶ��ʿ����ÿһ�����ʿ��ս������ͬ������Ϸʿ��������ս�������֣���ս����һ����ʿ������һ�֡��������µ�����ӣ�
 * �����еĶ��кϲ���ս������ͬ�����ӣ�������ж����ֱ�ӷ����ɡ�
 * 
 * ���磺������������ʿ������һ����4��ʿ����ÿ��ʿ��ս��������1���ڶ�����2��ʿ����ÿ��ʿ��ս��������2. ��ʱ�������ֱ�ӷ�����
 * ���Խ���Щʿ���ϲ���ս������ͬ���������飺
 * ����һ������1��4��ս����Ϊ1��ʿ��������2��2��ս����Ϊ2��ʿ�������ӵ�ս��������4
 * ������������1��2��ս����Ϊ2��ʿ��������2��4��ս����Ϊ1��ʿ�������ӵ�ս��������4
 * ������������1��2��ս����Ϊ1��ʿ����1��ս����Ϊ2��ʿ��������2��2��ս����Ϊ1��ʿ����1��ս����Ϊ2��ʿ�������ӵ�ս��������4
 *
 * ʱ������
 * C/C++���ԣ�2000MS�������ԣ�4000MS
 * 
 * �ڴ�����
 * C/C++���ԣ�65536KB�������ԣ�589824KB
 * 
 * http://exercise.acmcoder.com/online/online_judge_ques?ques_id=3353&konwledgeId=157
 *
 */
public class Question_001 {

	/*
	 * �ҵĴ�
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
	 * ��ӡ����
	 * @param arg
	 */
	private static void print(int[] arg) {
		for (int t : arg) {
			System.out.print(t + " ");
		}
		System.out.println();
	}

	/**
	 * ����arg�е��±�Ԫ�س��Զ�Ӧvals���±�Ԫ�ص��ܺ�
	 * 
	 * ����arg{1,2,3}
	 *    vals{2,3,4}
	 *    �ܺ�Ϊ��1*2+2*3+3*4=20
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
	 * ����������ݼ�һ����λ��
	 * 
	 * ���磺 ԭ����Ϊ{3��4��7��7} �ӵ�һ��Ԫ�ؿ�ʼ�ݼ��� ��ǰ����Ϊ{2��3��4��5}���ݼ�һ����λ����{1��3��4��5}
	 * ��ǰ����Ϊ{0��0��1��6}���ݼ�һ����λ����{3��4��0��6} ��ǰ����Ϊ{0��0��0��0}�����ݼ���ֱ�ӷ���{0��0��0��0}
	 * 
	 * @param arg
	 *            ��ǰ����
	 * @param nums
	 *            ԭ����
	 * @param length
	 *            �ӵڼ���Ԫ�ؿ�ʼ�ݼ�
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

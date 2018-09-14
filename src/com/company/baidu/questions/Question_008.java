package com.company.baidu.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
	 ������ӣ��ٶ�2017�������⣩

									��Ŀ����
									
	Ϊ��Ծ��˾�Ļ�����˾�ƻ���֯һ����������Ա��һչ���ա�����n��Ա������ѡ��������k�����һ֧���飬1��=n�� =12,1��=k��=n��
	ÿ��Ա���и�valueֵ����ʾ��Զ���ˮƽ�Ĺ��ף�-1000��=value��=1000������һ������Խ���Ϊ0�ĶԳƾ���A�� A[i][j]��ʾi,j
	ͬ�ڶ�����ʱ�Զ���ˮƽ�Ĺ��ף�Ϊȡ����óɼ�����˾�쵼ϣ��֪��ˮƽ��ߵ���ӷ�ʽ�ܹ��ﵽ��ˮƽ����ӷ�������
	
	
	����
	��һ��Ϊ������������Te��Te��=100����ÿ����������ĵ�һ���������� n,k���ڶ���Ϊn��������ʾÿ���˶Զ���ˮƽ�Ĺ���ֵ����������n�У�ÿ����n��������ʾ���ɾ���A��Ԫ�ء�
	��������
	1
	2 1
	100 -5
	0 10
	10 0
	���
	ÿ������������һ�У��ֱ�Ϊ�ܹ��ﵽ�����ˮƽֵ����ӷ�������
	�������
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
	 * ��Ϲ�ʽ�ݹ��㷨������C(n,m)
	 * 
	 * @param cs
	 *            ����ļ���
	 * @param begin
	 *            ��һ��Ԫ�ؿ�ʼλ��
	 * @param number
	 *            �ܹ�Ҫȡ��Ԫ�ظ���
	 * @param list
	 *            ��ʱ����
	 * @param result
	 *            ���صĽ��
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

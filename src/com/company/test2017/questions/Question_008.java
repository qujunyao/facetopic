package com.company.test2017.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
	��Ŀ����
		һֻ����Ҫ�Ӻ���������Ӷ԰����Ӻܿ����Ǻ��м���˺ܶ�׮�ӣ�ÿ��һ�׾���һ����ÿ��׮���϶���һ�����ɣ�
		�������������ϾͿ������ĸ�Զ��ÿ������������ͬ����һ�����ִ������������������������Ϊ5���ʹ��������һ
		������ܹ���5�ף����Ϊ0���ͻ��ݽ�ȥ�޷�������Ծ������һ��N�׿������ʼλ�þ��ڵ�һ���������棬Ҫ����
		���һ������֮���������ˣ�����ÿ�����ɵ������������������Ҫ�������ܹ�����԰�������޷��������-1
	��������:
		��������У���һ�������鳤��N (1 �� N �� 10000)���ڶ�����ÿһ���ֵ���ÿո�ָ���
	�������:
		������ٵ��������޷��������-1
		
	ʾ��1
		����
			5
			2 0 1 1 1
		���
			4
 */
public class Question_008 {
	public static void main(String[] args) {
		Scanner s = new  Scanner(System.in);
		int n = s.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0;i<n;i++) {
			list.add(s.nextInt());
		}
		s.close();
		int index = 0;
		int i = 0;
		while(true) {
			int[] max = {0,0};
			int start = list.get(i)+i;
			if(start>list.size()-1) {
				break;
			}
			for(int j = start;j>i;j--) {
				if(list.get(j)==0) {
					continue;
				}
				int temp = j+list.get(j);
				if(max[0]<temp) {
					max[0] = temp;
					max[1] = j;
				}
			}
			i = max[1];
			if(i==0) {
				break;
			}else {
				index++;
			}
		}
		if(index==0) {
			index--;
		}else {
			index++;
		}
		System.out.println(index);
	}
}

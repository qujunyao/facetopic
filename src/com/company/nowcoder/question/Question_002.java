package com.company.nowcoder.question;

import java.util.Scanner;

/*
	��Ŀ����
	СAA�ҵ���һ�����У�����Ҫ֪��������������г���Ϊż������������֮�� ��
	�����������������̫���ˣ�����������һ�����ƣ�Ҫ�����䳤����[L,R]֮�䣬
	Ȼ�����Ͳ����ˡ�����
	�������������Ĵ𰸡�
	
	��������:
	��һ�������� n, L, R(n<=105,1<=L<=R<=n)
	�ڶ���n������ʾ������С�(ai<=109)
	�������:
	���һ�б�ʾ�𰸣����ڴ𰸿��ܴܺ��������ģ109+7��ֵ��
	
	ʾ��1
	����
	5 1 5
	1 2 3 4 5
	���
	16
	
	ʾ��2
	����
	4 1 4
	4 4 4 4
	���
	0
 */
public class Question_002 {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int n = input.nextInt();
		int m = input.nextInt();
		int k = input.nextInt();
		int s1 = n * m / result(n, m);
		int s2 = s1 *k /result(s1, k);
		System.out.println(s2);
		input.close();
	}
	
	static int result(int a,int b)
	{
	    return b==0?a:result(b,a%b);
	}

}

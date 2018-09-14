package com.company.baidu.questions;

import java.util.Scanner;

/*
							�˷����ٶ�2016ʵϰ�����⣩
	 
									��Ŀ����
	
	�ȶ��ܺ�үү����һ���˷�����Ϸ���˷���ĵ�i�е�j��λ�õ�Ԫ��Ϊi*j�����ҳ˷����±��Ŵ�1��ʼ������2*3�˷���Ϊ
	1 2 3
	2 4 6
	үүʮ�ִ���������n*m�ĳ˷���ֻҪ�ȶ��ܸ���һ����k��үү�������̸��߶ȶ��ܳ˷�����Ԫ�ذ��ղ���˳������֮�󣬵�k��Ԫ���Ƕ��١������ظ������Ϸ��
 */
public class Question_001 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLong()) {
			long n = scanner.nextLong();
			long m = scanner.nextLong();
			long k = scanner.nextLong();

			long left = 0;
			long right = n * m;
			long mid = 0;
			while (left <= right) {
				//���ö��ַ����в����м������ڵ�λ��
				mid = (left + right) / 2;
				if (find(mid, n, m) >= k) {
					right = mid - 1;
				} else {
					left = mid + 1;//���һ��ѭ��������
				}
			}
			System.out.println(left);
		}
		scanner.close();
	}
	
	/**
	 * ��ȡmid��n*m�ĳ˷����еİ���˳���λ��
	 * @param mid
	 * @param n
	 * @param m
	 * @return
	 */
	private static Long find(long mid, long n, long m) {
		long c = 0;
		for (int j = 1; j <= n; j++) {
			if (mid < j * m) {
				//��һ�е��������mid����Ϊ��һ�е�����j�������������ԣ���midС��������mid/j��ȡ������
				//���� ��һ��Ϊ��j=4,m=4[4��8��12��16]    midΪ15�����midС������Ϊ 15/4=3
				c += mid / j;
				
				//�����е�Ԫ�ض���mid����ÿ�ζ���0��û�����壬����ж�ѭ�������Ч�ʡ�
				if(mid/j==0) {
					break;
				}
			} else {
				//��һ�е����������midС����ômid���������������ֵĺ��档����λ������������һ�����ָ���������
				c += m;
			}
		}
		return c;
	}
}

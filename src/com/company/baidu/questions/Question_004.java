package com.company.baidu.questions;

import java.util.Scanner;

/*
	 							 ʮ�ּܣ��ٶ�2017�������⣩
	
										��Ŀ����
										
	СA��ϲ��ʮ�ּܣ���ϲ���ø��ַ�ʽ����ʮ�ּܵ����ӡ�СA������򵥵�ʮ�ּ����Ч�����������¶�����һ�ָߴ��ϵ�ʮ�ּ������ʽ��
	��һ��n(1��n��10) , �����Ӧ��ͼ�Σ�������ʽ���£�
	1.��n=1��ʱ�����һ��Сд��ĸ"o" :
	o
	2.��n��2��ʱ�򣬸���n=n-1ʱ���ͼ�񣬲�����n-1ͼ����ϡ��¡����Ҷ�ճ��һ��һģһ����ͼ�Ρ�
	��n=2ʱ����ԭͼ"o"���������Ҷ�ճ��һ��"o",������������������һ��ͼ�Σ�
	  o
	 ooo
	  o
  
	����
	�����������ݣ���һ������������T(T��10)�������T�У�ÿ������ռһ�У����а���һ������n(1 �� n �� 10) �� 

	���
	����ÿ���������Case #x:����x��ʾ���ǵڼ������ݣ����������������Ӧͼ�Ρ�
	ע��ÿ������ַ���Ӧ����o�������ҵ���һ�е��ַ�����ͬ�������Ӧλ��û����ĸo��������һ��λ�����һ���ո�

 */
public class Question_004 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Integer t = Integer.valueOf(scanner.nextLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.valueOf(scanner.nextLine());
			System.out.println("Case #" + (i + 1) + ":");
			String[] arr = new String[(int) Math.pow(3, n - 1)];
			arr[0] = "o";
			for (int j = 2; j <= n; j++) {
				int temp = (int) Math.pow(3, j - 2);
				String blank = "";
				for (int k = 0; k < temp; k++) {
					blank += " ";
				}
				for (int k = temp; k < 2 * temp; k++) {
					arr[k] = arr[k - temp] + arr[k - temp] + arr[k - temp];
				}
				for (int k = temp * 2; k < (int) Math.pow(3, j - 1); k++) {
					arr[k] = blank + arr[k - 2 * temp] + blank;
				}
				for (int k = 0; k < temp; k++) {
					arr[k] = blank + arr[k] + blank;
				}
			}
			for (int j = 0;j<arr.length;j++) {
				System.out.println(arr[j]);
			}
		}
		scanner.close();
	}
}

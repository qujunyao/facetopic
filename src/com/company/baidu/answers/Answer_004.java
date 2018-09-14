package com.company.baidu.answers;

import java.util.Scanner;

public class Answer_004 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		//��һ��ѭ������ĸ���
		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			System.out.println("Case #" + (i + 1) + ":");
			//����һ��ʮ�ּ��������ȵ����顣
			String[] result = new String[(int) Math.pow(3, n - 1)];
			//�ȸ���һ��Ԫ�ظ�ֵ��o����
			result[0] = "o";
			//�ڶ���ѭ��n������
			for (int j = 1; j < n; j++) {
				//����ո�ĸ�����
				int m = (int) Math.pow(3, j - 1);
				String blank = "";
				//������ѭ���ۼӿո�
				for (int k = 0; k < m; k++) {
					blank += " ";
				}
				//������ѭ�����ȴӵڶ����λ�ÿ�ʼ��ͼ�����ǵ�һ��ͼ��������
				for (int k = m; k < 2 * m; k++) {
					result[k] = result[k - m] + result[k - m] + result[k - m];
				}
				//������ѭ����Ȼ��ӵ������λ�ÿ�ʼ��ͼ�������ڵ�һ��ͼ�ε����߼��Ͽո�
				for (int k = 2 * m; k < 3 * m; k++) {
					result[k] = blank + result[k - 2 * m] + blank;
				}
				//������ѭ��������ٻ���һ���ͼ�������ڵ�һ��ͼ�ε����߼��Ͽո�
				for (int k = 0; k < m; k++) {
					result[k] = blank + result[k] + blank;
				}
			}
			for (int k = 0; k < result.length; k++) {
				System.out.println(result[k]);
			}
		}
		scanner.close();
	}
}

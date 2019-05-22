package com.company.test2018_021.answers;

import java.io.*;

public class Answer_029 {
	public static void main(String args[]) throws IOException {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		int n = Integer.valueOf(br.readLine());
		double[] f = new double[n];
		for (int i = 0; i < n; i++) {
			f[i] = Double.valueOf(br.readLine());
		}

		double max = 0.0; // Բ��������������������
		int samll = 0; // ��ʼָ��
		int big = 1; // ����ָ��

		while (big < n) {
			// �����������diff
			double diff = f[big] - f[samll];
			// ���diff����180
			if (Double.compare(diff, 180.0) > 0) {
				double dif = Math.abs(f[big] - f[samll]);
				// dif����180��ȡ��360-dif��,��֮��ȡdif
				double dist = 360.0 - dif;
				// ������Ե�������ľ������max��dist����max��ͬʱsmall�����ƶ�
				if (dist > max)
					max = dist;
				samll++;
			} else {
				// diff����max��big�����ƣ����տ�ʼ��һֱ�����ƣ�ֱ������180Ϊֹ��
				if (diff > max)
					max = diff;
				big++;
			}
		}
		System.out.printf("%.8f\n", max);
	}

}

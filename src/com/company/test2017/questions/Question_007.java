package com.company.test2017.questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/*
	��Ŀ����
		���еĵ�һ��Ϊn���Ժ����Ϊǰһ���ƽ�����������е�ǰm��ĺ͡�
	��������:
		���������ж��飬ÿ��ռһ�У�����������n��n < 10000����m(m < 1000)��ɣ�n��m�ĺ�����ǰ������
	�������:
		����ÿ���������ݣ���������еĺͣ�ÿ������ʵ��ռһ�У�Ҫ�󾫶ȱ���2λС����
	
	ʾ��1
		����
		81 4
		2 2
		���
		94.73
		3.41
 */
public class Question_007 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		while ((str = bf.readLine()) != null) {
			String[] arr = str.split(" ");
			double m = Integer.valueOf(arr[0]);
			int n = Integer.valueOf(arr[1]);
			double sum = m+0;
			for(int i = 1;i<n;i++) {
				m = Math.sqrt(m);
				sum+=m;
			}
			DecimalFormat df = new DecimalFormat("#.00");
			System.out.println(df.format(sum));
		}
	}
}

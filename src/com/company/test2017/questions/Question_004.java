package com.company.test2017.questions;

import java.util.Scanner;

/*
	��Ŀ����
		������һ�úϷ��Ķ����������Ľڵ㶼�������ֱ�ʾ�����ڸ�������������еĸ��ӹ�ϵ����������ĸ߶�
	��������:
		����ĵ�һ�б�ʾ�ڵ�ĸ���n��1 �� n �� 1000���ڵ�ı��Ϊ0��n-1����ɣ�
		������n-1�У�ÿ����������������һ������ʾ���ڵ�ı�ţ��ڶ�������ʾ�ӽڵ�ı��
	�������:
		������ĸ߶ȣ�Ϊһ������
	
	ʾ��1
	����
		5
		0 1
		0 2
		1 3
		1 4
	���
		3
 */
public class Question_004 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		int [] h1 = new int[k];//�ڵ�߶�
		int [] h2 = new int[k];//�ڵ����
		h1[0] = 1;
		int max = 0;
		for (int i = 0; i < k-1; i++) {
			int a = scanner.nextInt();//���ڵ�
			int b = scanner.nextInt();//�ӽڵ�
			h2[a] = h2[a]+1;
			if(h2[a]<3){
                h1[b] = h1[a]+1;
            }
			if(max<h1[b]) {
				max = h1[b];
			}
		}
		System.out.println(max);
		scanner.close();
	}
}

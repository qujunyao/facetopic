package com.company.test2017.questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
	��Ŀ����
		��һ����ɫ��ʯ���������ɺܶ��ֲ�ͬ�ı�ʯ��ɵģ������챦ʯ������ʯ����ʯ����䣬����ȡ�
		��һ������������ʹ͸���һ��ѧ�ߣ�������˵������Դ����������������������ϲ���챦ʯ��
		����ʯ����ˮ����������ʯ�����֣���Ҫ��������н�ȡ������һС�λ����ң���һ���б����
		�����е������ֱ�ʯ��ʣ�µĲ�������Դ��ߡ�����޷��ҵ���һ��Ҳ�޷����ߡ������ѧ���ҳ���
		���з��������ܹ��õ����ı�ʯ��
	��������:
		������ÿ���ַ�����һ�ֱ�ʯ��A��ʾ�챦ʯ��B��ʾ����ʯ��C������ˮ����D������䣬E������ʯ��
		F������ʯ��G�������ȵȣ�������һ��ȫ��Ϊ��д��ĸ���ַ����б�ʾ�����ı�ʯ���У�ע������
		����β��ӵġ�ÿ�д���һ�������
	�������:
		���ѧ���ܹ��õ������ı�ʯ������ÿ��һ��
	ʾ��1
		����
		ABCYDYE
		ATTMBQECPD
		
		���
		1
		3
 */
public class Question_009 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null){
        	str = str+str;
        	char[]temp = str.toCharArray();
        	int[] index= {-1,-1,-1,-1,-1};
        	int maxlen = Integer.MAX_VALUE;
        	for(int i = 0;i<temp.length;i++) {
        		if(temp[i]<='E'&&temp[i]>='A') {
        			index[temp[i]-'A']=i;
        			if(isFull(index)) {
        				int len = compet(index);
        				if(maxlen>len) {
        					maxlen = len;
        				}
        			}
        		}
        	}
        	System.out.println((temp.length/2)-maxlen);
        }
	}

	private static int compet(int[] index) {
		int minlen = Integer.MAX_VALUE;
		int maxlen = Integer.MIN_VALUE;
		for(int i=0;i<index.length;i++) {
			if(index[i]>maxlen) {
				maxlen = index[i];
			}
			if(index[i]<minlen) {
				minlen = index[i];
			}
		}
		return maxlen-minlen+1;
	}

	private static boolean isFull(int[] index) {
		for(int i = 0;i<index.length;i++) {
			if(index[i]<0) {
				return false;
			}
		}
		return true;
	}
	
}

package com.company.test.questions;

import java.util.Scanner;

/*
	��Ŀ����
		nowcoder�ڼҼ������ģ�����������ֽ��ʼͳ�������ĸ�����
		�躯��f(n)���ش�1-n֮�������ĸ�����
		nowcoder ����:
		f(1)   = 0
		f(10)  = 4
		f(100) = 25
		...
		����g(m) = 17 * m^2 / 3 - 22 * m / 3 + 5 / 3
		����mΪn��λ����
		���ܼ������ǲ����Լ������������ֲ��Ĺ����ˣ�
		�������һ���������f(n)������֤nowcoder�ǲ�����ȷ�ģ�Ҳ�����Ե�ŵ�������ء�^_^
	
	��������:
		��������������ݡ�
		ÿ�����ݽ���һ������n (1��n��10000000)��
		
	�������:
		����ÿ���������룬���һ�У�Ϊ1->n(����n)֮��������ĸ�����
	
	ʾ��1
	����
		1
		10
		65
		100
		0
	���
		0
		4
		18
		25
 */
public class Question_001 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] prepare = {0, 4, 25, 168, 1229, 9592, 78498, 664579};
        while (sc.hasNext()) {
            String s = sc.next();
            if(s.equals("0")) break;
            int a = prepare[s.length() - 1];
            for (int i = (int)Math.pow(10, s.length() - 1); i < Integer.parseInt(s); i ++ ) {
                if(isPrime(i)) a ++ ;
            }
            System.out.println(a);
        }
        sc.close();
    }
 
    public static boolean isPrime(int num) {
        if(num == 0 || num == 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i ++ ) {
            if(num % i == 0) return false;
        }
        return true;
    }
}

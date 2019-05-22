package com.company.test2018_021.answers;

import java.util.*;

public class Answer_028 {
	private static HashMap<Long,Long> mem = new HashMap<Long,Long>();//����¼,�洢ÿ����ֵn��ƴ�շ�����
    static {
        mem.put(-1L, 0L);
        mem.put(0L, 1L);
        mem.put(1L, 1L);
    }
    private static long n;//��ֵ
     
    /**
     * ��2Ϊ��n�Ķ���
     * @param n
     * @return
     */
    private static long log2(long n) {
        return (long)(Math.log(n)/Math.log(2));
    }
     
    /**
     * �����ֵΪn��ƴ��Ӳ�ҷ�����
     * @param args
     */
    private static long getNum(long n) {
         
        if(mem.containsKey(n)) return mem.get(n);
        else {
            long k = log2(n);//���������2��ָ��k
            long result = getNum(n - (long)Math.pow(2, k)) + getNum((long)Math.pow(2,k+1)-2-n);
            mem.put(n,result);//�����Ѿ������ֵ
            return result;
        }
    }
     
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextLong();
         
        System.out.println(getNum(n));
        s.close();
         
    }
}


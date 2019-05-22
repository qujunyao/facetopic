package com.company.test2018_021.answers;

import java.util.*;

public class Answer_028 {
	private static HashMap<Long,Long> mem = new HashMap<Long,Long>();//备忘录,存储每种面值n的拼凑方案数
    static {
        mem.put(-1L, 0L);
        mem.put(0L, 1L);
        mem.put(1L, 1L);
    }
    private static long n;//面值
     
    /**
     * 以2为底n的对数
     * @param n
     * @return
     */
    private static long log2(long n) {
        return (long)(Math.log(n)/Math.log(2));
    }
     
    /**
     * 获得面值为n的拼凑硬币方案数
     * @param args
     */
    private static long getNum(long n) {
         
        if(mem.containsKey(n)) return mem.get(n);
        else {
            long k = log2(n);//求出题意中2的指数k
            long result = getNum(n - (long)Math.pow(2, k)) + getNum((long)Math.pow(2,k+1)-2-n);
            mem.put(n,result);//记忆已经求过的值
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


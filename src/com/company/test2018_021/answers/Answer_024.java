package com.company.test2018_021.answers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
/**
 * aMin: 序列中的最小值
 * aMax: 序列中的最大值
 *
 * 分三种情况：
 * (1)aMin和aMax都在正确位置，即 aMin==a[0] && aMax==a[n]
 * (2)aMin和aMax都不在正确位置，即 aMin!=a[0] && aMax!=a[n]
 * (3)aMin和aMax只有一个在正确位置，即 aMin==a[0] || aMax==a[n]
 *
 * res: 使整个序列变为升序所需要的最少操作次数
 * 对于第一种情况：如果原序列已是升序，则res=0，否则res=1
 * 对于第二种情况：res=2
 * 对于第三种情况：res=1
 *
 */
public class Answer_024 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            String[] strs = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(strs[i]);
            }
 
            int aMin = a[0], aMax = a[0];
            boolean isSorted = true;
            for (int i = 1; i < n; i++) {
                aMin = Math.min(aMin, a[i]);
                aMax = Math.max(aMax, a[i]);
                if (a[i - 1] > a[i]) isSorted = false;
            }
            int res = (aMin != a[0] && aMax != a[n - 1]) ? 2 : (isSorted ? 0 : 1);
            System.out.println(res);
        }
    }
}


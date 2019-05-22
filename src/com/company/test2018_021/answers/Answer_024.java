package com.company.test2018_021.answers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
/**
 * aMin: �����е���Сֵ
 * aMax: �����е����ֵ
 *
 * �����������
 * (1)aMin��aMax������ȷλ�ã��� aMin==a[0] && aMax==a[n]
 * (2)aMin��aMax��������ȷλ�ã��� aMin!=a[0] && aMax!=a[n]
 * (3)aMin��aMaxֻ��һ������ȷλ�ã��� aMin==a[0] || aMax==a[n]
 *
 * res: ʹ�������б�Ϊ��������Ҫ�����ٲ�������
 * ���ڵ�һ����������ԭ��������������res=0������res=1
 * ���ڵڶ��������res=2
 * ���ڵ����������res=1
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


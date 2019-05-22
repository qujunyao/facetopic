package com.company.test2018_021.answers;

import java.util.*;

public class Answer_026 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] str = new String[2*n];
        for(int i = 0;i < 2*n;i++){
            str[i] = in.next();
        }
        in.close();
        int counter = 0;
        while(counter < 2*n){
            String temp1 = str[counter];
            String temp2 = str[counter+1];
            int x1 = Integer.valueOf(String.valueOf(temp1.charAt(0)));
            int y1 = Integer.valueOf(String.valueOf(temp2.charAt(0)));
            int x2 = Integer.valueOf(String.valueOf(temp1.charAt(1)));
            int y2 = Integer.valueOf(String.valueOf(temp2.charAt(1)));
            int x3 = Integer.valueOf(String.valueOf(temp1.charAt(2)));
            int y3 = Integer.valueOf(String.valueOf(temp2.charAt(2)));
            int x4 = Integer.valueOf(String.valueOf(temp1.charAt(3)));
            int y4 = Integer.valueOf(String.valueOf(temp2.charAt(3)));
            double a1 = Math.abs(x1-x4);
            double a2 = Math.abs(x2-x3);
            double b1 = Math.abs(y1-y4);
            double b2 = Math.abs(y2-y3);
            double c1 = Math.abs(x1-x2);
            double c2 = Math.abs(x1-x3);
            double d1 = Math.abs(y1-y2);
            double d2 = Math.abs(y1-y3);
            double tempNum1 = Math.sqrt(Math.pow(a1,2)+Math.pow(b1,2));
            double tempNum2 = Math.sqrt(Math.pow(a2,2)+Math.pow(b2,2));
            double tempNum3 = Math.sqrt(Math.pow(c1,2)+Math.pow(d1,2));
            double tempNum4 = Math.sqrt(Math.pow(c2,2)+Math.pow(d2,2));
            if(tempNum1==tempNum2 && tempNum3==tempNum4){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
            counter = counter + 2;
        }
    }
}


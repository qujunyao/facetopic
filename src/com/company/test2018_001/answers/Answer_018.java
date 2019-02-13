package com.company.test2018_001.answers;

import java.util.*;

public class Answer_018 {
	
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] s = str.toCharArray();
        int count = 0;
        for(int i = 0; i < str.length()-1;i++){
                if(s[i] != s[i+1])
                    count++;
        }
        sc.close();
        System.out.println(str.length()-count);
    }
}


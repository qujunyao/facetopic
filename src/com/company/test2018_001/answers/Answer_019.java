package com.company.test2018_001.answers;

import java.util.*;

public class Answer_019 {
	
	public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);   
        int l = sc.nextInt();
        int r = sc.nextInt();
        int w = sc.nextInt();
        if(r+w-l>1) {
        	System.out.println("DEADLOCK");
        }else {
        	System.out.println("OK");
        }
        sc.close();
    }
}


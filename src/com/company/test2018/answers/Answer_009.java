package com.company.test2018.answers;

import java.util.*;

public class Answer_009 {
	public static int isPasswdLength(String s){
        /**
        密码长度得分
        */
        if(s.length() <= 4){
            return 5;
        }else if(s.length() >=5 && s.length()<=7){
            return 10;
        }else{
            return 25;
        }
    }
     
    public static int hasAlphabet(String s){
        /**
        密码字母得分
        */
        int flag1=0;
        int flag2=0;
        for(int i=0;i < s.length();i++){
            char t = s.charAt(i);
            if(t > 'a' && t < 'z'){
                flag1 = 1;
            }
            if(t > 'A' && t < 'Z'){
                flag2 = 1;
            }
        }
        if(flag1 + flag2 == 2){
            return 20;
        }else if(flag1 + flag2 == 1){
            return 10;
        }else{
            return 0;
        }
    }
     
    public static int hasNumber(String s){
        /**
        密码数字得分
        */
        int flag1=0;
        for(int i=0;i < s.length();i++){
            char t = s.charAt(i);
            if(t >= '0' && t <= '9'){
                flag1++;
            }
        }
        if(flag1 > 1){
            return 20;
        }else if(flag1 == 1){
            return 10;
        }else{
            return 0;
        }
    }
     
    public static int hasOther(String s){
        /**
        密码符号得分
        */
        int flag1=0;
        for(int i=0;i < s.length();i++){
            char t = s.charAt(i);
            String str = t + "";
            if(hasAlphabet(str)==0 && hasNumber(str)==0){
                flag1++;
            }
        }
        if(flag1 > 1){
            return 25;
        }else if(flag1 == 1){
            return 10;
        }else{
            return 0;
        }
    }
     
    public static int hasReward(String s){
        /**
        密码奖励得分
        */
        if(hasAlphabet(s)==20 && hasNumber(s)>0 && hasOther(s)>0){
            return 5;
        }else if(hasAlphabet(s)>0 && hasNumber(s)>0 && hasOther(s)>0){
            return 3;
        }else if(hasAlphabet(s)>0 && hasNumber(s)>0){
            return 2;
        }else{
            return 0;
        }
    }
     
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        int level = 0;
        level=isPasswdLength(s)+hasAlphabet(s)+hasNumber(s)+hasOther(s)+hasReward(s);
        if(level >= 90){
            System.out.println("VERY_SECURE");
        }else if(level >= 80){
            System.out.println("SECURE");
        }else if(level >= 70){
            System.out.println("VERY_STRONG");
        }else if(level >= 60){
            System.out.println("STRONG");
        }else if(level >= 50){
            System.out.println("AVERAGE");
        }else if(level >= 25){
            System.out.println("WEAK");
        }else{
            System.out.println("VERY_WEAK");
        }
    }
}

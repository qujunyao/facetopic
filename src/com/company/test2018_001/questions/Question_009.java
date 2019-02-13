package com.company.test2018_001.questions;

import java.util.*;

/*
	题目描述
	现公司要�?发一个业务管理系统，要求注册环节的密码需要提示用户其安全等级，密码按如下规则进行计分，并根据不同的得分为密码进行安全等级划分�?
	       �?、密码长�?:
	       5 �?: 小于等于4 个字�?
	       10 �?: 5 �?7 字符
	       25 �?: 大于等于8 个字�?
	       二�?�字�?:
	       0 �?: 没有字母
	       10 �?: 全都是小（大）写字母
	       20 �?: 大小写混合字�?
	       三�?�数�?:
	       0 �?: 没有数字
	       10 �?: 1 个数�?
	       20 �?: 大于1 个数�?
	       四�?�符�?:
	       0 �?: 没有符号
	       10 �?: 1 个符�?
	       25 �?: 大于1 个符�?
	       五�?�奖�?:
	       2 �?: 字母和数�?
	       3 �?: 字母、数字和符号
	       5 �?: 大小写字母�?�数字和符号
	       �?后的评分标准:
	       大于等于90: 非常安全
	       大于等于80: 安全
	       大于等于70: 非常�?
	       大于等于 60: �?
	       大于等于 50: �?�?
	       大于等于 25: �?
	       大于等于0:  非常�?
	       
	对应输出为：
		VERY_SECURE
		SECURE,     
		VERY_STRONG,
		STRONG,     
		AVERAGE,    
		WEAK,    
		VERY_WEAK,
		
	输入描述:
		输入�?个自定义密码
	输出描述:
		输出对应安全等级
	示例1
		输入
			dgsayd$%12
		输出
			SECURE
 */
public class Question_009 {
	public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);      
        String pwd = sc.next();
        int g = 0;
        boolean isSmallChar = false;
        boolean isBigChar = false;
        boolean isNum = false;
        boolean isSpe = false;
        int numCount = 0;
        int speCount = 0;
        char[] str = pwd.toCharArray();
        for(int i = 0;i<str.length;i++) {
        	if(str[i]>='0'&&str[i]<='9') {
        		isNum = true;
        		numCount++;
        	}else if(str[i]>='a'&&str[i]<='z') {
        		isSmallChar=true;
	        }else if(str[i]>='A'&&str[i]<='Z') {
	        	isBigChar=true;
	        }else if((str[i]>=32&&str[i]<=47)||(str[i]>=58&&str[i]<=64)||(str[i]>=91&&str[i]<=96)||(str[i]>=123&&str[i]<=126)) {
	        	isSpe = true;
	        	speCount++;
	        }
        }
        if(isSmallChar&&isBigChar) {
        	g+=20;
        }else if(isSmallChar||isBigChar) {
        	g+=10;
        }
        if(numCount>1) {
        	g+=20;
        }else if(isNum) {
        	g+=10;
        }
        if(speCount>1) {
        	g+=25;
        }else if(isSpe) {
        	g+=10;
        }
        if(isSmallChar&&isBigChar&&isSpe&&isNum) {
        	g+=5;
        }else if((isSmallChar||isBigChar)&&isSpe&&isNum) {
        	g+=3;
        }else if((isSmallChar||isBigChar)&&isNum) {
        	g+=2;
        }
        int len = pwd.length();
        if(len<=4) {
        	g+=5;
        }else if(len>4&&len<=7) {
        	g+=10;
        }else if(len>=8) {
        	g+=25;
        }
        if(g>=90) {
        	System.out.println("VERY_SECURE");
        }else if(g>=80) {
        	System.out.println("SECURE");
        }else if(g>=70) {
        	System.out.println("VERY_STRONG");
        }else if(g>=60) {
        	System.out.println("STRONG");
        }else if(g>=50) {
        	System.out.println("AVERAGE");
        }else if(g>=25) {
        	System.out.println("WEAK");
        }else {
        	System.out.println("VERY_WEAK");
        }
        sc.close();
    }
}

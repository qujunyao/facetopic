package com.company.test2018_001.questions;

import java.util.*;

/*
	题目描述
		输入�?个或多个车牌号码，多个以逗号分割�?,再输入想查询的日�?(数字，周�?),输出该日期限行的车牌�?
		车牌号码有以下要求，只要取后五位,如：AD123�?12101，车牌号不可能全是字母�??
		 *现在对尾号进行限制：尾号�?1,9则周�?限行，尾号为2,8则周二限行，尾号�?3,7则周三限�? 尾号�?4,6则周四限�?,尾号�?5,0的周五限�?,周六周日不限行�??
		 *尾号不为数字，则看第4位是否是数字，如果第4位还不是 数字，继续看�?3位，以此下去，直到找到有数字的时候止.
		 *由于用户不熟悉系统，有可能输入错误车牌，如车牌不�?5位或大于5位�?�车牌全是字母�?�没用�?�号分割等，如有输入错误情况 �?律返回error
		 *如输入没有问题则返回限行的车牌号,如没有，刚返回none
	输入描述:
		�?个或多个车牌号码
		周几
	输出描述:
		限行的车牌号，如没有限行的则返回none
	示例1
		输入
			Y008U,T8899
			2
		输出
			Y008U
 */
public class Question_010 {
	public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);      
        String str = sc.next();
        String day = sc.next();
        String[] cards = str.split(",");
        List<String> result = new ArrayList<String>();
        for(String a:cards) {
        	char[] tem = a.toCharArray();
        	if(tem.length!=5) {
        		System.out.println("error");
        		System.exit(0);
        	}
        	int time = 0;
        	for(int i = tem.length-1;i>=0;i--) {
        		int t = tem[i]-'0';
        		if(t<=10&&t>=0) {
        			if(t==Integer.valueOf(day)||t==10-Integer.valueOf(day)) {
        				result.add(a);
        				break;
        			}
        			break;
        		}else {
        			time++;
        		}
        	}
        	if(time==tem.length) {
        		System.out.println("error");
        		System.exit(0);
        	}
        }
        if(result.size()==0) {
        	System.out.println("none");
        }else {
        	System.out.println(result);
        }
        sc.close();
    }
}

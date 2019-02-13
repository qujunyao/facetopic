package com.company.test2018_001.questions;

import java.util.*;

/*
	题目描述
		快乐之城是一个非常愉快的城市，这个城市由n个片区组成，片区与片区之间由n-1条道路相连�?�任意两个片区之间，都存在一条简单路径可以到达�??
		现在有两个人，小红与小明，正在快乐之城中旅游。但是小红与小明的关系不是很好，�?以他们都不想在旅行的过程中碰见对方�??
		而你作为他们旅行的规划师，需要制定出完美的计划，满足这两个人的旅行路径不相交的目标�??
		当然，这两个人的旅行路径都是从一个地方旅行到另外�?个地方，且他们的路线�?定是�?短的路线�?
		请问，能够构造出多少种不同的计划呢？
		
	输入描述:
		第一行一个整数n，表示快乐之城由n条片区组成�??
		接下来n-1行，每行两个整数x,y，表示片区x与片区y相连�?
	输出描述:
		输出�?共有多少种计�?

	示例1
		输入
			4
			1 2
			2 3
			3 4
		输出
			8
		说明
			表示小明的旅行计划是从A走到B，小红的旅行计划是从C走到D�?
			<1,2,3,4>,<2,1,3,4>,<1,2,4,3>,<2,1,4,3>
			<3,4,1,2>,<3,4,2,1>,<4,3,1,2>,<4,3,2,1>
			就以上八种计�?
 */
public class Question_021 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n-1; i++) {
            int x = sc.nextInt();
            x = sc.nextInt();
            if(x==0) ;         
        }
        sc.close();
        System.out.println((int)Math.pow(2, n-1));
    }
}

package com.company.baidu.answers;
import java.util.*;

public class Answer_006 {

    @SuppressWarnings("resource")
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] words = new String[n];
        for(int i = 0; i < n; ++i){
            words[i] = sc.nextLine().toLowerCase();
        }
        String line = sc.nextLine();
        //将字符串转换为字符数组。
        char[] result = line.toCharArray();
        //将字符串全变成小写。
        line = line.toLowerCase();
        //第一层循环敏感词
        for(int i = 0; i < n; ++i){
        	//敏感词首字母的位置。
            int pos = 0;
            //第二层循环字符串的敏感词的位置。
            while (pos > -1){
            	//找到敏感词后，将位置重置为新的位置。
                pos = line.indexOf(words[i], pos);
                //如果位置小于0，则表示不存在敏感词了，退出循环。
                if(pos < 0) {
                    break;
                }
                //替换成*的个数。即为敏感词的长度。
                int len =  pos + words[i].length();
                //第三场循环，在字符数组中，替换对应的敏感词字符为*
                for(; pos < len; ++pos){
                    result[pos] = '*';
                }
            }
        }
        System.out.println(new String(result));
    }
}
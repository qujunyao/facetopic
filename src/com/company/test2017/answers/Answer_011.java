package com.company.test2017.answers;

import java.io.*;

public class Answer_011 {
	public static void main (String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line=br.readLine();
        char[] ch=line.toCharArray();
        int[] count =new int[128];
        for(int i=0 ;i<line.length();i++){
            if(ch[i]>='a'&&ch[i]<='z'||ch[i]>='A'&&ch[i]<='Z'){
                count[ch[i]]++;
                if(count[ch[i]]==3){
                    System.out.print(ch[i]);
                    break;
                }
            }
        }
    }
}

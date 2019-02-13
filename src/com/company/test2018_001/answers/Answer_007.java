package com.company.test2018_001.answers;

import java.io.*;

public class Answer_007 {
	public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 
        int n=Integer.parseInt(br.readLine());
         
        while((n--)!=0){
            String word=br.readLine();
            int len=word.length();
            if(len<10){
                System.out.println(word);
            }else{
                System.out.println(word.charAt(0)+String.valueOf(len-2)+word.charAt(len-1));
            }
        }
    }
}

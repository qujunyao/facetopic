package com.company.test2018_021.answers;

import java.io.*;

public class Answer_027 {
	public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line=null;
        while((line=br.readLine())!=null){
            String[] lineList=line.split(" ");
            int a=Integer.valueOf(lineList[0]);
            int b=Integer.valueOf(lineList[1]);
            int A=Integer.valueOf(lineList[2]);
            int B=Integer.valueOf(lineList[3]);
            int count=0;
            while(A/2>=a && B/2>=b){
                A=A/2;
                B=B/2;
                count++;
            }
            while(A-1>=a && B-1>=b){
                A=A-1;
                B=B-1;
                count++;
            }
 
            if(a==A && b==B){
                System.out.println(count);
            }else{
                System.out.println(-1);
            }
 
        }
    }
}


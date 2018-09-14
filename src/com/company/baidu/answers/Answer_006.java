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
        //���ַ���ת��Ϊ�ַ����顣
        char[] result = line.toCharArray();
        //���ַ���ȫ���Сд��
        line = line.toLowerCase();
        //��һ��ѭ�����д�
        for(int i = 0; i < n; ++i){
        	//���д�����ĸ��λ�á�
            int pos = 0;
            //�ڶ���ѭ���ַ��������дʵ�λ�á�
            while (pos > -1){
            	//�ҵ����дʺ󣬽�λ������Ϊ�µ�λ�á�
                pos = line.indexOf(words[i], pos);
                //���λ��С��0�����ʾ���������д��ˣ��˳�ѭ����
                if(pos < 0) {
                    break;
                }
                //�滻��*�ĸ�������Ϊ���дʵĳ��ȡ�
                int len =  pos + words[i].length();
                //������ѭ�������ַ������У��滻��Ӧ�����д��ַ�Ϊ*
                for(; pos < len; ++pos){
                    result[pos] = '*';
                }
            }
        }
        System.out.println(new String(result));
    }
}
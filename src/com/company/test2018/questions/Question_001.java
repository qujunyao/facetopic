package com.company.test2018.questions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
	��Ŀ����
	С��ͬѧ���������һ����վ�����û�ע���˻���ʱ����Ҫ�����˻������룬Ϊ�˼�ǿ�˻��İ�ȫ�ԣ�С��������ǿ����һ��Ҫ��
	
	1. ����ֻ���ɴ�д��ĸ��Сд��ĸ�����ֹ��ɣ�
	
	2. ���벻�������ֿ�ͷ��
	
	3. ���������ٳ��ִ�д��ĸ��Сд��ĸ�������������ַ������е����֣�
	
	4. ���볤������Ϊ8
	
	����С���ܵ���n�����룬��������д�����ж���Щ��������Щ�Ǻ��ʵģ���Щ�ǲ��Ϸ��ġ�
	
	��������:
		����һ����n����������n(n��100)�У�ÿ��һ���ַ�������ʾһ�����룬���뱣֤�ַ�����ֻ���ִ�д��ĸ��Сд��ĸ�����֣��ַ������Ȳ�����100��
	�������:
		����n�У��������Ϸ������YES�����Ϸ����NO
		
	ʾ��1
		����
			1
			CdKfIfsiBgohWsydFYlMVRrGUpMALbmygeXdNpTmWkfyiZIKPtiflcgppuR
		���
			YES
 */
public class Question_001 {
	public static void main(String[] args) {
		Scanner  scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		for(int i = 0;i<num;i++) {
			String str = scanner.next();
			System.out.println(checkPWD(str));
		}
		scanner.close();
	}

	private static String checkPWD(String str) {
		String regEx1 = "^[A-Za-z]{1}[a-zA-Z0-9]{7,}$";
		String regEx2 = "^([a-z]+)$";
		String regEx3 = "^([A-Z]+)$";
		Pattern pattern = Pattern.compile(regEx1);
		Pattern pattern2 = Pattern.compile(regEx2);
		Pattern pattern3 = Pattern.compile(regEx3);
		Matcher matcher = pattern.matcher(str);
		boolean rs = matcher.matches();
		if(rs){
			matcher = pattern2.matcher(str);
			boolean a = matcher.matches();
			matcher = pattern3.matcher(str);
			boolean b = matcher.matches();
			if(a||b) {
				return "NO";
			}else {
				return "YES";
			}
		}else {
			return "NO";
		}
	}
}

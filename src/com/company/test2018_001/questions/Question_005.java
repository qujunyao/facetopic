package com.company.test2018_001.questions;

import java.util.*;

/*
	题目描述
		今天，在冬木市举行了�?场盛大的舞会。参加舞会的有n 位男士，�? 1 �? n 编号；有 m 位女士，�? 1 �? m 编号�?
		对于每一位男士，他们心中都有各自心仪的一些女士，在这次舞会中，他们希望能与每�?位自己心仪的女士跳一次舞�?
		同样的，对于每一位女士，她们心中也有各自心仪的一些男士，她们也希望能与每�?位自己心仪的男士跳一次舞�?
		在舞会中，对于每�?首舞曲，你可以�?�择�?些男士和女士出来跳舞。但是显然的，一首舞曲中�?位男士只能和�?位女士跳舞，
		�?位女士也只能和一位男士跳舞�?�由于舞会的时间有限，现在你想知道你�?少需要准备多少首舞曲，才能使�?有人的心愿都得到满足�?
	
	输入描述:
		第一行包含两个整数n,m，表示男士和女士的人数�??1≤n,m�? 1000
		接下来n行，
		第i行表示编号为i的男士有ki个心仪的女生
		然后包含ki个不同的整数分别表示他心仪的女士的编号�??
		接下来m行，以相同的格式描述每一位女士心仪的男士�?
		
	输出描述:
		�?个整数，表示�?少需要准备的舞曲数目�?
		
	示例1
		输入
			2 3
			1 1
			2 2 3
			0
			0
			0
		输出
			2
	示例2
		输入
			3 3
			2 1 2
			2 1 3
			2 2 3
			1 1
			2 1 3
			2 2 3
		输出
			2
	说明
		对于样例2，我们只�?要两首舞曲，第一首舞曲安排（1,1），�?2,3），�?3,2）；第二首舞曲安排（1,2），(2,1)，（3,3）�??
 */
public class Question_005 {
	private int num;
	private int len;
	private List<Integer> res ;
	public int getLen() {
		return len;
	}
	public List<Integer> getRes() {
		return res;
	}
	public int getNum() {
		return num;
	}
	public Question_005(int n,int l ,List<Integer> list) {
		this.num = n;
		this.len = l;
		this.res = list;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int man = scanner.nextInt();
		int woman = scanner.nextInt();
		List<Question_005> mlist = new ArrayList<Question_005>();
		int templ = -1;
		int index = -1;
		for(int i = 0;i<man;i++) {
			int len = scanner.nextInt();
			if(len>templ) {
				templ = len;
				index = i; 
			}
			List<Integer> res = new ArrayList<Integer>();
			for(int j = 0;j<len;j++) {
				res.add(scanner.nextInt());
			}
			mlist.add(new Question_005(i+1,len,res));
		}
		int templ2 = -1;
		int index2 = -1;
		List<Question_005> wlist = new ArrayList<Question_005>();
		for(int i = 0;i<woman;i++) {
			int len = scanner.nextInt();
			if(len>templ2) {
				templ2 = len;
				index2 = i; 
			}
			List<Integer> res = new ArrayList<Integer>();
			for(int j = 0;j<len;j++) {
				res.add(scanner.nextInt());
			}
			wlist.add(new Question_005(i+1,len,res));
		}
		if(templ<templ2) {
			List<Question_005> temp = wlist;
			wlist = mlist;
			mlist = temp;
			int t = index2;
			index2 = index;
			index = t;
		}
		//man
		int result = 0;
		result += mlist.get(index).getRes().size();
		for(int i = 0;i<wlist.size();i++) {
			if(!isIn(i+1,mlist.get(index).getRes())) {
				for(int j = 0;j<wlist.get(i).getRes().size();j++) {
					if(wlist.get(i).getRes().get(j)==index+1){
						result++;
					}
				}
			}
		}
		scanner.close();
		System.out.println(result);
    }
	private static boolean isIn(int n, List<Integer> res2) {
		return res2.contains(n);
	}
}

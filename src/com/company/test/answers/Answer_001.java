package com.company.test.answers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Answer_001 {

	//g(m) = 17 * m^2 / 3 - 22 * m / 3 + 5 / 3
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Long> list = new ArrayList<>();
		long temp = 0;
		while (scan.hasNextLong()) {
			temp = scan.nextLong();
			if(temp==0) {
				break;
			}else {
				list.add(temp);
			}
		}
		for(long l :list) {
			int count = 0;
			for(int i = 2;i<l;i++) {
				if(Answer_001.isPrime(i)) {
					count++;
				}
			}
			System.out.println(count);
		}
		scan.close();
	}

	public static boolean isPrime(int num) {
	    if (num <= 3) {
	        return num > 1;
	    }
	    // 不在6的倍数两侧的一定不是质数
	    if (num % 6 != 1 && num % 6 != 5) {
	        return false;
	    }
	    int sqrt = (int) Math.sqrt(num);
	    for (int i = 5; i <= sqrt; i += 6) {
	        if (num % i == 0 || num % (i + 2) == 0) {
	            return false;
	        }
	    }
	    return true;
	}

}

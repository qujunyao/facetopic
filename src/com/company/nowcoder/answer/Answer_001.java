package com.company.nowcoder.answer;

import java.util.Scanner;

public class Answer_001 {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int x = in.nextInt();
	        int y = in.nextInt();
	        int i = 0;
	        char[][] array = new char[x][y];
	        int lastRow = -1;
	        while (i < (x * y)) {
	            for (char aa : in.next().toCharArray()) {
	                array[i/y][i%y] = aa;
	                if (array[i/y][i%y] == 'W') {
	                    lastRow = i / y;
	                }
	                i++;
	            }
	        }
	        System.out.print(getAns(x, y, array, lastRow));
	    }
	    public static int getAns(int x, int y, char[][] array, int lastRow) {
	        int curY = 0;
	        int res = 0;
	        boolean trueForRight = true;
	        for (int i = 1; i <= lastRow; i++) {
	            int moveToY = curY;
	            if (trueForRight) {
	                for (int j = y - 1; j >= curY; j--) {
	                    if (array[i][j] == 'W') {
	                        moveToY = Math.max(moveToY, j);
	                        break;
	                    }
	                }
	                for (int j = y - 1; j >= curY; j--) {
	                    if (array[i - 1][j] == 'W') {
	                        moveToY = Math.max(moveToY, j);
	                        break;
	                    }
	                }
	                res += moveToY - curY + 1;
	                curY = moveToY;
	                trueForRight = !trueForRight;
	            } else {
	                for (int j = 0; j <= curY; j++) {
	                    if (array[i][j] == 'W') {
	                        moveToY = Math.min(moveToY, j);
	                        break;
	                    }
	                }
	                for (int j = 0; j <= curY; j++) {
	                    if (array[i - 1][j] == 'W') {
	                        moveToY = Math.min(moveToY, j);
	                        break;
	                    }
	                }
	                res += curY - moveToY + 1;
	                curY = moveToY;
	                trueForRight = !trueForRight;
	            }
	        }
	        int moveToY = curY;
	        if (trueForRight) {
	            for (int j = y - 1; j >= curY; j--) {
	                if (array[lastRow][j] == 'W') {
	                    moveToY = Math.max(moveToY, j);
	                    break;
	                }
	            }
	            res += moveToY - curY;
	        } else {
	            for (int j = 0; j <= curY; j++) {
	                if (array[lastRow][j] == 'W') {
	                    moveToY = Math.min(moveToY, j);
	                    break;
	                }
	            }
	            res += curY - moveToY;
	        }
	        return res;
	    }

}

package com.zhy.zero.MaxtrixMaxRect;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    private static Integer[][] matrix = null;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer row = in.nextInt();
        Integer col = in.nextInt();
        Integer h[] = new Integer[col];
        Integer maxRect = 0;

        matrix = new Integer[row][col];

        for (Integer i = 0; i < row; i++) {
            String temp = in.next();
            char[] chars = temp.toCharArray();
            for (Integer j = 0; j < col; j++) {
                switch (chars[j]) {
                    case '.':
                        matrix[i][j] = 1;
                        break;
                    case 'X':
                        matrix[i][j] = 0;
                        break;
                }

            }
        }

        for (Integer j = 0; j < row; j++) {
            h = sum1(j, row, col);
            maxRect = Math.max(maxRect, MaxRect(h));

        }
        System.out.println(maxRect);

    }

    /**
     * 计算列中1的个数
     * @param row 行
     * @param col 列
     * @return
     */
    private static Integer[] sum1(Integer position, Integer row, Integer col) {
        Integer h[] = new Integer[col];
        for (Integer j = 0; j < col; j++) {
            Integer time = 0;
            for (Integer i = position; i < row; i++) {
                if (matrix[i][j] == 1) {
                    time++;
                } else {
                    break;
                }
            }
            h[j] = time;
        }
        return h;
    }

    /**
     * 计算直方图中最大的矩形
     * @param h
     * @return
     */
    private static Integer MaxRect(Integer[] h) {
        Integer maxRect = 0;
        Stack<Integer> sStack = new Stack<Integer>();
        for (int k = 0; k < h.length; ) {
            if (sStack.empty() || h[sStack.peek()] <= h[k]) {
                sStack.push(k);
                k++;
            } else {
                //计算面积
                Integer rank = sStack.pop();
                if (!sStack.empty()) {
                    maxRect = Math.max(maxRect, (k - sStack.peek() -1) * h[rank]);
                } else {
                    maxRect = Math.max(maxRect, k * h[rank]);
                }
            }
        }
        while (!sStack.empty()) {
            int rank = sStack.pop();
            if (sStack.empty()) {
                maxRect = Math.max(maxRect, (h.length) * h[rank]);
            } else {
                maxRect = Math.max(maxRect, (h.length - sStack.peek() - 1) * h[rank]);
            }
        }

        return maxRect;
    }
}

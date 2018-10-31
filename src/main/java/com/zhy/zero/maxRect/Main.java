package com.zhy.zero.maxRect;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Integer> sStack = new Stack<Integer>();
        Integer maxRect = 0;
        int time = in.nextInt();
        Integer h[] = new Integer[time];
        for (int i = 0; i < time; i++) {
            int num = in.nextInt();
            h[i] = num;
        }

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

        System.out.println(maxRect);
    }

}

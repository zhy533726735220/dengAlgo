package com.zhy.zero.maxRect;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author zhy53
 * 单调栈
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Integer> sStack = new Stack<Integer>();
        // 直方图最大面积
        Integer maxRect = 0;
        int time = in.nextInt();
        // 加入左右两个哨兵
        Integer h[] = new Integer[time + 2];
        for (int i = 0; i <= time; i++) {
            if (i == 0) {
                h[0] = 0;
                continue;
            }
            if (i == time + 1) {
                h[time + 1] = 0;
                continue;
            }
            int num = in.nextInt();
            h[i] = num;
        }
        // 对栈初始化，将0压入是一个trick，因为右哨兵为0
        sStack.push(0);

        // 单调栈算法,一个trick是一个循环到n+1,因为height[n + 1] = 0
        for (int k = 1; k < time + 1; k++) {
            while (h[sStack.peek()] > h[k]) {
                int tmpHeight = h[sStack.pop()];
                // TODO 有问题
                maxRect = Math.max(maxRect, (k - sStack.peek() - 1) * tmpHeight);
            }
            sStack.push(k);
        }
        System.out.println(maxRect);

    }


}

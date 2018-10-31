package com.zhy.zero.stackSort;

import java.util.Scanner;
import java.util.Stack;

/**
 * 栈排序
 * @author zhy53
 */
public class Main {
    public static void main(String[] args) {
        Stack<Integer> rStack = new Stack<Integer>();
        Stack<Integer> resultStack = new Stack<Integer>();
        Scanner in = new Scanner(System.in);
        int time = in.nextInt();

        for (int i = 0; i < time; i++) {
            int num = in.nextInt();
            rStack.push(num);
        }

        resultStack = sorting(rStack);
        while (!resultStack.empty()) {
            Integer t = resultStack.pop();
            System.out.println(t);
        }

    }

    private static Stack<Integer> sorting(Stack<Integer> rStack) {
        Stack<Integer> sStack = new Stack<Integer>();
        // 边界条件
        if (rStack.empty()) {
            return sStack;
        }

        // tmp记录的是下一个要插入到sStack栈中的数
        Integer tmp = rStack.pop();
        while (!rStack.empty() || !sStack.empty() && sStack.peek() < tmp) {
            if (sStack.empty() || sStack.peek() >= tmp) {
                sStack.push(tmp);
                tmp = rStack.pop();
            } else {
                rStack.push(sStack.pop());
            }
        }
        sStack.push(tmp);
        return sStack;
    }
}

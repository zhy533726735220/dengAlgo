package com.zhy.mon.third.equation;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int time = in.nextInt();
        for (int i = 0; i < time; i++) {
            int count = in.nextInt();
            int restrain = in.nextInt();
            int[] a = new int[count + 1];
            Stack<Integer> record = new Stack();
            for (int j = 0; j < a.length; j++) {
                a[j] = j;
            }
            for (int j = 0; j < restrain; j++) {
                int num1 = in.nextInt();
                int num2 = in.nextInt();
                int op = in.nextInt();
                switch (op) {
                    case 0:
                        record.push(num1);
                        record.push(num2);
                        break;
                    case 1:
                        int temp = a[num1];
                        a[num1] = a[num2];
                        for (int k = 0; k < a.length; k++) {
                            if (temp == a[k]) {
                                a[k] = a[num2];
                            }
                        }
                        break;

                }
            }
            boolean flag = false;
            while (!record.isEmpty()) {
                int num1 = record.pop();
                int num2 = record.pop();
                if (a[num1] == a[num2]) {
                    flag = true;
                }
            }
            if (flag == true) {
                System.out.println("NO");
            } else {
                System.out.println("Yes");
            }
        }

    }

    private static boolean isEquality(int num1, int num2) {
        if (num1 == num2) {
            return true;
        }
        return false;
    }
}

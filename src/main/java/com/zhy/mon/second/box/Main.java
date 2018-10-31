package com.zhy.mon.second.box;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<Integer> list = new HashSet<>();
        int time = in.nextInt();
        for (int i = 0; i < time; i++) {
            int op = in.nextInt();
            int num = in.nextInt();
            switch (op) {
                case 1:
                    if (!list.contains(num)) {
                        list.add(num);
                        System.out.println("Succeeded");
                    } else {
                        System.out.println("Failed");
                    }
                    break;
                case 2:
                    if (list.contains(num)) {
                        list.remove(num);
                        System.out.println("Succeeded");
                    } else {
                        System.out.println("Failed");
                    }
                    break;
            }
        }
    }
}

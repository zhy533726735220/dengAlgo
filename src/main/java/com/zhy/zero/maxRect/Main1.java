package com.zhy.zero.maxRect;

import java.util.Scanner;

/**
 * @author zhy53 蛮力优化版算法
 * 蛮力算法优化"枚举底边"这一步是不行的了，我们来优化"求高"这一步。
 * 1、假设我们枚举的左端点都是a，而枚举右端点b时，b每次是递增1的，我们想想从a到b的最小高度H_1和从a到b + 1的最小高度H_2有什么关系呢？
 * 2、H_2 = min{H_1, h_b+1}
 * 3、时间复杂度O(n^2)
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 直方图最大面积
        Integer maxRect;
        int time = in.nextInt();
        Integer h[] = new Integer[time];
        for (int i = 0; i < time; i++) {
            int num = in.nextInt();
            h[i] = num;
        }
        maxRect = maxRect(h);
        System.out.println(maxRect);
    }

    /**
     * 计算直方图最大面积
     * @param h
     * @return
     */
    private static Integer maxRect(Integer h[]) {
        Integer maxRect = 0;
        for (int a = 0; a < h.length; a++) {
            // 遍历每一种可能出现的底
            // 直方图最小高度因为有题目有数据范围，给出的高度最高不超过32767
            int minH = 50000;
            // a到b的高度最小值和a到b+1的高度的最小值，其实a到b高度的最小值和H[b+1]比较就可以了
            for (int b = a; b < h.length; b++) {
                minH = Math.min(minH, h[b]);
                maxRect = Math.max(maxRect, (b - a + 1) * minH);
            }
        }
        return maxRect;
    }

}

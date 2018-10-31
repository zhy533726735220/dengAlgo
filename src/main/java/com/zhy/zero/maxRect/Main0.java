package com.zhy.zero.maxRect;

import java.util.Scanner;

/**
 * @author zhy53 蛮力算法
 * 我们枚举每一条可能的底边，计算出高，然后求出面积再取出个最大的。
 * 1、枚举底边：用一个二重循环枚举底边的左边的位置a和右边的位置b(a <= b)就行了。
 * 2、求高：若知道了底边是从位置a到位置b，我们再用一个循环从a枚举到b，求出高度最小值就行了。
 * 3、时间复杂度O(n³)
 */
public class Main0 {
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
            for (int b = a; b < h.length; b++) {
                // 直方图最小高度因为有题目有数据范围，给出的高度最高不超过32767
                int minH = 50000;
                for (int c = a; c <= b; c++) {
                    // 计算最短长度
                    minH = Math.min(minH, h[c]);
                }
                maxRect = Math.max(maxRect, (b - a + 1) * minH);
            }
        }
        return maxRect;
    }

}

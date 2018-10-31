package com.zhy.zero.maxRect;

import java.util.Scanner;

/**
 * @author zhy53
 * 邓公版算法
 * 对于每一列，找到左右两端的卡位lo和hi,则形成矩形面积就是(hi - lo - 1) * h_i
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 直方图最大面积
        Integer maxRect = 0;
        int time = in.nextInt();
        Integer h[] = new Integer[time];
        for (int i = 0; i <= time; i++) {
            int num = in.nextInt();
            h[i] = num;
        }
        for (int k = 0; k < h.length; k++) {
            int lo;
            int hi;
            for (lo = k; lo >= 1; lo--) {
                if (h[lo] < h[k]){
                    break;
                }
            }
            for (hi = k; hi <= h.length; hi++) {
                if (h[hi] < h[k]) {
                    break;
                }
            }
            maxRect = Math.max(maxRect, (hi - lo) - 1) * h[k];
        }
        System.out.println(maxRect);

    }


}

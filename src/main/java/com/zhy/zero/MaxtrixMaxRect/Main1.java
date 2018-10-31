package com.zhy.zero.MaxtrixMaxRect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class Main1 {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    static class Task {
        
        // n, m：意义如题
        // matrix：一个字符串数组，用来记录所给矩形，matrix[i].charAt(j)表示所给矩形第i行第j列的字符（下标均从0开始）
        // 返回值：题目所求答案，即最大矩形面积
        int getAnswer(int n, int m, String[] matrix) {
            /* 请在这里设计你的算法，并将答案存储到ans中 */
            int ans = 0;
            // 第i个位置高度
            int[] height = new int[m];
            // 单调栈，记录的是在height数组中的位置，栈顶所对应的高度是最高的。
            Stack<Integer> myStack = new Stack<>();

            for (int k = 0; k < n; k++) {// k表示当前所枚举的是哪一行
                // 将每一行的高度更新，注意这里height的第i行表示的是矩形的第i-1列
                for (int i = 0; i < m; i++) {
                    if (matrix[k].charAt(i) == '.') {
                        height[i] = height[i] + 1;
                    } else {
                        height[i] = 0;
                    }
                }
                while (!myStack.empty()) {
                    myStack.pop();
                }

                ans = Math.max(ans, MaxRect(height));

            }

            return ans;
        }

        /**
         * 计算每一个直方图最大面积
         * @param h
         * @return
         */
        private static Integer MaxRect(int[] h) {
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

        void solve(InputReader in, PrintWriter out) {
            int n, m;
            n = in.nextInt();
            m = in.nextInt();
            
            String[] matrix = new String[n];
            
            for (int i = 0; i < n; ++i)
                matrix[i] = in.next();
            
            out.println(getAnswer(n, m, matrix));
        }

    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        private InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        private String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        private short nextShort() {
            return Short.parseShort(next());
        }

        private int nextInt() {
            return Integer.parseInt(next());
        }

        private long nextLong() {
            return Long.parseLong(next());
        }

        private float nextFloat() {
            return Float.parseFloat(next());
        }

        private double nextDouble() {
            return Double.parseDouble(next());
        }
    }

}
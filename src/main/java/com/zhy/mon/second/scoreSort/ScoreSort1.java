package com.zhy.mon.second.scoreSort;

import java.util.Scanner;
import java.util.Stack;

public class ScoreSort1 {
    public static void main(String[] args) {
        Stack<Score> scores = new Stack<>();
        Scanner in = new Scanner(System.in);
        int time = in.nextInt();
        for (int i = 0; i < time; i++) {
            int scoreA = in.nextInt();
            int scoreB = in.nextInt();
            Score score = new Score(i + 1, scoreA, scoreB, scoreA + scoreB);
            scores.push(score);
        }
        scores = sorting(scores);
        int count = scores.peek().getCount();
        for (int i = 0; i < time; i++) {
            Score score = scores.pop();
            System.out.println(score.getOrder() + " " + score.getSumScore() + " " + score.getScoreA() + " " + score.getScoreB());
        }
        System.out.println(count);
    }

    private static Stack<Score> sorting(Stack<Score> rStack) {
        int count = 0;
        Stack<Score> sStack = new Stack<>();
        // 边界条件
        if (rStack.empty()) {
            return sStack;
        }

        // tmp记录的是下一个要插入到sStack栈中的数
        Score tmpScore = rStack.pop();
        while (!rStack.empty() || (!sStack.empty() && sStack.peek().compareTo(tmpScore) == 1)) {
            if (sStack.empty() || sStack.peek().compareTo(tmpScore) == 0) {
                sStack.push(tmpScore);
                tmpScore = rStack.pop();
            } else {
                rStack.push(sStack.pop());
                ++count;
            }
        }
        sStack.push(tmpScore);
        sStack.peek().setCount(count);
        return sStack;
    }



    private static class Score implements Comparable<Score>{
        private int order;
        private int scoreA;
        private int scoreB;
        private int sumScore;
        private int count;

        public Score(int order, int scoreA, int scoreB, int sumScore) {
            this.order = order;
            this.scoreA = scoreA;
            this.scoreB = scoreB;
            this.sumScore = sumScore;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getScoreA() {
            return scoreA;
        }

        public void setScoreA(int scoreA) {
            this.scoreA = scoreA;
        }

        public int getScoreB() {
            return scoreB;
        }

        public void setScoreB(int scoreB) {
            this.scoreB = scoreB;
        }

        public int getSumScore() {
            return sumScore;
        }

        public void setSumScore(int sumScore) {
            this.sumScore = sumScore;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public String toString() {
            return "Score{" +
                    "order=" + order +
                    ", scoreA=" + scoreA +
                    ", scoreB=" + scoreB +
                    ", sumScore=" + sumScore +
                    ", count=" + count +
                    '}';
        }

        /**
         * o
         * @param o
         * @return
         */
        @Override
        public int compareTo(Score o) {
            if (this.sumScore > o.sumScore){
                return 1;
            } else if (this.sumScore == o.sumScore){
                if (this.scoreA > o.scoreA) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        }
    }
}

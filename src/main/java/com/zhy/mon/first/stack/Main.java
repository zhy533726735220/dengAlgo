package com.zhy.mon.first.stack;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Scanner in = new Scanner(System.in);
        String num = null;
        String temp = null;
        int time = in.nextInt();
        for (int i = 0; i < time; i++) {
            num = in.next();
            if (num.equals("2")) {
                System.out.println(stack.pop());
                continue;
            }
            temp = in.next();
            switch (num) {
                case "1":
                    stack.push(temp);
                    break;
                case "3":
                    if (isInt(temp)) {
                        Integer position = Integer.parseInt(temp);
                        System.out.println(stack.find(position));
                    }
                    break;
            }
        }
    }


    private static boolean isInt(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }
    static class Stack {
        int size = 0;
        int capacity = 2;
        String elem[] = new String[this.capacity];
        private void expand() {
            if (this.size() < this.capacity()) {
                return;
            }
            this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);
        }

        private int capacity() {
            return this.elem.length;
        }

        private int size() {
            this.size = 0;
            for (int i = 0; i < this.elem.length; i++) {
                if (this.elem[i] != null) {
                    this.size++;
                }
            }
            return this.size;
        }

        String push(String t) {
            this.expand();
            this.elem[this.size()] = t;
            return t;
        }

        public String pop() {
            String top = this.elem[this.size() - 1];
            this.elem[this.size() - 1] = null;
            return top;
        }

        public String find(int position) {
            return this.elem[position - 1];
        }
    }

}

package com.zhy.mon.second.code;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<TreeNode> stack = new Stack<>();
        Scanner in = new Scanner(System.in);
        long time = in.nextInt();

        for (int i = 0; i < time; i++) {
            int num = in.nextInt();
            TreeNode treeNode = new TreeNode(num);
            stack.push(treeNode);
        }
        if (time != 0) {
            stack = coding(stack);
        }

        preOrder(null, stack.peek(), -1);
        System.out.println(A / 2);

    }

    private static long A = 0;
    public static void preOrder(TreeNode parentNode, TreeNode currentNode, long sum) {
        if (currentNode != null) {
            sum++;
            preOrder(currentNode, currentNode.getLeftChild(), sum);
            preOrder(currentNode, currentNode.getRightChild(), sum);
        } else {
            A = A + sum * parentNode.getData();
        }
    }

    private static Stack<TreeNode> coding(Stack<TreeNode> stack) {
        while (stack.size() != 1) {
            stack = sorting(stack);
            TreeNode tempNode = stack.pop();
            TreeNode topNode = stack.peek();
            TreeNode newNode = new TreeNode(tempNode.getData() + topNode.getData());
            newNode.setLeftChild(topNode);
            newNode.setRightChild(tempNode);
            stack.pop();
            stack.push(newNode);
        }
        return stack;
    }


    private static Stack<TreeNode> sorting(Stack<TreeNode> rStack) {
        Stack<TreeNode> sStack = new Stack<TreeNode>();
        // 边界条件
        if (rStack.empty()) {
            return sStack;
        }

        // tmp记录的是下一个要插入到sStack栈中的数
        TreeNode tmp = rStack.pop();
        while (!rStack.empty() || !sStack.empty() && sStack.peek().compareTo(tmp) == 0) {
            if (sStack.empty() || sStack.peek().compareTo(tmp) == 1) {
                sStack.push(tmp);
                tmp = rStack.pop();
            } else {
                rStack.push(sStack.pop());
            }
        }
        sStack.push(tmp);
        return sStack;
    }


    private static class TreeNode implements Comparable<TreeNode>{
        private long data;
        private TreeNode leftChild;
        private TreeNode rightChild;
        // 表示是否被删除
        boolean isDelete;
        public TreeNode(long data) {
            this.data = data;
        }

        public long getData() {
            return data;
        }

        public void setData(long data) {
            this.data = data;
        }

        public TreeNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(TreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public TreeNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(TreeNode rightChild) {
            this.rightChild = rightChild;
        }

        public boolean isDelete() {
            return isDelete;
        }

        public void setDelete(boolean delete) {
            isDelete = delete;
        }

        @Override
        public int compareTo(TreeNode o) {
            if (this.data < o.getData()) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static class Node {
        private int data;
        private Node node;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNode() {
            return node;
        }

        public void setNode(Node node) {
            this.node = node;
        }
    }
}

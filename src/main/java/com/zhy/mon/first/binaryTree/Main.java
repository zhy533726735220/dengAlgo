package com.zhy.mon.first.binaryTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        Scanner in = new Scanner(System.in);
        int time = in.nextInt();
        for (int i = 0; i < time; i++) {
            int n = in.nextInt();
            binaryTree.insert(n);
        }

        binaryTree.preOrder(binaryTree.getRootNode());
        System.out.println();
        binaryTree.postOrder(binaryTree.getRootNode());
    }

    public static class BinaryTree  {

        private TreeNode rootNode;

        public TreeNode getRootNode() {
            return rootNode;
        }

        public void setRootNode(TreeNode rootNode) {
            this.rootNode = rootNode;
        }

        public TreeNode find(int key) {
            return null;
        }

        public boolean insert(int data) {
            TreeNode newTreeNode = new TreeNode(data);
            if (this.rootNode == null) {
                this.rootNode = newTreeNode;
                return true;
            } else {
                TreeNode currentNode = this.rootNode;
                TreeNode parentNode  = null;
                while (currentNode != null) {
                    parentNode  = currentNode;
                    if (currentNode.getData() > newTreeNode.getData()) {
                        currentNode = currentNode.getLeftChild();
                        if (currentNode == null) {
                            parentNode.setLeftChild(newTreeNode);
                            return true;
                        }
                    } else {
                        currentNode = currentNode.getRightChild();
                        if (currentNode == null) {
                            parentNode.setRightChild(newTreeNode);
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public void infixOrder(TreeNode currentNode) {
            if (currentNode != null) {
                System.out.print(currentNode.getData() + " ");
                this.infixOrder(currentNode.getLeftChild());
                this.infixOrder(currentNode.getRightChild());
            }
        }

        public void preOrder(TreeNode currentNode) {
            if (currentNode != null) {
                System.out.print(currentNode.getData() + " ");
                this.preOrder(currentNode.getLeftChild());
                this.preOrder(currentNode.getRightChild());
            }
        }

        public void postOrder(TreeNode currentNode) {
            if (currentNode != null) {
                this.postOrder(currentNode.getLeftChild());
                this.postOrder(currentNode.getRightChild());
                System.out.print(currentNode.getData() + " ");
            }
        }

        private  class TreeNode{
            private int data;
            private TreeNode leftChild;
            private TreeNode rightChild;
            // 表示是否被删除
            boolean isDelete;
            public TreeNode(int data) {
                this.data = data;
            }

            public int getData() {
                return data;
            }

            public void setData(int data) {
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
        }
    }
}



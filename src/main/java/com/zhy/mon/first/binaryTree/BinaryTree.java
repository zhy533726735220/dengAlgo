package com.zhy.mon.first.binaryTree;

public class BinaryTree  {

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

    private static class TreeNode{
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
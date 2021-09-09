package com.wfz.binarytree.struct;

public class BinaryTree {

    private TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }
    //前序遍历

    public void preOrder() {

        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("BinaryTree is nulll");
        }

    }

    //中序遍历

    public void infixOrder() {

        if (this.root != null) {

            this.root.infixOrder();
        } else {
            System.out.println("BinaryTree is nulll");
        }
    }

    //后序遍历

    public void postOrder() {
        if (this.root != null) {

            this.root.postOrder();
        } else {
            System.out.println("BinaryTree is nulll");
        }

    }

}


class TreeNode {

    private int no;
    private String name;
    private TreeNode left;
    private TreeNode right;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    //前序遍历
    public void preOrder() {

        //输出根节点
        System.out.println(this);

        //递归向左子树遍历

        if (this.left != null) {

            this.left.preOrder();

        }
        //递归向右子树遍历
        if (this.right != null) {

            this.right.preOrder();

        }

    }

    //中序遍历

    public void infixOrder() {

        //递归向左子树遍历
        if (this.left != null) {

            this.left.infixOrder();
        }

        //输出父节点
        System.out.println(this);

        //递归向子节点遍历
        if (this.right != null) {
            this.right.infixOrder();
        }

    }

    //后序遍历

    public void postOrder() {

        //递归向左子树遍历
        if (this.left != null) {
            this.left.postOrder();
        }

        //递归向右子树遍历
        if (this.right != null) {
            this.right.postOrder();
        }

        //输出父节点

        System.out.println(this);


    }
}

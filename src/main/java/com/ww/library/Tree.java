package com.ww.library;

public class Tree {

    private TreeNode root;

    public Tree(){}

    public Tree(Integer[] arr){

    }



    //中序遍历
    public static void scanAtree(TreeNode root) {
        System.out.print(root+" ");
        if(root.left!=null) {
            scanAtree(root.left);
        }else{
            System.out.print("null");
        }
        if(root.right!=null) {
            scanAtree(root.right);
        }
        else{
            System.out.print("null");
        }
    }

    //广度遍历
    public static void wideScan(TreeNode root){

    }


    public static void main(String args[]){
        Tree tree=new Tree();
        tree.root=new TreeNode(5);
        tree.root.left=new TreeNode(1);
        tree.root.right=new TreeNode(6);
        scanAtree(tree.root);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return val+"";
    }
}
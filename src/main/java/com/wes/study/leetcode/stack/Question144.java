package com.wes.study.leetcode.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class Question144 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }

    /**
     * 前序遍历的顺序为: 中 -> 左 -> 右
     * 栈起到了一个函数调用的作用，即通过栈来控制递归调用的效果
     *
     *
     * @param root
     * @return
     */
    public static List<Integer> solution1(TreeNode root){
        if(root == null) return new ArrayList<Integer>();

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr;
        stack.add(root);
        while(!stack.isEmpty()){
            curr = stack.pop();
            result.add(curr.val);

            // 由于栈是先进后出类型，中左右的顺序要求右先进后出
            if(curr.right != null) {
                stack.push(curr.right);
            }

            // 由于栈是先进后出类型，中左右的顺序要求右后进先出
            if(curr.left != null) {
                stack.push(curr.left);
            }
        }

        return result;
    }

}

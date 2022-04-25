package com.wes.study.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 基于栈的树的后续遍历
 */
public class Question145 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, Question94.TreeNode left, Question94.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }

    public static List<Integer> solution1(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }

            // 弹出一个最底层的一个left节点
            curr = stack.pop();

            //
            if(curr.right == null) {
                result.add(curr.val);
            }
            else {
                curr = curr.right;
            }
        }

        return result;
    }
}

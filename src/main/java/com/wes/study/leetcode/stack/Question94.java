package com.wes.study.leetcode.stack;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * 基于栈的二叉树中序遍历
 */
public class Question94 {


    public static class TreeNode {
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
    }


    public static void main(String[] args) {

    }

    public static List<Integer> solution1(TreeNode root){
        if(root == null) return new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        List<Integer> result = new ArrayList<>();
        while(curr != null || !stack.isEmpty()){
            // 将所有的左节点压入到stack中
            //
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // 获取第一个左节点
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}

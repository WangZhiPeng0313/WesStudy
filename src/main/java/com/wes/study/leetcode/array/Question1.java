package com.wes.study.leetcode.array;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 */
public class Question1 {

    public static void main(String[] args) {

    }

    /**
     * 暴力循环法
     * @param nums
     * @param target
     * @return
     */
    public static int[] solution1(int[] nums, int target){
        for(int i =0; i < nums.length - 1 ; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    /**
     * HashTable的方法
     *
     * @return
     */
    public static int[] solution2(int[] nums, int target) {
        if(nums == null || nums.length < 2) return null;
        HashMap<Integer, Integer> cache = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int val = target - nums[i];
            if(cache.containsKey(val)) {
                return new int[]{cache.get(val), i};
            }
            else {
                cache.put(nums[i], i);
            }
        }
        return null;
    }
}

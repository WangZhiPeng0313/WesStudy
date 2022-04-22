package com.wes.study.leetcode.array;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序
 */
public class Question977 {

    public static void main(String[] args) {

    }

    /**
     * 双指针
     *  左指针:
     *  右指针:
     * @param nums
     */
    public static int[] solution1(int[] nums){
        if(nums == null || nums.length == 0) return nums;

        int left = 0, right = nums.length -1, index = nums.length - 1;
        int[] result = new int[nums.length];
        while(left <= right) {
            int leftQurt = nums[left] * nums[left];
            int rightQurt = nums[right] * nums[right];

            if(leftQurt <= rightQurt){
                result[index--] = rightQurt;
                right --;
            }
            else {
                result[index--] = leftQurt;
                left++;
            }
        }

        return result;
    }
}

package com.wes.study.leetcode.array;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class Question283 {

    public static void main(String[] args) {

    }

    /**
     * 该题目其实是将非0的移动到数据前面，然后将后面的数值置为0既可
     *
     *
     */
    public static void solution1(int[] nums){
        if(nums == null || nums.length == 0) return;

        int slow=0,fast = 0;
        while(fast < nums.length){
            // 优先找0
            while(slow < nums.length && nums[slow] != 0) slow++;
            // 从slow开始找非0
            fast = slow +1;
            while(fast < nums.length && nums[fast] == 0) fast++;

            // 进行置换
            if(slow < fast && fast < nums.length) {
                nums[slow] = nums[fast];
                nums[fast] = 0;
            }
        }
    }

    /**
     * 双指针交换
     *
     */
    public static void solution2(int[] nums){
        if(nums == null || nums.length == 0) return;

        int slow=0,fast = 0;

        while(fast < nums.length){
            if(nums[fast] > 0) {
                int tmp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = tmp;
                slow ++;
            }
            fast++;
        }
    }
}

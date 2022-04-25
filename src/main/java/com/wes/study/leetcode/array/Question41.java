package com.wes.study.leetcode.array;

/**
 *
 */
public class Question41 {

    public static void main(String[] args) {

    }

    /**
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
     *
     *
     * @param nums
     * @return
     */
    public static int sulution1(int[] nums){
        int len = nums.length;
        for(int i = 0; i < len; i++){
            // 将当前的值交换以后，在继续进行交换
            while(nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }

        for(int i = 0 ; i < len ; i++){
            if(nums[i] != i + 1) return i+1;
        }
        return len + 1;
    }

}

package com.wes.study.leetcode.array;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 */
public class Question209 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        int length = solution1(nums, 7);
        System.out.println(length);
    }

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public static int solution1(int[] nums, int target){
        if(nums == null || nums.length == 0) return 0;

        int left =0, right = 0;
        int sumVal = 0;
        int resLen = Integer.MAX_VALUE;

        while(right < nums.length){
            sumVal = sumVal +nums[right];
            while(sumVal >= target) {
                int tmpLen = right - left + 1;
                if(tmpLen < resLen) resLen = tmpLen;
                sumVal = sumVal - nums[left++];
            }
            right++;
        }

        return resLen == Integer.MAX_VALUE ? 0 : resLen;

    }
}

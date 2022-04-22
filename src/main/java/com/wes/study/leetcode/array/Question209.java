package com.wes.study.leetcode.array;

import scala.concurrent.java8.FuturesConvertersImpl;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 */
public class Question209 {

    public static void main(String[] args) {

    }

    public static int solution1(int[] nums, int target){
        if(nums == null || nums.length == 0) return 0;

        int left =0, right = 0;
        int sumVal = nums[right];
        int resLen = 0;

        while(left < nums.length){
            if(sumVal >= target) {
                int tmpLen = right - left + 1;
                if(resLen > tmpLen) resLen = tmpLen;
                // 加left右移
                sumVal = sumVal - nums[left--];
            }
            else {
                sumVal = sumVal + nums[++right];
            }
        }

        return resLen;
    }
}

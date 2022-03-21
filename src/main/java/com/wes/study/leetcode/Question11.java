package com.wes.study.leetcode;

public class Question11 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public static int solution(int[] nums){
        if(nums == null || nums.length <= 1) return 0;

        int left = 0, right = nums.length-1;
        int result = 0;
        while(left < right){
            int tmp = Math.min(nums[left],nums[right]) * (right - left);
            if(result < tmp) result = tmp;
            if(nums[left] <= nums[right]) left++;
            else right--;
        }
        return result;
    }

}

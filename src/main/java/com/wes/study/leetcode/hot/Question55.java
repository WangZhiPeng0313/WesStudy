package com.wes.study.leetcode.hot;

public class Question55 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,1,0,1}));
    }

    public static boolean solution(int[] nums){
        int maxIndex = 0;
        int maxSum = nums[0];
        while(maxSum > maxIndex) {
            maxIndex = maxSum;
            for(int i = 0; i <= Math.min(nums.length - 1, maxSum); i++){
                maxSum = Math.max(maxSum, i + nums[i]);
            }
            System.out.println("");
        }

        if(maxIndex < nums.length -1) return false;
        return true;
    }
}

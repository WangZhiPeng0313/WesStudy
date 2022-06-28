package com.wes.study.leetcode.hot;

public class Question53 {

    public static void main(String[] args) {
//        System.out.println(solution(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

    }

    public static int solution(int[] nums){
        int sum = 0;
        for(int num : nums) sum += num;
        int maxSum = sum;

        int left = 0, right = nums.length - 1;
        while(left < right){
            if(nums[left] < nums[right]) {
                sum = sum - nums[left];
                maxSum = Math.max(maxSum, sum);
                left++;
            }
            else {
                sum = sum - nums[right];
                maxSum = Math.max(sum,maxSum);
                right--;
            }
        }

        return maxSum;
    }

    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}

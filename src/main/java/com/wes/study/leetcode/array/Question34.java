package com.wes.study.leetcode.array;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 */
public class Question34 {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] index = solution(nums, 8);
        for(int x : index) System.out.println(x);
    }

    public static int[] solution(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1, -1};

        int left = 0, right = nums.length - 1;

        while(left <= right){

            if(nums[left] == target && nums[right] == target) break;
            if(nums[left] < target) left++;
            if(nums[right] > target) right--;
        }

        if(left <= right) return new int[]{left, right};
        return new int[]{-1, -1};
    }

    /**
     * 这题需要理解二分查找条件的具体含义，而不是死记硬背
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] solution2(int[] nums, int target){
        return null;
    }
}

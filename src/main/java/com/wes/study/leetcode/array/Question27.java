package com.wes.study.leetcode.array;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class Question27 {

    public static void main(String[] args) {

    }

    /**
     * 设置双指针
     *  左指针负责寻找目标值
     *  右指针负责寻找普通值，遇到目标值直接删除
     * @param nums
     * @param val
     * @return
     */
    public static int solution1(int[] nums, int val){
        if(nums == null || nums.length == 0) return 0;

        int left = 0, right = nums.length - 1;

        while(left <= right) {
            // 寻找左边的目标值
            while(nums[left] != val && left <= right) left++;
            // 寻找右边的非目标值
            while(nums[right] == val && left <= right) nums[right--] = 0;

            // 将left 和 right的值进行交换
            if(left <= right) {
                nums[left] = nums[right];
                nums[right] = 0;
                right--;

            }
        }

        return left;
    }

    /**
     * 双指针的变种
     * @param nums
     * @param val
     * @return
     */
    public static int solution2(int[] nums, int val){
        if(nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length -1;
        for(;left<= right; left++){
            // 遇到值直接交换
            if(nums[left] == val) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                // 这里要减1是因为不知道复制过去的是不是目标值，如果是继续交换
                left--;
                right--;
            }
        }
        return left;
    }
}

package com.wes.study.leetcode.array;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class Question35 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,7
                ,9,11,13};
        int index =solution1(nums, 8);
        System.out.println(index);
    }

    /**
     * 二分查找，如果查找不存在的元素时，最后循环的结果为： num[right] < target < num[left]，且left = right + 1
     * (1) 元素不存在有序数组中
     * (2) left元素会在 num[left] < target移动，当num[left] > target时，就不在移动了，
     * (3) right元素会在 num[right] > target时移动，当 num[right] < target时，不再移动了
     * (4) 二分查找终止条件为: left < right
     * 根据以上四点，最后形成了 nums[right] < target < nums[left] && left = right+1 的结果
     *
     * @return
     */
    public static int solution1(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

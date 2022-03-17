package com.wes.study.leetcode;


/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 */
public class Question4 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2,4};

        // 二分查找思路
        System.out.println(solution1(nums1, nums2));

        // 归并排序思路
        System.out.println(solution2(nums1, nums2));
    }

    /**
     *
     * @return
     */
    public static double solution1(int[] nums1, int[] nums2){
        // 使用O(log (m+n))时间复杂度，则说明需要使用二分查找
        double result = 0d;
        int length1 = nums1.length, length2 = nums2.length;
        if((length1 + length2) % 2 == 1 ) {
            // 当两个数组的长度是奇数时
            result =  0;
        }
        else {
            result =  (mergeSort(nums1, nums2, (nums1.length + nums2.length)/2 - 1)
                    + mergeSort(nums1, nums2, (nums1.length + nums2.length)/2 )) / 2;
        }
        return result;
    }

    /**
     * 归并排序法
     * @param nums1
     * @param nums2
     * @return
     */
    public static double solution2(int[] nums1, int[] nums2){
        // 使用O(log (m+n))时间复杂度，则说明需要使用二分查找
        double result = 0d;
        int length1 = nums1.length, length2 = nums2.length;
        if((length1 + length2) % 2 == 1 ) {
            // 当两个数组的长度是奇数时
            result =  mergeSort(nums1, nums2, (nums1.length + nums2.length)/2);
        }
        else {
            result =  (mergeSort(nums1, nums2, (nums1.length + nums2.length)/2 - 1)
                + mergeSort(nums1, nums2, (nums1.length + nums2.length)/2 )) / 2;
        }
        return result;
    }

    private static double mergeSort(int[] nums1, int[] nums2, int k){
        int idx1 = 0, idx2=0;
        int flag = 0;
        while(true){
            int num1 = nums1[idx1];
            int num2 = nums2[idx2];
            int value  = -1;
            if(num1 <= num2) value = num1;
            else value = num2;

            if(idx1 + idx2 == k) return value;

            if(num1 <= num2 && idx1 < nums1.length - 1) idx1++;
            else if (idx2 == nums2.length - 1) idx1++;
            else idx2++;
        }
    }
}

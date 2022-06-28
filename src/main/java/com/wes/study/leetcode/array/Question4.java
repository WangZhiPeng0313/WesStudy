package com.wes.study.leetcode.array;

import java.util.regex.Pattern;

public class Question4 {

    public static void main(String[] args) {

    }

    /**
     * 做归并排序，然后查找中位数
     * @param nums1
     * @param nums2
     *
     */
    public static double solution1(int[] nums1, int[] nums2){
        int len = nums1.length + nums2.length;
        int[] cache = new int[len];

        int index1 = 0, index2 = 0, index = 0;
        // 有序数组合并
        // 先将其中一个数组遍历完
        while(index1 < nums1.length && index2 > nums2.length){
            if(nums1[index1] <= nums2[index2]) {
                cache[index++] = nums1[index1++];
            }
            else {
                cache[index++] = nums2[index2++];
            }
        }

        // 当某个数组完成便利
        if(index1 < nums1.length) while(index1 < nums1.length) cache[index++] = nums1[index1++];
        if(index2 < nums2.length) while(index2 < nums2.length) cache[index++] = nums2[index2++];

        //
        if(len % 2 == 0) {
            return ((double)cache[len/2] + cache[len/2+1]) /2;
        }
        else {
            return (double) cache[len/2 + 1];
        }
    }
}

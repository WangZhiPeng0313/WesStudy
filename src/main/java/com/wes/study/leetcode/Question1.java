package com.wes.study.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组nums以及一个整数目标值target，在该数组中找出 `和未目标值`的两个整数的下角标
 */
public class Question1 {

    public static void main (String[] args) {
        int[] nums = new int[] {1,2,3,4,5,6,7};
        int target = 8;

        int[] result1 = solution1(nums, target);
        System.out.print(result1[0] + " , " +result1[1]);
        int[] result2 = solution2(nums, target);
        System.out.print(result2[0] + " , " +result2[1]);

    }

    /**
     * 暴力求解法，直接使用双重for循环进行查找，难度为N^2
     * @param nums
     * @param target
     * @return
     */
    public static int[] solution1(int[] nums, int target){
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return new int[]{};
    }

    /**
     * 使用HASH表求解，在得知TARGET和NUM1以后，可以计算出NUM2，然后使用HASH直接获取对一个的下角标
     * 结果是由两个数值组成的，因此采用放置第一个，然后使用第二个查询的方式进行处理
     * @param nums
     * @param target
     * @return
     */
    public static int[] solution2(int[] nums, int target){
        Map<Integer, Integer> hashTable = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            int num2 = target - nums[i];
            // 这么写是因为可是使用num2查找num1
            if(hashTable.containsKey(num2))return new int[]{i, hashTable.get(num2)};
            hashTable.put(nums[i], i);
        }
        return new int[]{};
    }
}

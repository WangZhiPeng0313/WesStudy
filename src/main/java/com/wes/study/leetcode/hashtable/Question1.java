package com.wes.study.leetcode.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question1 {

    public static int[] solution1(int[] nums, int target){

        if(nums == null ||nums.length < 2) return new int[]{-1, -1};
        Map<Integer, Integer> cache = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(cache.containsKey(nums[i])) {
                return new int[]{cache.get(nums[i]), i};
            }
            else cache.put(nums[i], i);
        }

        return new int[]{-1, -1};

    }

}

package com.wes.study.leetcode.hot;

import java.util.HashMap;
import java.util.Map;

public class Question1 {

    public static void main(String[] args) {

    }

    public static int[] solution(int[] nums, int target){
        if(nums == null || nums.length < 2) return new int[]{-1, -1};
        Map<Integer, Integer> cache = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++){
            int tmp = target - nums[i];
            if(cache.containsKey(tmp)) {
                return new int[]{cache.get(tmp), i};
            }
            else {
                cache.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}

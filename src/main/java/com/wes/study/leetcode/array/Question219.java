package com.wes.study.leetcode.array;

import javax.management.remote.rmi._RMIConnection_Stub;
import java.util.HashMap;
import java.util.HashSet;

public class Question219 {

    public static void main(String[] args) {

    }

    /**
     * Hash
     * @param nums
     * @param k
     * @return
     */
    public static boolean solution(int[] nums, int k) {
        if(nums == null || nums.length == 0) return false;

        HashMap<Integer, Integer> cache = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(cache.containsKey(nums[i])) {
                int index = cache.get(nums[i]);
                if(i - index <= k) return true;
                else cache.put(nums[i], i);
            }
            else cache.put(nums[i], i);
        }

        return false;
    }
}

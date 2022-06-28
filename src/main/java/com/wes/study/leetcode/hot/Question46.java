package com.wes.study.leetcode.hot;

import java.util.*;

public class Question46 {

    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> chars = new ArrayList<>();
        dfs(ans, chars, nums, 0);
        return ans;
    }

    public static void dfs(List<List<Integer>> ans, List<Integer> chars, int[] nums, int index){
        if(index == nums.length) {
            ans.add(new ArrayList(chars));
            return;
        }

        for(int num : nums){
            if(chars.contains(num)) continue;
            chars.add(num);
            dfs(ans, chars, nums, index + 1);
            chars.remove(chars.size() - 1);
        }
    }
}

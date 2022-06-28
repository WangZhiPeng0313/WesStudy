package com.wes.study.leetcode.hot;

import java.lang.reflect.Array;
import java.util.*;

public class Question39 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,3,6,7}, 7));
    }

    public static List<List<Integer>> solution(int[] candidates, int target) {
        int[] flags = new int[candidates.length];
        for (int i = 0; i < flags.length; i++) flags[i] = 0;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(ans, new ArrayList<>(), candidates, target, Integer.MIN_VALUE);
        return ans;
    }


    public static void dfs(List<List<Integer>> ans, List<Integer> nums, int[] candidates, int target, int value){
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum == target){
            ans.add(new ArrayList<>(nums));
            return;
        }
        else if(sum > target) return;

        // 开始进行计算
        for(int cand : candidates){
            nums.add(cand);
            if(cand >= value) dfs(ans, nums, candidates, target, cand);
            nums.remove(nums.size() - 1);
        }
    }
}

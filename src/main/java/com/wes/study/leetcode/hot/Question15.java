package com.wes.study.leetcode.hot;

import java.util.*;

public class Question15 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{0, 0, 0, 0}).size());
    }

    /**
     * 因为需要去重，所以得先排序，排序后通过相邻的位置进行去重
     * (1) 排序
     * (2) 相同位置的直接进行过滤
     * (3) 因为求和为0，采用双端双指针的方式进行循环，
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> solution(int[] nums){
        Map<Integer, Integer> cache = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            if(i >= 1 && nums[i] == nums[i-1]) continue;

            int left = i + 1, right = nums.length -1;
            while(left < right){
                // 判断值是否为0
                int tmpSum = nums[i] + nums[left] + nums[right];
                if(tmpSum == 0){
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right  && nums[left] == nums[left + 1]) left++;
                    left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;
                    right--;
                }
                else if(tmpSum > 0){
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    right--;
                }
                else {
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    left++;
                }
            }
        }

        return ans;
    }
}

package com.wes.study.leetcode.hot;

public class Question42 {

    public static int solution(int[] height){
        int left = 0, right = height.length -1;
        int maxLeft = 0, maxRight = 0;
        int ans = 0;

        while(left < right) {
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);

            if(height[left] < height[right]){
                ans += maxLeft - height[left];
                left++;
            }
            else {
                ans += maxRight - height[right];
                right--;
            }
        }

        return ans;
    }
}

package com.wes.study.leetcode.hot;

import javax.swing.plaf.ProgressBarUI;
import java.util.*;

public class Question11 {

    public static int solution1(int[] height){
        int left = 0, right = height.length - 1;

        int ans = 0;

        while(left < right){
            // 计算这次的面试是否大于上一次的面积
            int area = (right - left + 1) * Math.min(height[left], height[right]);
            ans = Math.max(ans, area);

            // 由于 right - left 会变小，因此面积的增加必然需要left 和 right 的 height最小值变大，
            // 因此当 height[left] < height[right]是，则需要移动左指针，让左指针的值变大
            // 当 height[left] > height[right]时，则移动right指针，让右指针的值表达
            if(height[left] <= height[right]) {
                int tmp = height[left];
                while(left < right) {
                    if(height[left] > tmp) break;
                    else left++;
                }
            }
            else {
                int tmp = height[right];
                while(right > left)
                    if(height[right] > tmp) break;
                    else right--;
            }
        }
        return ans;
    }
}

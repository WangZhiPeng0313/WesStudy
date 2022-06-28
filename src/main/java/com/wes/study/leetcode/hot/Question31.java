package com.wes.study.leetcode.hot;

import java.util.Arrays;

public class Question31 {

    public static void main(String[] args) {
        solution(new int[] {1,2,3} );
    }

    /**
     * (1) 判断是否为最大值，即数组为倒序排序
     * (2) 如果是最大值，则将数据进行反转变成正序
     * (3) 如果不是最大值，则存在 num[i - i] < num[i]
     * (4) 从 num[i] - num[len - 1]之间选择比nun[i]大的最小值和 num[i - 1 ] 进行替换
     * (5) 将 num[i] - num[len - 1] 反转
     * @param nums
     */
    public static void solution(int[] nums) {
        boolean isMax = true;
        int i = nums.length -1 ;
        for(; i > 0; --i){
            if(nums[i-1] < nums[i]){
                isMax = false;
                break;
            }
        }

        if(isMax){
            // 进行数组的反转
            int left = 0, right = nums.length -1;
            while(left < right){
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
        else {
            int chgVal = nums[i - 1];
            int j = nums.length - 1 ;
            // 找到第一个比chgVal大的值，然后进行替换
            while(j >= i) if(nums[j] > chgVal) break; else --j;
            // 进行替换
            nums[i - 1] = nums[j];
            nums[j] = chgVal;

            // 进行倒序
            int left = i, right = nums.length -1;
            while(left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
    }
}

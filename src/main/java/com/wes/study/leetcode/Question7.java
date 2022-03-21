package com.wes.study.leetcode;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）
 *
 *
 */
public class Question7 {

    public static void main(String[] args) {
        int result = solution(-18);
        System.out.println(result);
    }

    /**
     * 解题思路: 数字反转的实质就是从原始值的个位向上挨个取值，然后结果指拿到个位的值*10，不断累加
     * 因此是一个队列或者栈的数据问题
     * @return
     */
    public static int solution(int x) {
        if(x == 0) return 0;
        int result = 0;
        while(x != 0){
            if(result < Integer.MIN_VALUE/10 || result > Integer.MAX_VALUE/10) return 0;

            int tmp = x % 10;
            result = result*10 + tmp;
            x = x/ 10;
        }

        return result;
    }
}

package com.wes.study.leetcode.hot;

/**
 * 如何判断字符串的()是否合法
 * 动态规划法：动态规划法：第N次结果是由第N-1动作+本次行为组成，并且可以以为类推一直到最后一次
 * (1) 我们以"(",")"
 */
public class Question32 {

    /**
     * 合法括号的动态规划拆解为：
     * (1) 从左往右计算，没对括号的结果只有两个
     *      1) 以xxxx()的方式放置在现有合法字符串的右方
     *      2) 以(xxxx)的方式套在现有合法字符串的外部
     * @param s
     * @return
     */
    public static int solution(String s){

        // 该缓存有两个作用，第一个是
        int[] dp = new int[s.length()];
        int maxans = 0;

        for(int i = 1; i < s.length(); i++){
            // 判断是否是()，如果是则判断上次是否为有效字符串，然后进行叠加
            if(s.charAt(i) == '）') {
                if(s.charAt(i -1) == '(') {
                    dp[i] = (i >= 2 ? dp[i-2] + 2 : 0) + 2;
                }
                else if(i - dp[i -1] > 0 && s.charAt(i - 1 - dp[i-1] ) == '(') {
                    dp[i] = dp[i-1] + 2 +
                            // 判断(之前是不是也能连接起来，首先i - dp[i-1] - 1 为'('，如果前方合法，至少要有()
                            (i - dp[i - 1] >= 2 ? dp[i - dp[i-1] - 2] : 0);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return 0;
    }
}

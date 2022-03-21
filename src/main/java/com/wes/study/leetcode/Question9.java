package com.wes.study.leetcode;

public class Question9 {

    public static void main(String[] args) {
        System.out.println(solution(121));
    }

    public static boolean solution(int x){
        if(x < 0) return false;
        int tmp1 = x, tmp2 = 0;
        while(tmp1 != 0){
            int tmp = tmp1 % 10;
            tmp2 = tmp2 * 10 +  tmp;

            tmp1 = tmp1 / 10 ;
        }

        boolean result = x == tmp2 ? true : false;
        return result;
    }




}

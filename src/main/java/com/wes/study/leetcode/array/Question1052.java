package com.wes.study.leetcode.array;

public class Question1052 {

    public static void main(String[] args) {

    }

    public static int solution1(int[] customers, int[] grumpy, int minutes){
        if(customers == null || customers.length == 0) return 0;
        int len = customers.length;
        int[] resCus = new int[len];
        int cusSumMax = 0, cusSumMaxIndex = 0;
        for(int i = 0; i < len; i ++ ){
            // 判断是否会生气
            int isGrupy = 0;
            if(i < grumpy.length) {
                if(grumpy[i] == 0) isGrupy = 1;
                else isGrupy = 0;
            }
            else isGrupy = 1;

            resCus[i] = customers[i] * isGrupy;

            if(i >= minutes) {
                int tmp = cusSumMax + customers[i] - customers[i - minutes];
                if(cusSumMax < tmp) {
                    cusSumMax = tmp;
                    cusSumMaxIndex = i;
                }
            }
            else {
                cusSumMax = cusSumMax + customers[i];
                cusSumMaxIndex = i;
            }

        }

        //

        int resSum = 0;
        for(int res : resCus){
            resSum += res;
        }
        return resSum;
    }
}

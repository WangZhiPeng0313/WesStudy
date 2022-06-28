package com.wes.study.leetcode.hot;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

import java.util.ArrayList;
import java.util.Arrays;

public class Question48 {

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{1,2,3};
        matrix[1] = new int[]{4,5,6};
        matrix[2] = new int[]{7,8,9};

        solution(matrix);
    }

    public static void solution(int[][] matrix) {
        int len = matrix.length;

        for(int i = 0; i < len/2; i++){
            // 把末尾最后一个去掉
            for(int j = i; j < len - 1 - i; j++){
                // 缓存左上角的值
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[len-1-j][i];
                matrix[len-1-j][i] = matrix[len-i-1][len-1-j];
                matrix[len-i-1][len-1-j] = matrix[j][len-i-1];
                matrix[j][len-i-1] = tmp;

                System.out.println("======> ");
                for(int[] nums : matrix) {
                    for (int num : nums) System.out.print(num);
                    System.out.println();
                }
            }
        }
    }
}

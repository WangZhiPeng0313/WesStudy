package com.wes.study.alg.sort;

public class SelectSort {

    public static void main(String[] args) {
        int[] data = selectSort(new int[]{4,5,3,2,1});
        for(int i : data) System.out.println(i);
    }

    public static int[] selectSort(int[] data){
        if(data == null || data.length < 2) return data;
        // 使用data.length-1是因为最后一次循环不需要处理
        for(int i =0; i<data.length-1;i++){
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            // 寻找最小值和INDEX，需要遍历整个数组
            for(int j = i; j<data.length;j++){
                if(data[j] < min) {
                    min = data[j];
                    minIndex = j;
                }
            }
            // 将最小值和第一个值进行交换
            int tmp = data[i];
            data[i] = min;
            data[minIndex] = tmp;
        }
        return data;
    }
}

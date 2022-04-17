package com.wes.study.alg.sort;

/**
 * 插入排序
 * 将获取的数据插入到已排序数据的指定位置中
 *      插入的方式为:
 *          (1) 从后往前插入: 插入值从后往前一个一个的对比大小，并且进行交换，直到插入值小于当前值
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] data = sort(new int[]{5,4,3,2,1});
        for(int i:data) System.out.println(i);
    }

    public static int[] sort(int[] data){
        if(data == null || data.length < 2) return data;

        for(int i=1; i<data.length;i++){
            // 循环对比直到第二个
            for(int j=i;j>0;j--){
                //
                if(data[j] < data[j-1]) {
                    int tmp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = tmp;
                }
            }
        }
        return data;
    }
}

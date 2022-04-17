package com.wes.study.alg.sort;

public class CountSort {

    public static void main(String[] args) {
        int[] result = countSort(new int[]{6,6,5,5,3,3});
        for(int r : result) System.out.println(r);
    }

    public static int[] countSort(int[] data){
        if(data == null || data.length < 2) return data;

        // 获取数组的最大最小值
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int d : data){
            if(min > d) min =d;
            if(max < d) max =d;
        }

        // 创建最大最小对应的数据
        int[] cache = new int[max - min + 1];
        for(int d : data){
            int index = d - min;
            cache[index] = cache[index] + 1;
        }

        // 重新填充数组
        int index = 0;
        for(int i = 0 ; i< cache.length; i++){
            int size = cache[i];
            for(int j = 0; j < size; j++) {
                data[index++] = min+i;
            }
        }
        return data;
    }
}

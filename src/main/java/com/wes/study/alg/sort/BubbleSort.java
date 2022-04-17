package com.wes.study.alg.sort;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;

public class BubbleSort {

    public static void main(String[] args) {
        int data[] = sort(new int[]{1,2,3,5,4});
        for(int i : data) System.out.println(i);
    }

    public static int[] sort(int[] data){
        if(data == null || data.length < 2) return data;

        // 每次循环判断是否已经有序
        boolean sorted = true;
        // 判断每次交换的位置
        int changeLastIndex = 0;
        int sortBround = data.length - 1;

        // 冒泡排序只需要N-1次循环，因为剩余一个节点时不需要冒泡
        for(int i=0; i<data.length-1;i++){
            // 一次循环中，冒泡需要和下一个元素对比，因此只需要循环到data.length-1
            // 在第一次循环完成后，第二次循环不再需要对比最后一个位置的数据，因为已经排序过了
            // 为提高效率，当发现本次循环没有交换数据时，则表示整个数组完成了排序
            for(int j=0; j < sortBround; j++){
                if(data[j] > data[j+1]) {
                    sorted = false;
                    int tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                    // 这里不能直接修改sortBrond，否则循环出现问题
                    changeLastIndex = j;
                }

                if(sorted) break;
                sortBround = changeLastIndex;
            }
        }
        return data;
    }
}

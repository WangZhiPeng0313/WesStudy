package com.wes.study.alg.sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] result = sort(new int[]{5,4,3,2,1});
        for(int i : result) System.out.println(i);
    }

    /**
     * 归并排序算法
     *  (1) 归: 将一个需要排序的数组，通过递归的方式一段一段的拆分，指导成为不可拆分的状态
     *  (2) 并: 从不可拆分的小段开始，反递归路径进行一段一段的排序合并，最后完成排序
     * @return
     */
    public static int[] sort(int[] data){
        if(data == null || data.length < 2) return data;

        int[] result = new int[data.length];
        mergeSort(data, result,0, data.length - 1);

        return data;
    }

    public static void mergeSort(int[] data, int[] result, int left, int right){
        // System.out.println("left= " + left + " and right =" + right);
        if(left >= right) return;

        int mid = (left + right) / 2;
        // 先对左边进行排序
        mergeSort(data, result, left, mid);
        // 然后对右边进行排序
        mergeSort(data, result, mid+1, right);
        // 当左右两边有序了，则需要把左右两边进行合并
        merge(data, result, left, mid, right);
    }

    public static void merge(int[] data, int[] result, int left, int mid, int right) {
        int i = left, j = mid + 1, index = left;
        while(i <= mid && j <= right){
            if(data[i] <= data[j] ) {
                result[index] = data[i];
                index++;
                i++;
            }
            else {
                result[index] = data[j];
                index++;
                j++;
            }
        }

        while(i <= mid){
            result[index] = data[i];
            index++;
            i++;
        }
        while(j <= right){
            result[index] = data[j];
            index++;
            j++;
        }

        // 需要将排序的数据复制到原来的数据，因为递归回去后，还需要用原始数据进行排序
        for(int m =left; m <= right; m++){
            data[m] = result[m];
        }
    }

}

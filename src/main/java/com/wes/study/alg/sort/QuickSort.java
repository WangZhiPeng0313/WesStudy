package com.wes.study.alg.sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] result = sort(new int[] {2,4,3,6,8,0,5,10});
        for(int i : result) System.out.println(i);
    }

    /**
     * 快速排序
     *  采用了递归的思想，每次将游标的数值排序到指定位置
     *      (1) 从当前需排序数据中选择游标，
     *      (2) 将数据中比游标小的数据排到左侧，将比游标大的数据排到右侧
     *      (3) 将游标数据插入到左侧和右侧的中间，从而完成游标位置的排序
     *      (4) 将游标左/右侧的数组循环到(1)中，对游标左/右侧的游标进行排序
     * @param data
     */
    public static int[] sort(int[] data){
        if(data == null || data.length < 2) return data;

        quickSort(data, 0, data.length - 1 );

        return data;
    }

    public static void quickSort(int[] data, int left, int right){
        if(left >= right) return;
        // 设定好游标
        int value = data[left];
        // 不能用 left+1，因为当排序的数组长度为2时，就会导致无法排序
        int indexLeft = left;
        int indexRight = right;

        while(indexLeft < indexRight){
            // 因为选择最左侧的值当做游标，最后游标和循环完的值进行交换时，必须要求交换值小于游标
            // 根据上述要求，必须先从右侧开始循环，因为右侧停止时，indexRight的值小于游标
            // 寻找右侧比游标小的值
            while(indexLeft < indexRight && data[indexRight] > value) {
                indexRight--;
            }

            // 寻找左侧比游标大的值
            while(indexLeft < indexRight && data[indexLeft] <= value) {
                indexLeft++;
            }

            // 需要判断是交换还是退出
            if(indexLeft < indexRight){
                int tmp = data[indexLeft];
                data[indexLeft] = data[indexRight];
                data[indexRight] = tmp;
            }
        }

        // 将游标放置到合适的位置
        int tmp = data[indexLeft];
        data[indexLeft] = value;
        data[left] = tmp;

        // 对游标左右两侧进行排序
        quickSort(data, left, indexLeft - 1);
        quickSort(data, indexLeft + 1, right);

    }
}

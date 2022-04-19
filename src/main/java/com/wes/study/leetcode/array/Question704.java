package com.wes.study.leetcode.array;

/**
 * 给定一个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question704 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        int index = solution3(nums, 9);
        System.out.println(index);
    }

    // 暴力循环法
    public static int solution1(int[] nums, int target){
        // 数据为NULL或者空时，则返回
        if(nums == null || nums.length == 0) return -1;
        // 暴力循环
        for(int i =0; i< nums.length; i++){
            if(nums[i] == target){
                return i;
            }
        }

        return -1;
    }

    // 二分查找法想
    public static int solution2(int[] nums, int target){
        if(nums ==null || nums.length == 0) return -1;

        return binarySearch(nums, target, 0, nums.length - 1);
    }

    /**
     * 采用递归的方式进行二分查找的处理
     * 二分查找中的核心点有两个:
     *  (1) 查找边界: 在找到中值时，进行左侧和右侧的查找时，不需要包含MID，因此查找的范围是[left, mid-1] 或者 [mid + 1, right]
     *  (2) 结束条件: 当left > right时结束
     *      当 (left + right)/2 == left时，通过mid -1 或者 mid + 1 的方式使得函数结束
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return
     */
    public static int binarySearch(int[] nums, int target, int left, int right) {
        // 先判断该次递归调用是否继续：当left > right时，则直接返回
        if(left > right) return -1;
        // 根据二分法，找到目标值
        int mid = (left + right)/2;
        // 比较二分中值与目标值的大小，相同时直接返回
        if(target == nums[mid]) return mid;
        // 当中值大于目标值是，则使用目标值的左半部分继续进行搜索[left, mid -1]，这里MID已经比较过了，没必要继续参与比较了
        else if(target < nums[mid]) return binarySearch(nums, target, left, mid-1);
        // 同上
        else if(target > nums[mid]) return binarySearch(nums, target, mid + 1, right);
        // 当三个条件都不满足时，则直接返回-1
        return -1 ;
    }

    /**
     * x
     * @param nums
     * @param target
     * @return
     */
    public static int solution3(int[] nums, int target){
        if(nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }


}

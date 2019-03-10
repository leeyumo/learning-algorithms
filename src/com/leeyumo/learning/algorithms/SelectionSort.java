package com.leeyumo.learning.algorithms;

public class SelectionSort {
    /**
     *选择排序，找出最小的固定在第一个，之后以此类推
     */
    private static void selectionSort(int[] toSort) {
        for (int i = 0; i < toSort.length; i++) {
            for (int j = i + 1; j < toSort.length; j++) {
                if (toSort[i] > toSort[j]) {
                    int temp = toSort[i];
                    toSort[i] = toSort[j];
                    toSort[j] = temp;
                }
            }
        }
        /**
         * 由于是正向循环，第一次循环第0个元素
         * 需要用第0个元素比较所有元素，如果比某元素大，则互换
         * 从而实现循环下来后，第0个元素是最小的，之后进入下一次外部循环
         * 最终得到正序的数组
         * 时间复杂度计算：(n-1)+(n-2)+....=n^2
         */
    }

    public static void main(String[] args) {
        int[] toSort = {10, 9, 8, 14, 15, 5, 4, 3, 2};
        selectionSort(toSort);
        for (int i : toSort) {
            System.out.println(i);
        }
    }
}

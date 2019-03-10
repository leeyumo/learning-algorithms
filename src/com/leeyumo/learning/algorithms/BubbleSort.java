package com.leeyumo.learning.algorithms;

public class BubbleSort {
    /**
     * 冒泡排序，相邻的互换
     * 核心是把最大的推到最后，再把第二大的推到最后，以此类推……
     */
    private static void bubbleSort(int[] toSort){
        for (int i = 0; i < toSort.length; i++) {
            for (int j = 0; j < toSort.length-1-i; j++) {
                if (toSort[j]>toSort[j+1]){
                    int temp = toSort[j];
                    toSort[j] = toSort[j+1];
                    toSort[j+1] = temp;
                }
            }
        }
    }

    /**
     * 优化型冒泡排序
     */
    private static void bubbleSortImproved(int[] toSort){
        int endIndex = toSort.length-1;
        while (endIndex>0){
            int tag = 0;
            for (int j=0;j<endIndex;j++){
                if (toSort[j]>toSort[j+1]){
                    tag = j;//记录最后的交换位置，因为索引J后的都是最大的排好的
                    int temp = toSort[j];
                    toSort[j] = toSort[j+1];
                    toSort[j+1] = temp;
                }
            }
            endIndex=tag;
        }
    }

    public static void main(String[] args) {
        int[] toSort = {10, 9, 8, 14, 15, 5, 4, 3, 2};
        bubbleSort(toSort);
//        bubbleSortImproved(toSort);
        for (int i : toSort) {
            System.out.println(i);
        }
    }
}

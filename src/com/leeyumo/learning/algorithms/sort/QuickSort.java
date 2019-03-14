package com.leeyumo.learning.algorithms.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
    /**
     * 快速排序
     * 关键思路：认为序列本身已经排列好了
     * 实现方式：提取第一个元素，分别找出比其大的和比其小的元素放入不同集合，
     * 再分别对两边的集合进行同样的操作
     */
    private static void quickSort(List<Integer> toSort) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        Integer middle = toSort.get(0);
        for (int i = 1; i < toSort.size(); i++) {
            if (toSort.get(0).intValue() > toSort.get(i).intValue()) {
                left.add(toSort.get(i));
            } else {
                right.add(toSort.get(i));
            }
        }
        if (left.size() > 1) {
            quickSort(left);
        }
        if (right.size() > 1) {
            quickSort(right);
        }
        toSort.clear();
        toSort.addAll(left);
        toSort.add(middle);
        toSort.addAll(right);
    }

    private static void quickSortForArray(int[] toSort, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {//防止第一次错误传值
            return;
        }
        int middleIndex = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (toSort[middleIndex] > toSort[i]) {
                //把小的元素放在基准middle位左侧，其余元素各向右挪一位
                int temp = toSort[i];
                for (int j = i - 1; j >= middleIndex; j--) {
                    toSort[j + 1] = toSort[j];
                }
                toSort[middleIndex] = temp;
                middleIndex += 1;
            }
        }
        if (middleIndex > (startIndex + 1)) {
            quickSortForArray(toSort, startIndex, middleIndex - 1);
        }
        if (middleIndex < (endIndex - 1)) {
            quickSortForArray(toSort, middleIndex + 1, endIndex);
        }
    }

    public static void main(String[] args) {
//        Integer[] toSortInteger = {10, 9, 8, 7, 6, 5, 4, 3, 2};
//        List<Integer> initInts = Arrays.asList(toSortInteger);
//        List<Integer> ints = new ArrayList<>(initInts);
//        quickSort(ints);
//        ints.forEach(System.out::println);


        int[] toSort = {10, 9, 8, 14, 15, 5, 4, 3, 2};
        quickSortForArray(toSort,0,toSort.length-1);
        for (int i : toSort) {
            System.out.println(i);
        }
    }
}

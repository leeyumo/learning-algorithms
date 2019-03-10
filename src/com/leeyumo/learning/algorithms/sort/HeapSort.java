package com.leeyumo.learning.algorithms.sort;

public class HeapSort {
    /**
     * 将数组包装成二叉树堆积结构
     *
     * @param toPackage
     * @param beginElement 起始元素序号，从1开始；因为每个树形元素的子集都对应的是该序号*2及*2+1
     *                     如第1个元素子集为 第2，第3；
     *                     第2的子集为第2*2和2*2+1……以此类推
     * @param heapLength 需要构建堆积结构数组的长度
     */
    public static void packageHeap(int[] toPackage, int beginElement ,int heapLength){
        if (heapLength<(beginElement*2)){
            return;
        }
        checkChildren(toPackage, beginElement,heapLength);
        packageHeap(toPackage,beginElement*2,heapLength);
        if (heapLength>=(beginElement*2+1)){
            packageHeap(toPackage,beginElement*2+1,heapLength);
        }
        checkChildren(toPackage, beginElement,heapLength);

    }

    /**
     * 看树中的元素是否大于父节点，是则交换，保证父节点最大
     * @param toPackage
     * @param beginElement
     * @return
     */
    private static void checkChildren(int[] toPackage, int beginElement ,int heapLength) {
        if (toPackage[beginElement-1]<toPackage[beginElement*2-1]){
            swapInArray(toPackage,beginElement-1,beginElement*2-1);
        }
        if (heapLength>=(beginElement*2+1)
                &&toPackage[beginElement-1]<toPackage[beginElement*2+1-1]){
            swapInArray(toPackage,beginElement-1,beginElement*2+1-1);
        }
    }

    /**
     * 交换数组中元素，暂不考虑下标越界问题
     * @param paramArray
     * @param param1Index
     * @param param2Index
     */
    private static void swapInArray(int[] paramArray,int param1Index,int param2Index){
        int temp = paramArray[param1Index];
        paramArray[param1Index]=paramArray[param2Index];
        paramArray[param2Index]=temp;
    }

    /**
     * 对已经是堆积结构的数组进行排序，最大的放在最后，继续包装成堆积结构，以此类推……
     * @param heapedArray
     */
    public static void heapSort(int[] heapedArray){
        int tag = heapedArray.length;
        while (tag>1){
            swapInArray(heapedArray,0,tag-1);
            packageHeap(heapedArray,1,tag-1);
            tag-=1;
        }

    }

    public static void main(String[] args) {
        int[] toSort = { 6, 5, 3, 1, 8, 7, 2, 4 };
        packageHeap(toSort,1,toSort.length);
        heapSort(toSort);
        for (int i : toSort) {
            System.out.println(i);
        }
    }
}

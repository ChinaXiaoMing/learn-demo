package com.example.demo.algorithms.part1;

public class BinarySearch {

    /**
     * 二分查找
     * @param key 待查找的数
     * @param a 查找范围数组
     * @return 查找元素首次出现时的数组下标
     */
    public static int rank(int key, int[] a) {
        int low = 1;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (key < a[mid]) {
                high = mid - 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {11, 1, 45, 100, 45, 20, 40};
        int result = rank(45, a);
        System.out.println(result);
    }

}

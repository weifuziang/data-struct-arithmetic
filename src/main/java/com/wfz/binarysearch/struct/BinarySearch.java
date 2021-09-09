package com.wfz.binarysearch.struct;

public class BinarySearch {


    public static void main(String[] args) {

        int[] arr = {1, 6, 8, 10, 12, 54, 80, 100};


        System.out.println(binarySearch(arr, 0, arr.length - 1, 12));

    }


    private static int binarySearch(int[] arr, int left, int right, int target) {


        int middle = (left + right) / 2;

        //递归到最后没找到元素，则返回-1，方法出栈
        if (left > right) {

            return -1;
        }

        if (target < arr[middle]) {//目标元素小于middle元素，则向左边查找

            return binarySearch(arr, left, middle - 1, target);

        } else if (target > arr[middle]) {//目标元素大于middle元素，则向右边查找

            return binarySearch(arr, middle + 1, right, target);

        } else {//递归找到了对应元素，则返回元素，方法出栈
            return middle;
        }


    }

}

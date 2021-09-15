package com.wfz.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = new int[]{12, 3, 1, 67, 13, 7, 3, 0};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));

    }


    private void quickSort(int[] arr, int left, int right) {

        int middleIndex = (left + right) / 2;
        int middleValue = arr[middleIndex];

        int l = left;
        int r = right;

        while (left < right) {


            while (arr[left] < middleValue) {

                left++;

            }


            while (arr[right] > middleValue) {

                right--;
            }

            if (left > right) {

                break;

            }

            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;

        }

        //左递归
        if (l < middleIndex) {

            quickSort(arr, l, middleIndex);

        }

        //右递归
        if (r > middleIndex) {

            quickSort(arr, middleIndex, r);

        }

    }

}


package com.wfz.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {


        int[] arr = {8, 4, 5, 7, 1, 3, 6,2};
        int[] ints = new int[arr.length];

        MergeSort.divide(arr, 0, arr.length - 1, ints);

        System.out.println(Arrays.toString(arr));

    }


    private static void divide(int[] arr, int left, int right, int[] tmp) {


        //int[] arr = {8, 4, 5, 7, 1, 3, 6,2};
        if (left < right) {

            int middle = (left + right) / 2;

            System.out.println(1);
            divide(arr, left, middle, tmp);
            System.out.println(2);
            divide(arr, middle + 1, right, tmp);
            System.out.println(4);
            mergerSort(arr, left, middle, right, tmp);


        }


    }

    private static void mergerSort(int[] arr, int left, int middle, int right, int[] tmp) {


        System.out.println(5);
        int t = 0;
        int i = left;
        int j = middle + 1;

        while (i <= middle && j <= right) {
            if (arr[i] < arr[j]) {

                tmp[t] = arr[i];
                i++;
                t++;

            } else {

                tmp[t] = arr[j];
                j++;
                t++;
            }

        }

        while (i <= middle) {

            tmp[t] = arr[i];
            i++;
            t++;

        }

        while (j <= right) {

            tmp[t] = arr[j];
            j++;
            t++;

        }


        System.out.println("================================start===========================================");
        t = 0;
        int tmpIndex = left;
        while (tmpIndex <= right) {

            arr[tmpIndex] = tmp[t];
            t++;
            tmpIndex++;

            System.out.println("tmp:  ");
            System.out.println(Arrays.toString(tmp));

            System.out.println("tmp================");

            System.out.println("arr:  ");

            System.out.println(Arrays.toString(arr));
            System.out.println("arr================");

        }


        System.out.println("================================end===========================================");


    }
}

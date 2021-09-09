package com.wfz.binarysearch.struct;

public class BinarySearch {


    public static void main(String[] args) {

        int[] arr = {1, 6, 8, 10, 12, 54, 80, 100};


        System.out.println(binarySearch(arr, 0, arr.length - 1, 12));

    }


    private static int binarySearch(int[] arr, int left, int right, int target) {


        int middle = (left + right) / 2;

        if (left > right) {

            return -1;
        }

        if (target < arr[middle]) {

            System.out.println("<");

            return binarySearch(arr, left, middle - 1, target);

        } else if (target > arr[middle]) {

            System.out.println(">");

            return binarySearch(arr, middle + 1, right, target);

        } else {

            return middle;
        }


    }

}

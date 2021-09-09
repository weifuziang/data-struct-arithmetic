package com.wfz.binarysearch.apply;

import java.util.Arrays;

public class SearchIndex {

       /*
    binarySearch需求1

    需求说明：
    查找数组，中目标元素的最大索引和最小索引？

    思路分析：
        1. 使用二分查找，找到目标元素的index；
        2. 判断目标元素的index，左边或者右边是否还有相同的元素值；
        3. 如果有，则循环查到，直到不相等，记录此时的最大和最小索引，并退出；
     */


    public static void main(String[] args) {

        int[] arr = new int[]{1, 3, 5, 7, 8, 8, 8, 9, 10, 10, 11};

        SearchMaxAndMinIndex searchMaxAndMinIndex = new SearchMaxAndMinIndex();

        System.out.println(Arrays.toString(searchMaxAndMinIndex.searchMaxAndMinIndex(arr, 0, arr.length - 1, 1)));


    }


}

class SearchMaxAndMinIndex {



    int[] searchMaxAndMinIndex(int[] arr, int left, int right, int target) {


        if (left > right) {//递归到最后，没有找到元素则退出；

            return new int[]{-1, -1};
        }

        int middle = (left + right) / 2;

        if (target == arr[middle]) {//找到元素，则需要判断目标元素左右两边是否还有相同的元素

            int minIndex = middle;
            int maxIndex = middle;

            int[] result = new int[2];

            do {//判断元素，左边是否还有相同的元素，且index不能小于0 ,否则会出现数组越界；

                result[0] = minIndex;

                minIndex--;


            } while (maxIndex > 0 && arr[middle] == arr[minIndex]);

            do {////判断元素，右边是否还有相同的元素，且index不能大于arr.lenght ,否则会出现数组越界；

                result[1] = maxIndex;

                maxIndex++;

            } while (maxIndex < arr.length && arr[middle] == arr[maxIndex]);

            return result;

        } else if (target < arr[middle]) {//目标元素小于middle指向的值，则向左边查找

            return searchMaxAndMinIndex(arr, left, middle - 1, target);

        } else {//目标元素大于middle指向的值，则向右边查找

            return searchMaxAndMinIndex(arr, middle + 1, right, target);
        }


    }

}

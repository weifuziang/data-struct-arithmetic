package com.wfz.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

//        int[] arr = new int[]{12, 3, 1, 67, 13, 7, 3, 0};

        int[] arr = {-9, 78, 0, 23, 567, 900, 90, 90, 566, 90};

        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));

    }


    private void quickSort(int[] arr, int left, int right) {

        int middleIndex = (left + right) / 2;
        int middleValue = arr[middleIndex];

        //要保存初始进来的left 和 right目的是为，向左或者向右循环递归
        int l = left;
        int r = right;

        while (left < right) {


            //中间元素数据的左边元素数据，从最左边开始和中间元素数据不断比较，
            //直找到一个大于等于中间元素数据的元素数据，停止循环，并获取到当前left
            //最坏的结果就是找到和middleValue相等的值
            while (arr[left] < middleValue) {

                left++;

            }

            //中间元素数据的右边元素数据，从最右边开始和中间元素数据不断比较，
            //直找到一个小于等于中间元素数据的元素数据，停止循环，并获取到当前left
            //最坏的结果就是找到和middleValue相等的值
            while (arr[right] > middleValue) {

                right--;
            }

            if (left >= right) {

                break;

            }

            System.out.println("left: " + left + "|" + arr[left] + "  ====  " + "right: " + right + "|" + arr[right]);
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;

            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            //相当于，右边已经循环到了middleValue，可以不动了，此时 这个条件while (arr[right] > middleValue)
            // 会循环拿出arr[left]=middleValue这个值来做对比
            if (arr[left] == middleValue) {
                System.out.println("index begin right: " + right);
                right -= 1;
                System.out.println("index after right: " + right);

            }
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            //相当于，左边已经循环到了middleValue，可以不动了，此时 这个条件 while (arr[left] < middleValue)
            // 会循环拿出arr[right]=middleValue这个值来做对比
            if (arr[right] == middleValue) {
                System.out.println("index begin left: " + left);
                left += 1;
                System.out.println("index begin left: " + left);

            }

        }


        // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
        if (left == right) {

            left++;
            right--;
        }

        //左递归r
        if (l < right) {

            quickSort(arr, l, left);

        }

        //右递归
        if (r > left) {

            quickSort(arr, left, r);

        }

    }

}


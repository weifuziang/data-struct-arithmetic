package com.wfz.sort;

import java.util.Arrays;

public class QuickSort {

    /*
    2. 快速排序struct

    2.1 QuickSort

        a. 思路分析
            1. 取出集合中的中的位置的元素middle，然后逐一拿两边的元素去和比较；
            2. 将大于元素middle的放到它的右边，将小于元素middle的放到它的左边；
            3. 取出元素middle到最左边元素的中间位置的元素middle2，按照上述2的方式比较；
            4. 同样，取出元素middle到最右边元素的中间位置的元素middle3，按照上述的方式比较；
            5. 递归循环上述 1、2、3、4步骤，直到最终的集合是一个有序的集合位置；

        b. 核心思想

     */

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
                left += 1;
            }

            //中间元素数据的右边元素数据，从最右边开始和中间元素数据不断比较，
            //直找到一个小于等于中间元素数据的元素数据，停止循环，并获取到当前left
            //最坏的结果就是找到和middleValue相等的值
            while (arr[right] > middleValue) {
                right -= 1;
            }

            //递归终止条件,触发，则出栈
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

                right -= 1;

            }
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            //相当于，左边已经循环到了middleValue，可以不动了，此时 这个条件 while (arr[left] < middleValue)
            // 会循环拿出arr[right]=middleValue这个值来做对比
            if (arr[right] == middleValue) {

                left += 1;

            }



        }


        // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
        if (left == right) {

            left++;
            right--;
        }

        //左递归r
        if (l < right) {

            quickSort(arr, l, right);

        }

        //右递归
        if (r > left) {

            quickSort(arr, left, r);

        }

    }

}


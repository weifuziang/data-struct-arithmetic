package com.wfz.sort;

import java.util.Arrays;

public class InsertOrder {
    /*
    3. 插入排序struct

    3.1 insertSearch

        a. 思路分析
            1. 升序排序
            2. 将无序的数组arr，看成两个数组，一个是有序的数组（数组前半截），和一个是无序的数组（数组后半截）；
            3. 将无序的数组，不断的向有序的数组中插入；
            4. 在每次插入的时候，要进行比较，若是升序，则将小放到前面，大的放到后面
            5. 在比大小的过中，使用的是移动的方式，将元素按顺序放入，而不是交换的方式

        b. 核心思想
            1. 将后面的数据，不断的向前插入，比较大小后，若没有找到合适的位置，需要将前面的数据先向后后移；
            2. 数据元素比较过程中，采用的不是交换的思路，而是移动的思路；
     */

    public static void main(String[] args) {

        int[] arr = {3, 1, 2, 6, 4, 10, 9, 12, 13, 8, 11};

        for (int i = 1; i < arr.length; i++) {

            //取出要目标插入数据；
            int insertValue = arr[i];
            //取出插入数据要进行比较的索引值；
            int insertIndex = i - 1;
            //在循环向前比较的过程中，不能出现数组越界，且在升序排序过程中，
            //如果出现目标插入数据小于前一个数据，则表示目标插入数据没有找到插入的位置，只需要前一个数据后移到此位置
            //并且，将insertIndex--，继续向前比较，直到出现目标插入数据 大于了 前一个数据，则跳出；
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                //将前一个数据，后移到目标插入数据的位置
                arr[insertIndex + 1] = arr[insertIndex];
                //继续向前比较
                insertIndex--;

            }
            //跳while循环出后，将目标插入数据放到前一个数据的后面，即insertIndex+1
            arr[insertIndex + 1] = insertValue;
            System.out.println(Arrays.toString(arr));

        }

        System.out.println(Arrays.toString(arr));

    }
}

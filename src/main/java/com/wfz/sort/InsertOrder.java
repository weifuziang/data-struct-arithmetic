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

        //1. 学习测试
//        int[] arr = {13, 3, 1, 2, 6, 4, 10, 9, 12, 8, 11};
//        System.out.println(insertOrder(arr));

        //2. 复习测试: 2022-03-26

        //[1, 2, 3, 4, 6, 9, 10, 12, 8, 11, 13]
//        int[] arr2 = {14, 3, 1, 2, 6, 4, 10, 9, 12, 13, 8, 11};
//        System.out.println(insertOrder2(arr2));

        //3. 复习测试: 2022-03-27
        //[1, 2, 3, 4, 6, 9, 10, 12, 8, 11, 13]
        int[] arr3 = {14, 3, 1, 2, 6, 4, 10, 9, 12, 13, 8, 11};
        System.out.println(insertOrder4(arr3));

    }


    //插入排除开始学习: 2021-06-01
    public static String insertOrder(int[] arr) {

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

        return Arrays.toString(arr);
    }


    //start-复习插入排序(升序）：2022-03-26
    public static String insertOrder2(int[] arr) {

        //错误代码如下:
        // 此时，如果在数组中后半段数据中，
        // 出现了比前半段的数据都要小的一个元素A，此时的方法中元素A只会被比较一次
        //==error=====start==========2022-03-26===========start========
//        for (int i = 0; i < arr.length - 1; i++) {
//            int tmp;
//            if (arr[i] >= arr[i + 1]) {
//
//                tmp = arr[i + 1];
//                arr[i + 1] = arr[i];
//                arr[i] = tmp;
//            }
//            System.out.println(Arrays.toString(arr));
//        }
        //==error=====end==========2022-03-26===========end========


        /**
         *
         * 插入排序核心思想
         * 1. 可以将一个乱序的数组拆分成两个数组，一个是前半段有序的数组A，一个是后半段无序的数组B；
         * 2. 我们循环取出后半段无序的数据B，在有序的数组A中，从最近的一个元素开始，循环判断找到符合自己投放的位置C；
         * 3. 找到自己投放的位置C，之后就直接跳出循环，再从无序的数组B中取出下一个元素；
         *
         * 注意点：
         * 1. 本质为双层循环，所以各自的循环，要分清楚各自的索引；
         * 2. 无序的索引i, 有序的索引insrtValue, 且两者的关系是insertIndex=i-1;
         */

        for (int i = 1; i < arr.length; i++) {

            //获取无序数组中的一个元素x
            int insertValue = arr[i];
            //以此索引为界限，前面的为有序的数组，后面的无序的，需要排序的数组；
            int insetIndex = i - 1;
            //升序，用元素x在有序的素组A中，找到适合自己的位置；
            while (
                    insetIndex >= 0 //防止在前半段有序的数组中查找当前元素适合的位置时，数组溢出，即终止条件；
                            && arr[insetIndex] > insertValue//升序，发现前面的元素大于后面的元素，则将前面的元素后移；
            ) {

                System.out.println("当前元素: " + insertValue + "寻找位");
                //将比较结果中，较大的元素向后移动
                arr[insetIndex + 1] = arr[insetIndex];
                //减小索引，继续去找较小元素适合的位置
                insetIndex--;

                System.out.println(Arrays.toString(arr));


            }
            //较小元素找到了合适的位置，但，在while循环里最后执行了insertIndex--，所以真正的位置应该是insertIndex+1
            arr[insetIndex + 1] = insertValue;

        }

        return Arrays.toString(arr);
    }
    //end-复习插入排序(升序）：2022-03-26

    //start-复习插入排序(升序）：2022-03-27

    /**
     * 插入排除的核心思想：
     * 1. 将目标数组可以看做成前半段是有序的数组A，和后半段无序的数组B；
     * 2. 循环拿出无序数据B中的每个元素C，在有序的数组A中循环判断，找到最适合的位置，并将该元素C插入到有序的数组B中；
     * 3. 在和有序的数组A中的元素比较中，使用移动的方法，将较大的元素向后移动，如下展示：
     *
     * 每一次移动后的数组展示: [14, 14, 1, 2, 6, 4, 10, 9, 12, 13, 8, 11]
     * 每一次移动后的数组展示: [3, 14, 14, 2, 6, 4, 10, 9, 12, 13, 8, 11]
     * 每一次移动后的数组展示: [3, 3, 14, 2, 6, 4, 10, 9, 12, 13, 8, 11]
     * 每一次移动后的数组展示: [1, 3, 14, 14, 6, 4, 10, 9, 12, 13, 8, 11]
     * 每一次移动后的数组展示: [1, 3, 3, 14, 6, 4, 10, 9, 12, 13, 8, 11]
     * 每一次移动后的数组展示: [1, 2, 3, 14, 14, 4, 10, 9, 12, 13, 8, 11]
     * 每一次移动后的数组展示: [1, 2, 3, 6, 14, 14, 10, 9, 12, 13, 8, 11]
     * 每一次移动后的数组展示: [1, 2, 3, 6, 6, 14, 10, 9, 12, 13, 8, 11]
     * 每一次移动后的数组展示: [1, 2, 3, 4, 6, 14, 14, 9, 12, 13, 8, 11]
     * 每一次移动后的数组展示: [1, 2, 3, 4, 6, 10, 14, 14, 12, 13, 8, 11]
     * 每一次移动后的数组展示: [1, 2, 3, 4, 6, 10, 10, 14, 12, 13, 8, 11]
     * 每一次移动后的数组展示: [1, 2, 3, 4, 6, 9, 10, 14, 14, 13, 8, 11]
     * 每一次移动后的数组展示: [1, 2, 3, 4, 6, 9, 10, 12, 14, 14, 8, 11]
     * 每一次移动后的数组展示: [1, 2, 3, 4, 6, 9, 10, 12, 13, 14, 14, 11]
     * 每一次移动后的数组展示: [1, 2, 3, 4, 6, 9, 10, 12, 13, 13, 14, 11]
     * 每一次移动后的数组展示: [1, 2, 3, 4, 6, 9, 10, 12, 12, 13, 14, 11]
     * 每一次移动后的数组展示: [1, 2, 3, 4, 6, 9, 10, 10, 12, 13, 14, 11]
     * 每一次移动后的数组展示: [1, 2, 3, 4, 6, 9, 9, 10, 12, 13, 14, 11]
     * 每一次移动后的数组展示: [1, 2, 3, 4, 6, 8, 9, 10, 12, 13, 14, 14]
     * 每一次移动后的数组展示: [1, 2, 3, 4, 6, 8, 9, 10, 12, 13, 13, 14]
     * 每一次移动后的数组展示: [1, 2, 3, 4, 6, 8, 9, 10, 12, 12, 13, 14]
     *
     * 注释:
     * 1. 注意有序的数组和无序的数组，各自的索引不要搞混乱了
     * @param arr
     * @return
     */

    public static String insertOrder4(int[] arr) {


        for (int i = 1; i < arr.length; i++) {

            int insertValue = arr[i];
            int insertIndex = i - 1;

            //自定义的有序数组中循环比较，知道找到insertValue合适的位置为止，最大的循环位置就是inserIndex=0
            while (insertIndex >= 0 &&
                    arr[insertIndex] > insertValue) {

                //较大元素向后移动
                arr[insertIndex + 1] = arr[insertIndex];
                //将insertIndex这个有序数组继续向前比较
                insertIndex--;

                System.out.println("每一次移动后的数组展示: "+Arrays.toString(arr));

            }
            //跳出循环，意味着找到了最合适的位置，但是insertIndex在while循环中是多进行了一次insertIndex，
            //来判断是不是循环到了最小的索引位置indexIndex=0,因此需要再执行一次insertIndex+1
            arr[insertIndex + 1] = insertValue;

        }

        return Arrays.toString(arr);
    }

    //end-复习插入排序(升序）：2022-03-27


}

package com.wfz.arithmetic.kmp;

import java.util.Arrays;

public class StringMatch_01 {

    /**
     * KMP算法的代码实现
     * 1. 原理的理解和代码实现有区别，尤其是在部分匹配值生成，和部分匹配值使用方面区别很大；
     * 2. 代码核心的kmp特征代码算法是：
     *  while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
     *                 j = next[j - 1];
     *             }，此代码，即适合部分匹配值生成，也适合部分匹配值的使用，本人是理解不了，但是可以先记住；
     * 3. 其他代码按照常规理解可写出；
     * 4. java中常用的String.contain()方式用的是暴力匹配，如果想优化，可尝试使用KMP算法；
     * @param args
     */

    public static void main(String[] args) {

        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD"; //[0, 0, 0, 0, 1, 2, 0]
//      String str3 = "AAAA"; //A AA AAA == AAA AA A [0,1,2,3]

        int[] next = kmpNext(str2);
        System.out.println(Arrays.toString(next));//[0, 0, 0, 0, 1, 2, 0]

        int i = kmpSearch(str1, str2, next);
        System.out.println(i);//15

    }


    /**通过子字符串的匹配值表，实现查找字符串算法
     * @param str1 主字符串
     * @param str2 子字符串
     * @param next 部分匹配值表
     * @return 如果是 -1 这没有找到，其他则为找到
     */
    public static int kmpSearch(String str1, String str2, int[] next) {

        //其中i 是str1的下标 ，j是子字符串str2的下表
        for (int i = 0, j = 0; i < str1.length(); i++) {

            //当出现非子字符串的首字符，匹配不相当的时候，则就要根据部分匹配值表，来调整j的位置，然后再开始比较
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            //当出现字符串匹配相当的时候，则进行j++,直接进行下一个i 和 j 的比较
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }

            if (j == str2.length()) {
                return i - j + 1;
            }

        }

        return -1;

    }

    /**
     * 获取到一个字符串（子串）的部分匹配值表
     * @param dest 子字符串
     * @return 部分匹配值表
     */
    public static int[] kmpNext(String dest) {
        //部分匹配值数组创建
        int[] next = new int[dest.length()];
        //当子字符中只有一个字符时，它的部分匹配值肯定就是0，或者说子字符中第一个字符的部分匹配值肯定也是0
        next[0] = 0;
        //此时，我们从子字符串的第二位，通过i,j循环获取子字符串中每组搜索词的"前缀"和"后缀"的共有元素个数，即为搜索词的匹配值
        for (int i = 1, j = 0; i < dest.length(); i++) {

            //当子字符串中出现了，从字符串的非第一个字符开始，出现了不同的字符，则进行如下算法，此算法是KMP的算法的核心点
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }

            //当子字符串中出现了，从字符串首字符开始一直相同的字符，则部分匹配值就是+1 ， 比如str2="AAAA" 则值为0，1，2，3
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;

        }

        return next;
    }
}

# data-struct-arithmetic
数据结构与算法的

===========查到算法==================================================================================

1. 二分查找struct

    1.1 binarySearch需求1
   
        a. 需求说明：
            查找数组，中目标元素的最大索引和最小索引？
      
        b. 思路分析：
            1. 使用二分查找，找到目标元素的index；
            2. 判断目标元素的index，左边或者右边是否还有相同的元素值；
            3. 如果有，则循环查到，直到不相等，记录此时的最大和最小索引，并退出；
           
    1.2 binarySearch需求2 
        
        a. 需求说明：
            
        b. 思路分析：

===========排序算法==================================================================================

1. 冒泡排序struct
 
2. 快速排序struct 

    2.1 QuickSort
        
        a. 思路分析
            1. 取出集合中的中的位置的元素middle，然后逐一拿两边的元素去和比较；
            2. 将大于元素middle的放到它的右边，将小于元素middle的放到它的左边；
            3. 取出元素middle到最左边元素的中间位置的元素middle2，按照上述2的方式比较；
            4. 同样，取出元素middle到最右边元素的中间位置的元素middle3，按照上述的方式比较；
            5. 递归循环上述 1、2、3、4步骤，直到最终的集合是一个有序的集合位置；
            
        b. 核心思想
      
3. 插入排序struct

    3.1 insertSearch

        a. 思路分析
            1. 升序排序
            2. 将无序的数组arr，看成两个数组，一个是有序的数组，和一个是无序的数组；
            3. 将无序的数组，不断的向有序的数组中插入；
            4. 在每次插入的时候，要进行比较，若是升序，则将小放到前面，大的放到后面
            5. 在比大小的过中，使用的是移动的方式，将元素按顺序放入，而不是交换的方式

        b. 核心思想
            1. 将后面的数据，不断的向前插入，比较大小后，若没有找到合适的位置，需要将前面的数据先向后后移；
            2. 数据元素比较过程中，采用的不是交换的思路，而是移动的思路；

4. 希尔排序struct

5. 归并排序struct

===========数据结构==================================================================================

1. 数组

2. 集合

3. 哈希表

4. 链表

5. 队列

6. 栈

7. 二叉树

8. 堆

===========经典算法==================================================================================

        
            
            
       

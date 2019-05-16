package com.hank.selectionsort;

public class SelectionSort {
    /*
           特点:这个和冒泡算法相反,每次第一轮到最后结尾的最后一对，一轮下来第一个元素最小,所以j=i

           案例： {3,38,5,44,47,15,36,26,27,2,46,4,19,50,48}

           for部分实例：
           i 0
           j 0,1,2,3,4,5,6,7,8,9,10,11,12,13

           i 1
           j 1,2,3,4,5,6,7,8,9,10,11,12,13

           i 2
           j 2,3,4,5,6,7,8,9,10,11,12,13
    */
    //选择排序
    public static int[] selectionSort(int[] array) {
        if (array.length == 0){
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) { //找到最小的数
                    minIndex = j; //将最小数的索引保存
                }
            }
            //每一轮下来找到最小的值的minIndex，然后最左边的值和这个值互换
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        int[] selectarr = selectionSort(arr);
        for (int i = 0; i < selectarr.length; i++) {
            System.out.print(selectarr[i] + ", ");
        }
    }
}

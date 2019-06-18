package com.hank.sort;

public class InsertionSort {
    /*

            案例： {3,38,5,44,47,15,36,26,27,2,46,4,19,50,48}

     */
    //插入排序
    public static int[] insertionSort(int[] array){
        if(array.length == 0){
            return array;
        }

        for(int i=0;i < array.length-1;i++){
            int current = array[i+1];
            int preIndex = i;
            //当current > array[preIndex]时候不互换
            while (preIndex >= 0 && current < array[preIndex]){
                array[preIndex+1] = array[preIndex];
                preIndex --;
            }
            //current < array[preIndex],所以是放在array[preIndex+1]里
            array[preIndex+1] = current;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        int[] selectarr = insertionSort(arr);
        for (int i = 0; i < selectarr.length; i++) {
            System.out.print(selectarr[i] + ", ");
        }
    }
}

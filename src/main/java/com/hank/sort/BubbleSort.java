package com.hank.sort;

/**
 *
 */
public class BubbleSort {
    /*
            特点:每次第一轮到最后结尾的最后一对，一轮下来最后的元素一定是最大的，所以下面的j长度是j<array.length-1

            案例： {3,38,5,44,47,15,36,26,27,2,46,4,19,50,48}

            for部分实例：
            i 0
            j 0,1,2,3,4,5,6,7,8,9,10,11,12,13

            i 1
            j 0,1,2,3,4,5,6,7,8,9,10,11,12

            i 2
            j 0,1,2,3,4,5,6,7,8,9,10,11
     */

    //冒泡排序
    public static int[] bubbleSort(int[] array){
        if(array.length == 0){
            return array;
        }
        for(int i =0;i<array.length-1;i++){
            for(int j=0;j<array.length -1 -i;j++){
                if(array[j+1]<array[j]){
                    int temp =array[j+1];
                    array[j+1] = array[j];
                    array[j] =temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        int[] bubblearr = bubbleSort(arr);
        for (int i = 0; i < bubblearr.length; i++) {
            System.out.print(bubblearr[i] + ", ");
        }
    }
}

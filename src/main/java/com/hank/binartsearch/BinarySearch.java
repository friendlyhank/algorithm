package com.hank.binartsearch;

/**
 *二分查找
 * Arrays.sorts
 * 可用于排好序的数组
 */
public class BinarySearch {
    static int rank1(int[] arr,int key){
        //区间[L,R]
        int L=0,R=arr.length-1;
        int mid;
        while(L <= R){
            mid = L + (R-L)/2;
            if (key < arr[mid]) R=mid-1;
            else if (key > arr[mid]) L=mid+1;
            else return mid;
        }
        return -1;
    }

    //和上面的完全一样，只是一开始R不是arr.length-1 而是arr.length
    static int rank2(int[] arr,int key){
        //区间[L,R]
        int L=0,R=arr.length;
        int mid;
        while (L < R){
            mid = L + (R - L)/2;
            if(arr[mid]==key){
                return mid;
            } if(arr[key] > key){
                R = mid;
            }else{
                L = mid +1;
            }
        }
        return -1;
    }

    /**查找第一个与key相等的元素的下标，　如果不存在返回-1　*/
    static int firstEqual(int[] arr,int key){
        //区间[L,R]
        int L=0,R= arr.length-1;
        int mid;
        while (L <= R){
            mid = L + (R - L)/2;
            if(arr[mid]>=key){
                R = mid -1;
            }else{
                L = mid + 1;
            }
        }
        //每次都从最小区间判断就得出第一次出现的值
        if(L < arr.length && arr[L] == key){
            return L;
        }
        return -1;
    }

    /**查找第一个大于等于key的元素的下标*/
    static int firstLargeEqual(int[] arr,int key){
        int L=0,R=arr.length-1;
        int mid;
        while (L <= R){
            mid = L + (R - L)/2;
            if(arr[mid] >= key){
                R = mid - 1;
            }else{
                L = mid +1;
            }
        }
        return L;
    }

    /**查找第一个大于key的元素的下标 */
    static int firstLarge(int[] arr,int key){
        int L = 0,R = arr.length - 1;
        int mid;
        while(L <= R){
            mid = L + (R - L) / 2;
            if(arr[mid] > key){
                R = mid - 1;
            } else{
                L = mid + 1;
            }
        }
        return L;
    }

    /**查找最后一个与key相等的元素的下标，　如果没有返回-1*/
    static int lastEqual(int[] arr,int key){
        int L = 0, R = arr.length - 1;
        int mid;
        while( L <= R){
            mid = L + (R - L)/2;
            if(arr[mid] <= key){
                L = mid + 1;
            } else{
                R = mid - 1;
            }
        }
        if(R >= 0 && arr[R] == key){
            return R;
        }
        return -1;
    }

    static int lastSmallEqual(int[] arr,int key){
        int L = 0, R = arr.length - 1;
        int mid;
        while( L <= R){
            mid = L + (R - L) / 2;
            if(arr[mid] <= key){
                L = mid + 1;
            } else{
                R = mid - 1;
            }
        }
        return R;
    }

    /**查找最后一个小于key的元素的下标*/
    static int lastSmall(int[] arr,int key){
        int L = 0, R = arr.length - 1;
        int mid;
        while(L <= R){
            mid = L + (R - L) / 2;
            if(arr[mid] < key){
                L = mid + 1;
            } else{
                R = mid - 1;
            }
        }
        return R;
    }


    public static void main(String[] args) {
        int[] arr = {1,3,4,6,6,6,6,6,6,8,9};
        System.out.println("----------general-----------");
        System.out.println(rank1(arr,6));
        System.out.println(rank2(arr,3));
        System.out.println(rank2(arr,6));

        //第一次出现的值
        System.out.println("----------first-----------");
        System.out.println(firstEqual(arr,3));

        //第一个　>= 的
        System.out.println(firstLargeEqual(arr,5));//3
        System.out.println(firstLargeEqual(arr,6));//3

        //第一个 > 的
        System.out.println(firstLarge(arr,6));

        //最后一个 = 的
        System.out.println(lastEqual(arr,6));

        //最后一个 <= 的
        System.out.println(lastSmallEqual(arr,7));
        System.out.println(lastSmallEqual(arr,6));

        //最后一个 < 的
        System.out.println(lastSmall(arr,6));//2
    }
}

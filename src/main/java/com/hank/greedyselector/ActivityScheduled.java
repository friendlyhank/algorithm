package com.hank.greedyselector;

/**
 * 活动安排问题用贪心算法求解
 */
public class ActivityScheduled {
    public static int greedySelector(int[] s,int[] f,boolean[] a){
        int n = s.length-1;
        a[0]=true;
        int j=0;
        int count =1;
        for(int i=1;i<=n;i++){
           if(s[i]>=f[j]){
               a[i]=true;
               j=i;
               count++;
           }else{
               a[i]=false;
           }
        }
        return count;
    }

    public static void main(String[] args) {
        /**
         * n个活动集合{1，2,...n}
         * si起始时间  1,3,0,5,3,5,6,8,8,2,12
         * fi结束时间  4,5,6,7,8,9,10,11,12,13,14
         * [si,fi]与区间[si,fi],不相交，则称活动i与活动j是相容的，
         * 活动安排问题就是要在所给的活动集合选出最大的相容活动子集合
         */
        int[] s={1,3,0,5,3,5,6,8,8,2,12};
        int[] f={4,5,6,7,8,9,10,11,12,13,14};
        boolean[] a={false,false,false,false,false,false,false,false,false,false,false};
        int count = ActivityScheduled.greedySelector(s,f,a);
        System.out.println(count);
        for(int k=0;k<a.length;k++){
            System.out.println(a[k]);
        }
    }
}

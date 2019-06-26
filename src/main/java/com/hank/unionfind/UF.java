package com.hank.unionfind;

/**
 * union-find算法
 */
public class UF {
    private int[] parent;//parent[i]=parent of i
    private byte[] rank;//rank[i] = rank of subtree rooted at i (never more than 31)
    private int count;//number of components

    /**
     * n the number of size
     * @param n
     */
    public UF(int n){
        if (n < 0) throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        int n=10;
        UF uf = new UF(n);

    }
}

/**
 * 这种算法可以表示成计算机网络中的计算机，整数对则表示网络中的连接。
 * 或者可以表示为电子电路中的触点，而整数对表示是连接触点之间的电路。
 * 或者可以表示为社交网络中的人，而整数对表示的是朋友关系。
 */

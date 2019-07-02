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
        parent = new int[n];
        rank = new byte[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0; //层级计算
        }
    }

    /**
     * Returns the component identifier for component containing site
     * @param p
     * @return
     */
    public int find(int p){
        //查找根结点
        while (p != parent[p]){
            parent[p] = parent[parent[p]];//path compression by halving
            p =parent[p];
        }
        return p;
    }

    /**
     * Returns the number of components
     * @return
     */
    public int count(){
        return count;
    }

    public  void union(int p,int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP==rootQ)return;

        if      (rank[rootP] < rank[rootQ]) parent[rootP] = rootQ;
        else if (rank[rootP] > rank[rootQ]) parent[rootQ] = rootP;
        else{
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        count--;
    }

    /**
     * validate that p a valid index
     * @param p
     */
    private void validate(int p){
        int n=parent.length;
        if(p < 0 || p >=n){
            throw new IllegalArgumentException("index "+p+"is now between 0 and "+ (n-1));
        }
    }

    public static void main(String[] args) {
        int n=10;
        UF uf = new UF(n);
        int[] ps ={4,3,6,9,2,8,5,7,6,1,6};
        int[] qs ={3,8,5,4,1,9,0,2,1,0,7};

        for(int i=0;i<ps.length;i++){
            uf.union(ps[i],qs[i]);
        }
    }
}

/**
 * 这种算法可以表示成计算机网络中的计算机，整数对则表示网络中的连接。
 * 或者可以表示为电子电路中的触点，而整数对表示是连接触点之间的电路。
 * 或者可以表示为社交网络中的人，而整数对表示的是朋友关系。
 */

package com.hank.unionfind;

public class WeightedQuickUnionUF {
    private int[]  parent;
    private int[] size;
    private int count;

    /**
     * Initializes an empty union–find data structure with {@code n} sites
     * @param n
     */
    public WeightedQuickUnionUF(int n){
        count = n;
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i]=1;
        }
    }

    /**
     * Returns the number of components.
     * @return
     */
    public int count(){
        return count;
    }

    /**
     * Returns the component identifier for the component containing site
     * @param p
     * @return
     */
    public int find(int p){
        while (p != parent[p])
            p = parent[p];
        return p;
    }

    /**
     * validate that p is a valid index
     * @param p
     */
    private void validate(int p){
        int n=parent.length;
        if(p < 0 || p >= n){
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
        }
    }

    /**
     * Returns true if the two sites are in the same componect
     * @param p the integer representing one site
     * @param q the integer representing one site
     * @return
     */
    public boolean connected(int p,int q){
        return find(p) == find(q);
    }

    /**
     * Returns true if the two sites are in the same componect
     * @param p
     * @param q
     */
    public void union(int p,int q){
        int rootP = find(p);
        int rootQ = find(q);

        if(rootP == rootQ)return;

        //make smaller root point to larger one
        if(size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }else{
            parent[rootQ]=rootP;
            size[rootP] += size[rootQ];
        }
        count --;
    }

    public static void main(String[] args) {
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(10);
        int[] ps ={4,3,6,9,2,8,5,7,6,1,6};
        int[] qs ={3,8,5,4,1,9,0,2,1,0,7};
        for(int i=0;i<11;i++){
            if(uf.connected(ps[i],qs[i])) continue;
            uf.union(ps[i],qs[i]);
            System.out.println(ps[i] + " "+qs[i]);
        }
        System.out.println(uf.count());
    }
}

/**
 * 解析:
 * (1)p和q的值是在n范围内的,一开始都会有n个初始化的值
 * (2)设定p和q怎么是连通的呢？思路是转化为多个树(森林),在同一个树上的触点都是相通的
 * (3)实现方式，每个树设置一个根结点
 * (4)将树结点少的合并到树结点多的
 *
 * 对数级别性能
 * 缺点：
 *
 */

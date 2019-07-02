package com.hank.unionfind;

/**
 * quick-union算法
 */
public class QuickUnionUF {
    private int[] parent;//parent[i] = parent of i
    private int count;//number of components

    /**
     * n the number of sites
     * @throws IllegalArgumentException
     */
    public QuickUnionUF(int n){
        parent = new int[n];
        count =n;
        for(int i=0;i < n;i++){
            parent[i]=i;
        }
    }

    /**
     * Returns the number of components
     * @return
     */
    public int count(){
        return count;
    }

    /**
     * 找到根结点
     * @param p
     * @return
     */
    public int find(int p){
        validate(p);
        while (p != parent[p])
            p = parent[p];
        return p;
    }

    /**
     * Returns true if the the two sites are in the same component.
     *
     * @param  p the integer representing one site
     * @param  q the integer representing the other site
     * @return {@code true} if the two sites {@code p} and {@code q} are in the same component;
     *         {@code false} otherwise
     * @throws IllegalArgumentException unless
     *         both {@code 0 <= p < n} and {@code 0 <= q < n}
     */
    public boolean connected(int p,int q){
        return find(p) == find(q);
    }

    /**
     * Merges the component containing site {@code p} with the
     * the component containing site {@code q}.
     *
     * @param  p the integer representing one site
     * @param  q the integer representing the other site
     * @throws IllegalArgumentException unless
     *         both {@code 0 <= p < n} and {@code 0 <= q < n}
     */
    public void union(int p,int q){
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        //设置根节点P 等于 根节点 Q
        parent[rootP] = rootQ;
        count--;
    }

    //validate that p is a valid index
    private void validate(int p){
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
        }
    }

    public static void main(String[] args) {
        QuickUnionUF uf = new QuickUnionUF(10);
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
 *
 * 缺点：
 * 平方级别
 * 2(1+2+...+N) ~N平方
 */
package com.hank.unionfind;

/**
 * quick-find算法
 */
public class QuickFindUF {
    private int[] id;//id[i]= component identifier of i
    private int count;//number of component

    /**
     *n the number of sites
     * @param n
     */
    public QuickFindUF(int n){
        count=n;
        id = new int[n];
        for(int i=0;i<n;i++){
            id[i]=i;
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
     * Return the componect identifer for the component containing site
     * @param p
     * @return
     */
    public int find(int p){
        validate(p);
        return id[p];
    }

   //validate that p is a vaild index
    private void validate(int p){
        int n=id.length;
        if(p <0 || p >=n){
            throw  new IllegalArgumentException("index "+p+"is  not between 0 and "+(n-1));
        }
    }

    /**
     * @param p the integer representing one site
     * @param q the integer representing the other site
     * @return
     * @throws IllegalArgumentException unless
     */
    public boolean connected(int p,int q){
        validate(p);
        validate(q);
        return id[p] == id[q];
    }

    public void union(int p,int q){
        validate(p);
        validate(q);

        int pID = id[p];
        int qID = id[q];

        //p的值和q的值相同(已经连通)p and q are already in the same component
        if(pID == qID) return;
        for(int i=0;i<id.length;i++)
            //将所有的p的值为PID的都改为q的值qID
            if(id[i]==pID) id[i]= qID;

            count--;
    }

    public static void main(String[] args) {
        QuickFindUF uf = new QuickFindUF(10);
        int[] ps ={4,3,6,9,2,8,5,7,6,1,6};
        int[] qs ={3,8,5,4,1,9,0,2,1,0,7};
        for(int i=0;i<11;i++){
            if(uf.connected(ps[i],qs[i])) continue;
            uf.union(ps[i],qs[i]);
            System.out.println(ps[i] + " "+ps[i]);
        }
        System.out.println(uf.count());
    }
}

/**
 * 解析:
 * (1)p和q的值是在n范围内的,一开始都会有n个初始化的值
 * (2)设定p和q怎么是连通的，那就是只要p和q的值相等，即为连通的
 *      所以当p的值等于q的值的时候不需要相连
 * (3)可以规定，当p和q需要先连通时，统一将所有值为q的值的设置为p的值
 * 或者统一将所有值为p的值的设置为p值
 *
 * 缺点：无法处理大型问题
 * 需要扫描整个数组
 * 平方级别
 */

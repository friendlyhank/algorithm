package com.hank.struct;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 集合类数据类型的实现-Bag
 * 缺点:会调整数组的大小，且会遍历复制数组，
 * @param <Item>
 */
public class ResizingArrayBag<Item> implements Iterable<Item> {
    private Item[] a;
    private int n;

    /**
     *Initializes an empty bag
     */
    public ResizingArrayBag(){
        //Java不能创建泛型数组,那么用类型转换就可以做到
        a =(Item[]) new Object[2];
        n=0;
    }

    /**
     * is this bag empty
     * @return
     */
    public boolean isEmpty(){
        return n==0;
    }

    /**
     * Returns the number of items in this bags
     */
    public int size(){
        return n;
    }



    /**
     *resize the underlying array holding the elements
     * @param capacity
     */
    private void resize(int capacity){
        assert capacity >= n;
        //数组一旦创建就无法改变大小，如何改变数组大小的方法是把该数组移动到另外一个大小不等的数组
        Item[] temp =(Item[])new Object[capacity];
        for(int i=0;i<n;i++){
            temp[i] = a[i];
        }
        //数组引用赋值
        a=temp;
    }

    /**
     * Adds the item to this bag
     * @param item
     */
    public void add(Item item){
        if(n==a.length) resize(2*a.length);//double size of array if necessary
        a[n++] = item;//add item
    }

    public Iterator<Item> iterator(){
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item>{
        private int i=0;

        @Override
        public boolean hasNext(){return i<n;}

        @Override
        public void remove(){ throw new UnsupportedOperationException();  }

        public Item next(){
            if (!hasNext()) throw new NoSuchElementException();
            return a[i++];
        }
    }

    public static void main(String[] args) {

        ResizingArrayBag<String> bag = new ResizingArrayBag<String>();
        bag.add("Hello");
        bag.add("World");
        bag.add("how");
        bag.add("are");
        bag.add("you");

        for(String s : bag){
            System.out.println(s);
        }
    }
}

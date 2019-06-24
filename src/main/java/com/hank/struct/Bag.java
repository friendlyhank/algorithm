package com.hank.struct;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 可迭代的集合类型 Bag
 * 背包是一种不支持从中删除元素得集合数据类型
 * 目的：收集元素并迭代遍历所有收集到的元素
 * 泛型和迭代器得使用
 * 案例：平均值为它们得和除以N,计算中顺序和结果无关，所以可以把它保存为bag对象
 * @param <Item>
 */
public class Bag<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of bag
    private int n;

    //内部类
    private static class Node<Item>{
        private Item item;
        private Node<Item> next;
    }

    /**
     * Initializes an Empty bag.
     * @return
     */
    public Bag(){
        first = null;
        n=0;
    }

    /**
     * Returns true if this bag is empty
     * @return
     */
    public boolean IsEmpty(){
        return first == null;
    }

    /**
     * Returns th number of items in this bag
     * @return
     */
    public int size(){
        return n;
    }

    /**
     * Adds the item to this bag
     * @param item
     */
    public void add(Item item){
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next =oldfirst;
        n++;
    }

    @Override
    public Iterator<Item> iterator(){
        return new ListIterator(first);
    }

    private class ListIterator implements Iterator<Item>{
        private Node<Item> current;

        public ListIterator(Node<Item> first){
            current = first;
        }

        public boolean hasNext(){return current != null;}
        public void remove(){throw new UnsupportedOperationException();}

        @Override
        public Item next(){
            if (!hasNext()) throw new NoSuchElementException();
            Item item =current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Bag<String> bag = new Bag<String>();
        bag.add("tom");
        bag.add("lily");
        bag.add("lucy");

        System.out.println("size of bag ="+bag.size());
        //implements Iterable<Item>所以可以直接遍历
        for(String s : bag){
            System.out.println(s);
        }
    }
}

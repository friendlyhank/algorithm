package com.hank.struct;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 集合类数据类型的实现-Queue
 * 缺点:会调整数组的大小，且会遍历复制数组
 * @param <Item>
 */
public class ResizingArrayQueue<Item> implements Iterable<Item>{
    private Item[] q;//queue elements
    private int n;//number of elements on queue
    private int first;//index of first element of queue
    private int last;//index of next available slot

    public ResizingArrayQueue(){
        q = (Item[]) new Object[2];
        n=0;
        first=0;
        last=0;
    }

    /**
     * is this queue empty?
     * @return
     */
    public boolean isEmpty(){
        return n == 0;
    }

    /**
     * Returns the number of items in this queue
     * @return
     */
    public int size(){
        return n;
    }

    /**
     * resize the underlying array
     * @param capacity
     */
    private void resize(int capacity) {
        assert capacity >= n;
        Item[] temp = (Item[]) new Object[capacity];
        for(int i = 0;i<n;i++){
            //从first开始复制
            temp[i] = q[(first+i)%q.length];
        }
        q=temp;
        first = 0;
        last = n;
    }

    /**
     * Adds the item to this queue
     * @param item
     */
    public void enqueue(Item item){
        if(n==q.length)resize(2*q.length);// double size of array if necessary
        q[last++]=item;// add item
        if(last == q.length)last=0;// wrap-around
        n++;
    }

    /**
     * Removes and returns the item on this queue that was least recently added
     * @return
     */
    public Item dequue(){
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = q[first];
        q[first]=null;
        n--;
        first++;
        if(first == q.length) first=0;//wrap-around
        // shrink size of array if necessary
        if (n > 0 && n == q.length/4) resize(q.length/2);
        return item;
    }

    public Item peek(){
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return q[first];
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }
    private class ArrayIterator implements Iterator<Item> {
        private int i=0;
        @Override
        public boolean hasNext() {
            return i <n;
        }
        @Override
        public void remove()      { throw new UnsupportedOperationException();  }

        @Override
        public Item next(){
            if (!hasNext()) throw new NoSuchElementException();
            Item item =q[(i+first) % q.length];
            i++;
            return item;
        }
    }


    public static void main(String[] args) {
        ResizingArrayQueue<String> queue = new ResizingArrayQueue<String>();
        queue.enqueue("Hello");
        queue.enqueue("World");
        queue.enqueue("How");

        System.out.println(queue.dequue());
        System.out.println(queue.dequue());
        System.out.println(queue.dequue());
    }
}

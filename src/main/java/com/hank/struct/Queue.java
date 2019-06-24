package com.hank.struct;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 可迭代的集合类型 Queue
 * 先进先出得队列
 * @param <Item>
 */
public class Queue<Item> implements Iterable<Item>{
    private Node<Item> first;//begining of queue
    private Node<Item> last;//end of queue
    private int n;//number of elements on queue

    private static class Node<Item>{
            private Item item;
            private Node<Item> next;
    }

   public Queue(){
        first = null;
        last = null;
        n=0;
   }

   public boolean isEmpty(){
        return first == null;
   }

   public int size(){
        return n;
   }

    /**
     * Returns the item least recently added to this queue
     * 最近最后添加得值
     * @return
     */
   public Item peek(){
        return first.item;
   }

    /**
     * Adds the item to this queue
     * @param item
     */
   public void enqueue(Item item){
        Node<Item> oldlast= last;
        last = new Node<Item>();
        last.item=item;
        last.next=null;
        if(isEmpty()) first = last;
        else   oldlast.next = last;
        n++;
   }

    /**
     * Removes and returns the item on this queue that was least recently addes
     * @return
     */
   public Item dequeue(){
       if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item =first.item;
        first = first.next;
        n--;
        if(isEmpty()) last = null;//to avoid loitering
       return item;
   }

    @Override
    public String toString() {
       //StringBuilder常用object转化字符串
        StringBuilder s = new StringBuilder();
        for(Item item :this){
            s.append(item);
            s.append(' ');
        }
        return s.toString();
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

       @Override
       public boolean hasNext(){
            return current != null;
       }

        @Override
        public void remove()      { throw new UnsupportedOperationException();  }

        @Override
        public Item next(){
           if (!hasNext())throw new NoSuchElementException();
           Item item =current.item;
           current=current.next;
           return item;
        }
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();
        queue.enqueue("tom");
        queue.enqueue("lily");
        queue.enqueue("lucy");
        System.out.println(queue.size());

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}

package com.hank.struct;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<Item> implements  Iterable<Item>{
    private int n;//number of elements on queue
    private Node first;//begging of queue
    private Node last; //end of queue

    //helper linked list class
    private class Node{
        private Item item;
        private Node next;
    }

    /**
     * Initializes an empty queue
     */
    public LinkedQueue(){
        n=0;
        first= null;
        last= null;
    }

    /**
     *is this queue empty?
     * @return
     */
    public boolean isEmpty(){
        return first == null;
    }

    /**
     * Returns the number of items in this queue
     * @return
     */
    public int size(){
        return n;
    }

    /**
     * Return the item least recently added to this queue
     * @return
     */
    public Item peek(){
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }

    /**
     *Adds the item to this queue
     * @param item
     */
    public void enqueue(Item item){
        //记录最后一次添加的尾部地址，然后把新的last放在其后面
        Node oldlast = last;
        last = new Node();
        last.item=item;
        last.next = null;
        if(isEmpty())first = last;
        else        oldlast.next = last;//不断把last放到first链表最尾部
        n++;
        assert check();
    }

    /**
     * Removes and returns the item on this queue that was least recnetly added
     */
    public Item dequeue(){
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        assert check();
        return item;
    }

    /**
     * Returns a string representation of this queue
     * @return
     */
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        for(Item item : this){
            s.append(item+" ");
        }
        return s.toString();
    }

    // check internal invariants
    private boolean check() {
        if (n < 0) {
            return false;
        }
        else if (n == 0) {
            if (first != null) return false;
            if (last  != null) return false;
        }
        else if (n == 1) {
            if (first == null || last == null) return false;
            if (first != last)                 return false;
            if (first.next != null)            return false;
        }
        else {
            if (first == null || last == null) return false;
            if (first == last)      return false;
            if (first.next == null) return false;
            if (last.next  != null) return false;

            // check internal consistency of instance variable n
            int numberOfNodes = 0;
            for (Node x = first; x != null && numberOfNodes <= n; x = x.next) {
                numberOfNodes++;
            }
            if (numberOfNodes != n) return false;

            // check internal consistency of instance variable last
            Node lastNode = first;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            if (last != lastNode) return false;
        }

        return true;
    }

    @Override
    public Iterator<Item> iterator(){
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
            private Node current=first;

        @Override
        public boolean hasNext() {
            return current != null;
        }
        @Override
        public void remove()      { throw new UnsupportedOperationException();  }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        LinkedQueue<String> linkedQueue = new LinkedQueue<String>();
        linkedQueue.enqueue("Hello");
        linkedQueue.enqueue("World");
        linkedQueue.enqueue("How");
        linkedQueue.enqueue("Are");
        linkedQueue.enqueue("You");

        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
    }
}

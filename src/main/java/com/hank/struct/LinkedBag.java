package com.hank.struct;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedBag<Item> implements Iterable<Item> {
    private Node first;
    private int n;

    /**
     * helper linked list class
     */
    private class Node{
        private Item item;
        private  Node next;
    }

    /**
     * Initializes an empty bag
     */
    public LinkedBag(){
        first= null;
        n=0;
    }

    /**
     *is the bag empty?
     * @return
     */
    public boolean isEmpty(){
        return first == null;
    }

    /**
     * Returns the number of items in this bag
     * @return
     */
    public int size(){
        return n;
    }

    public void add(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next= oldfirst;
        n++;
    }

    @Override
    public Iterator<Item> iterator(){
        return new ListIterator(first);
    }

    private class ListIterator implements Iterator<Item> {
        private Node current;

        public ListIterator(Node node){
            current = node;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next(){
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current=current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        LinkedBag<String> linkedBag = new LinkedBag<String>();
        linkedBag.add("Hello");
        linkedBag.add("World");
        linkedBag.add("How");
        linkedBag.add("Are");
        linkedBag.add("You");

        System.out.println(linkedBag.n);
    }
}

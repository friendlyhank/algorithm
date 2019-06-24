package com.hank.struct;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
*可迭代的集合类型 Stack
*后进先出栈
* 例如退后功能
 */
public class Stack<Item> implements Iterable<Item>{
    private Node<Item> first;
    private int n;

    private static class Node<Item>{
        private Item item;
        private Node<Item> next;
    }

    /**
     * Initializes an empty stack
     */
    public Stack(){
        first = null;
        n = 0;
    }

    /*
    Returns true if this stack is empty
     */
    public boolean isEmpty(){
        return first == null;
    }

    /**
     * Returns the number of items in this stack
     * @return
     */
    public int size(){
        return n;
    }

    /**
     * Adds the item to this stack
     * @param item
     */
    public void push(Item item){
        Node<Item> oldfirst=first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    /**
     * Removes and returns the item most recnetly adds to this stack
     * @return
     */
    public Item pop(){
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    /**
     * Returns(but does not remove) the item most recently added on this stack
     * @return
     */
    public Item peek(){
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    /**
     * Returns a string representation of this stack
     * @return
     */
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        for(Item item : this){
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    /**
     * Returns an iterator to this stack that iterates through the items in LIFO order
     * @return
     */
    @Override
    public Iterator<Item> iterator(){
        return new ListIterator(first);
    }

    private class ListIterator implements Iterator<Item> {
        private Node<Item> current;
        public ListIterator(Node<Item> item){
                current=item;
        }

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next(){
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("tom");
        stack.push("lily");
        stack.push("lucy");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

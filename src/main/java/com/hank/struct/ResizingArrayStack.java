package com.hank.struct;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<Item> implements Iterable<Item>{
    private Item[] a;//array of ietms
    private int n;//number of elements on stack

    public ResizingArrayStack(){
        a= (Item[]) new Object[2];
        n=0;
    }

    /**
     * is this stack empty
     * @return
     */
    public boolean isEmpty(){
        return n==0;
    }

    /**
     * Returns the number of items in the stack
     * @return
     */
    public int size(){
        return 0;
    }

    //resize the underlying array holding the elements
    public void resize(int capacity){
        assert capacity >= n;

        Item[] temp = (Item[]) new Object[capacity];
        for(int i=0;i<n;i++){
            temp[i] = a[i];
        }
        a=temp;
    }

    /**
     * Adds the item to this stack
     * @param item
     */
    public void push(Item item){
        if (n== a.length) resize(2*a.length);
        a[n++]=item;//add item
    }

    public Item pop(){
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = a[n-1];
        a[n-1]= null;// to avoid loitering
        n--;
        if (n > 0 && n == a.length/4) resize(a.length/2);
        return item;
    }

    /**
     * Returns (but does not remove) the item most recently added to this stack.
     * @return
     */
    public Item peek(){
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return a[n-1];
    }

    @Override
    public Iterator<Item> iterator(){
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;

        public ReverseArrayIterator() {
            i = n-1;
        }

        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<String>();
        stack.push("Hello");
        stack.push("World");
        stack.push("How");
        stack.push("Are");
        stack.push("You");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

package com.example.demo.stack;

import java.util.EmptyStackException;

public class Stack<E> {

    protected Object[] elementData;

    protected int length;

    public Stack() {
        elementData = new Object[10];
        length = 0;
    }

    public E push(E elem) {
        elementData[length++] = elem;
        return elem;
    }

    public E peek() {
        if (length == 0) {
            throw new EmptyStackException();
        }
        return (E) elementData[length - 1];
    }

    public E pop() {
        E elem = peek();
        elementData[length - 1] = null;
        length--;
        return elem;
    }

    public boolean empty() {
        return length == 0;
    }

    public int size() {
        return length;
    }

    public int find(E elem) {
        for (int i = length; i >= 0; i--) {
            if (elementData[i] == elem) {
                return length - i;
            }
        }
        return -1;
    }
}

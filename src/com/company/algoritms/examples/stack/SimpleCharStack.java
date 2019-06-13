package com.company.algoritms.examples.stack;

import com.company.algoritms.examples.ExampleCollection;

public class SimpleCharStack extends AbstractStack<Character> implements ExampleCollection<Character> {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public SimpleCharStack(int size) {
        this.maxSize = size;
        this.stackArray = new char[size];
        this.top = -1;
    }

    @Override
    public void insert(Character value) {
        push(value);
    }

    public void push(char newItem) {
        stackArray[++top] = newItem;
    }

    public char pop() {
        return stackArray[top--];
    }

    public char peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public int size() {
        return top + 1;
    }

    public Character getPeek(int elementIndex) {
        return stackArray[elementIndex];
    }
}

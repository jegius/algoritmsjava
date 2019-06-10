package com.company.algoritms.examples.stack;

import com.company.algoritms.examples.ExampleCollection;

public class SimpleStack implements ExampleCollection<Long> {
    private int maxSize;
    private long[] stackArray;
    private int top;

    public SimpleStack(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new long[maxSize];
        top = -1;
    }

    public void insert(Long value){
        stackArray[++top] = value;
    }

    public void push(long value) {
        this.insert(value);
    }

    public long pop() {
        return stackArray[top--];
    }

    public long peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }
}

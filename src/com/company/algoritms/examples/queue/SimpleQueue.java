package com.company.algoritms.examples.queue;

import com.company.algoritms.examples.ExampleCollection;

public class SimpleQueue implements ExampleCollection<Long> {
    private int maxSize;
    private Long[] queueArray;
    private int front;
    private int rear;
    private int length;

    public SimpleQueue(int maxSize) {
        this.maxSize = maxSize;
        this.queueArray = new Long[maxSize];
        this.front = 0;
        this.rear = -1;
        this.length = 0;
    }

    @Override
    public void insert(Long value) {
        if (rear == maxSize - 1) {
            rear = -1;
        }

        queueArray[++rear] = value;
        length++;
    }

    public Long remove() {
        Long temp = queueArray[front++];

        if(front == maxSize) {
            front = 0;
        }
        length--;

        return temp;
    }

    public long peekFront() {
        return queueArray[front];
    }

    public boolean isEmpty() {
        return (length == 0);
    }

    public boolean isFull() {
        return (length == maxSize);
    }

    public int size() {
        return length;
    }
}

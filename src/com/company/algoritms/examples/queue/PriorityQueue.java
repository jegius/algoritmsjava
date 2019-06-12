package com.company.algoritms.examples.queue;

public class PriorityQueue implements ExampleQueue<Long> {
    private int maxSize;
    private Long[] queueArray;
    private int length;

    public PriorityQueue(int size) {
        this.maxSize = size;
        this.queueArray = new Long[size];
        this.length = 0;
    }

    @Override
    public void insert(Long value) {
        if (length == 0) {
            queueArray[length++] = value;
        } else {
            sortElementsAndInsert(value);
        }
    }

    public Long remove() {
        return queueArray[--length];
    }

    public Long peekMin() {
        return queueArray[length - 1];
    }

    public boolean isEmpty() {
        return (length == 0);
    }

    public boolean isFull() {
        return (length == maxSize);
    }

    private void sortElementsAndInsert(Long value) {
        int lastElementIndex;

        for (lastElementIndex = length - 1; lastElementIndex >= 0; lastElementIndex--) {
            if (value > queueArray[lastElementIndex]) {
                queueArray[lastElementIndex + 1] = queueArray[lastElementIndex];
            } else {
                break;
            }
        }
        queueArray[lastElementIndex + 1] = value;
        length++;
    }

}

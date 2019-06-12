package com.company.algoritms.examples.queue;

import com.company.algoritms.examples.Example;

public class QueueExample implements Example {
    private static final int MAX_SIZE = 5;

    @Override
    public void showExample() {
        queueShowCase();
    }

    private void queueShowCase() {
        SimpleQueue simpleQueue = new SimpleQueue(MAX_SIZE);
        simpleQueue.insert(10L);
        simpleQueue.insert(20L);
        simpleQueue.insert(30L);
        simpleQueue.insert(40L);

        simpleQueue.remove();
        simpleQueue.remove();
        simpleQueue.remove();

        simpleQueue.insert(50L);
        simpleQueue.insert(60L);
        simpleQueue.insert(70L);
        simpleQueue.insert(80L);

        showQueue(simpleQueue);
    }

    private void showQueue(SimpleQueue queue) {
        while (!queue.isEmpty()) {
            Long element = queue.remove();
            System.out.println(element);
        }
    }
}

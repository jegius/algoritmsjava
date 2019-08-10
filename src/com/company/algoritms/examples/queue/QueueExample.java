package com.company.algoritms.examples.queue;

import com.company.algoritms.enums.ExampleType;
import com.company.algoritms.examples.Example;

public class QueueExample implements Example {
    private static final int MAX_SIZE = 5;

    private final ExampleType type;

    public QueueExample(ExampleType type) {
        this.type = type;
    }

    @Override
    public void showExample() {
        priorityQueueShowCase();
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

    private void showQueue(ExampleQueue queue) {
        while (!queue.isEmpty()) {
            Long element = (Long) queue.remove();
            System.out.println(element);
        }
    }

    /**
     * Вставка элемента в приоритетной очереди - O(N)
     * извлечение - O(1)
     * */
    private void priorityQueueShowCase() {
        PriorityQueue priorityQueue = new PriorityQueue(MAX_SIZE);

        priorityQueue.insert(30L);
        priorityQueue.insert(10L);
        priorityQueue.insert(50L);
        priorityQueue.insert(90L);
        priorityQueue.insert(20L);

        showQueue(priorityQueue);
    }

    public ExampleType getType() {
        return type;
    }
}

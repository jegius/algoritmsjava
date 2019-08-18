package com.company.algoritms.examples.graph.weightedgraphs;

public class PriorityQueue {
    private final int SIZE = 20;
    private Edge[] queue;
    private int size;

    public PriorityQueue() {
        this.queue = new Edge[SIZE];
        this.size = 0;
    }

    public void insert(Edge item) {
        int index;

        for (index = 0; index < size; index++) {
            if (item.getDistance() > queue[index].getDistance()) {
                break;
            }
        }

        for (int upIndex = size - 1; upIndex >= index; upIndex--) {
            queue[upIndex + 1] = queue[upIndex];
        }

        queue[index] = item;
        size++;
    }

    public Edge removeMin(){
        return queue[--size];
    }

    public void removeByPosition(int position) {
        for (int index = position; index < size - 1; index++) {
            queue[index] = queue[index + 1];
        }
        size--;
    }

    public Edge peekMin() {
        return queue[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Edge peekPosition(int position) {
        return queue[position];
    }

    public int find(int searchIndex) {
        for (int index = 0; index < size; index++) {
            if (queue[index].getEndVertex() == searchIndex) {
                return  index;
            }
        }
        return -1;
    }

}

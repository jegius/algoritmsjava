package com.company.algoritms.examples.heap;

import com.company.algoritms.examples.ExampleCollection;

/**
 * Частный случай бинарного дерева. Все операции выполняются за время O(log N).
 * Можно использовать для сортировки, вкладывая элементы методом insert и удаляя методом remove
 * извлекаться из пирамиды элементы будут в отсортированном виде. Эффективность соритровки с
 * помощью пирамиды O(n * log N) Основная задержка идет на врмемя перемешиня элементов вверх. Преимущество
 * пирамидальной сортировки перед мысторй соритровкой в том что немотря на то что она немного медленнее, она
 * всегда выполняется за одно и тоже время, в то время как быстрая сортировка в некоторых случаех может выполняться
 * за время O(pow(2, N))
 * */

public class Heap implements ExampleCollection<Long> {
    private Node<Long>[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        this.heapArray = new Node[maxSize];
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean insert(int key, Long data) {
        if (currentSize == maxSize) {
            return false;
        }

        Node<Long> newNode = new Node(key, data);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }

    public Node remove() {
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }


    @Override
    public void insert(Long value) {
        insert(value.intValue(), (long) (Math.random() * 100));
    }

    public boolean change(int index, int newValue) {
        if (index < 0 || index >= currentSize) {
            return false;
        }
        long oldValue = heapArray[index].getKey();
        heapArray[index].setKey(newValue);

        if (oldValue < newValue) {
            trickleUp(index);
        } else {
            trickleDown(index);
        }
        return true;

    }

    public void display() {
        System.out.print("HeapArray: ");

        for (int index = 0; index < currentSize; index++) {
            if (heapArray[index] != null) {
                System.out.print(heapArray[index].getKey() + " ");
            } else {
                System.out.print("-- ");
            }
        }
        System.out.println();

        int blanks = 32;
        int itmsPerRow = 1;
        int column = 0;
        int index = 0;

        String dots = "............................";
        System.out.println(dots + dots);

        while (currentSize > 0) {
            if (column == 0) {
                for (int innerIndex = 0; innerIndex < blanks; innerIndex++) {
                    System.out.print(' ');
                }
            }
            System.out.print(heapArray[index].getKey());
            if (++index == currentSize) {
                break;
            }

            if (++column == itmsPerRow) {
                blanks /= 2;
                itmsPerRow *= 2;
                column = 0;
                System.out.println();
            } else {
                for (int innerIndex = 0; innerIndex < blanks * 2 - 2; innerIndex++) {
                    System.out.print(' ');
                }
            }
        }
        System.out.println("\n" + dots + dots);
    }

    private void trickleDown(int index) {
        int largerChild;
        Node top = heapArray[index];

        while (index < currentSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            if (rightChild < currentSize &&
                    heapArray[leftChild].getKey() < heapArray[rightChild].getKey()) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }

            if (top.getKey() >= heapArray[largerChild].getKey()) {
                break;
            }

            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;
    }

    private void trickleUp(int index) {
        int parent = (index - 1) / 2;
        Node bottom = heapArray[index];

        while (index > 0 && heapArray[parent].getKey() < bottom.getKey()) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }
        heapArray[index] = bottom;
    }
}

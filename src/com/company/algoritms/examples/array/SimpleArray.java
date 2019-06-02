package com.company.algoritms.examples.array;

class SimpleArray {
    private long[] array;
    private int length;

    SimpleArray(int maxArrayLength) {
        array = new long[maxArrayLength];
        length = 0;
    }

    boolean find(long searchKey) {
        int elementIndex;
        for (elementIndex = 0; elementIndex < length; elementIndex++) {
            if (array[elementIndex] == searchKey) {
                break;
            }
        }
        return !(elementIndex == length);
    }

    void insert(long value) {
        array[length] = value;
        length++;
    }

    boolean delete(long value) {
        int elementIndex;

        for (elementIndex = 0; elementIndex < length; elementIndex++) {
            if (value == array[elementIndex]) {
                break;
            }
        }

        if (elementIndex == length) {
            return false;
        } else {
            for (int replaceIndex = elementIndex; replaceIndex < length; replaceIndex++) {
                array[replaceIndex] = array[replaceIndex + 1];
            }

            length--;
            return true;
        }
    }

    void display() {
        for (long element : array) {
            System.out.println("[" + element + "] ");
        }
    }

    int binyriSearch(long searchKey) {
        int lowerBound = 0;
        int upperBound = length - 1;
        int currentIndex;

        while (true) {
            currentIndex = (lowerBound + upperBound) / 2;

            if (array[currentIndex] == searchKey) {
                return currentIndex;
            } else if (lowerBound > upperBound) {
                return length;
            } else {
                if (array[currentIndex] < searchKey) {
                    lowerBound = currentIndex + 1;
                } else {
                    upperBound = currentIndex - 1;
                }
            }
        }
    }
}

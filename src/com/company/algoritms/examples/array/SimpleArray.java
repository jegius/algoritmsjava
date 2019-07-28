package com.company.algoritms.examples.array;

import com.company.algoritms.examples.ExampleCollection;

class SimpleArray implements ExampleCollection<Long> {
    private long[] array;
    private int length;

    SimpleArray(int maxArrayLength) {
        array = new long[maxArrayLength];
        length = 0;
    }

    long get(int elementIndex) throws Exception {
        if (elementIndex < length && elementIndex > 0) {
            return array[elementIndex];
        }
        throw new Exception("Element not found in array");
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

    public void insert(Long value) {
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
            for (int replaceIndex = elementIndex; replaceIndex < length - 1; replaceIndex++) {
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

    /**
     * Простой бинарный поиск, сложность алгоритма O(log N)
     */
    int binarySearch(long searchKey) {
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

    /**
     * Рекурсивный бинарный поиск, сложность O(log N),
     * однака из-за рекурсии может потреблять больше ресурсов.
     */
    int findWithUseRecursion(int searchKey) {
        return recursiveBinarySearch(searchKey, 0, length - 1);
    }

    private int recursiveBinarySearch(long searchKey, int lowerBound, int upperBound) {
        int currentInput = (lowerBound + upperBound) / 2;

        if (array[currentInput] == searchKey) {
            return currentInput;
        } else if (lowerBound > upperBound) {
            return length;
        } else {
            if (array[currentInput] < searchKey) {
                return recursiveBinarySearch(searchKey, currentInput + 1, upperBound);
            } else {
                return recursiveBinarySearch(searchKey, lowerBound, currentInput - 1);
            }
        }
    }

    /**
     * Сложность: O(pow(N, 2))
     * Самый простой и самый медленный метод сортировки
     */
    void bubbleSort() {
        int output;
        int input;

        for (output = length - 1; output > 1; output--) {
            for (input = 0; input < output; input++) {
                if (array[input] > array[output]) {
                    swap(input, output);
                }
            }
        }
    }

    /**
     * Сложность: O(pow(N, 2))
     * Меньше колличество перестоновок, как итог будет работать
     * быстрее при малых значениях N
     */
    void selectSort() {
        int outputValue;
        int inputValue;
        int minimum;

        for (outputValue = 0; outputValue < length - 1; outputValue++) {
            minimum = outputValue;

            for (inputValue = outputValue + 1; inputValue < length; inputValue++) {
                if (array[inputValue] < array[minimum]) {
                    minimum = inputValue;
                }
                swap(outputValue, minimum);
            }
        }
    }

    /**
     * Сложность: O(pow(N, 2))
     * Работает в два раза быстрее сортировки пузырьком и в нормальных условиях
     * быстрее сортировки выбором.
     */
    void insertSort() {
        int input;
        int output;

        for (output = 1; output < length; output++) {
            long temp = array[output];
            input = output;
            while (input > 0 && array[input - 1] >= temp) {
                array[input] = array[input - 1];
                --input;
            }
            array[input] = temp;
        }
    }

    private void swap(int first, int second) {
        long temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}

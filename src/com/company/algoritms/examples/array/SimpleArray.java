package com.company.algoritms.examples.array;

import com.company.algoritms.examples.ExampleCollection;

public class SimpleArray implements ExampleCollection<Long> {
    private long[] array;
    private int length;

    public SimpleArray(int maxArrayLength) {
        array = new long[maxArrayLength];
        length = 0;
    }

    public long get(int elementIndex) throws Exception {
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

    public void display() {
        for (long element : array) {
            System.out.println("[" + element + "] ");
        }
    }


    /**
     *  Быстрая сортировка, время выполнения O(N*log(n))
     *  для случаев сортировки в ОЗУ.
     * */
    public void quickSort() {
        recQuickSort(0, length - 1);
    }

    private void recQuickSort(int left, int right) {
        if (right - left <= 0) {
            return;
        } else {
            long pivot = array[right];

            int partition = partitionIt(left, right, pivot);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }

    /**
     * Эффективность алгоритма увеличина за счет сортировки выбором при
     * небольших размерах массива отсортированных в обратном порядке,
     * при сортировки случайных чисел выигрыша нет.
     * */
    public void optimizedQuickSort() {
        optimizedRecQuickSort(0, length - 1);
    }

    private void optimizedRecQuickSort(int left, int right) {
        int size = right - left + 1;

        if (size <= 3) {
            manualSort(left, right);
        } else {
            long median = medianOfThree(left, right);
            int partition = partitionIt(left, right, median);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }

    private void manualSort(int left, int right) {
        int size = right - left + 1;

        if (size <= 1) {
            return;
        }

        if (size == 2) {
            if (array[left] > array[right]) {
                swap(left, right);
            }
            return;
        } else {
            if (array[left] > array[right - 1]){
                swap(left, right - 1);
            }
            if (array[left] > array[right]) {
                swap(left, right);
            }
            if (array[right - 1] > array[right]) {
                swap(right - 1, right);
            }
        }
    }

    private long medianOfThree(int left, int right) {
        int center = (left + right) / 2;

        if (array[left] > array[center]) {
            swap(left, center);
        }

        if (array[left] > array[right]) {
            swap(left, right);
        }

        if (array[center] > array[right]) {
            swap(center, right);
        }

        swap(center, right - 1);

        return array[right - 1];
    }

    /**
     *  Алгоритм разделения, выполняется за время O(N)
     * */
    public int partitionIt(int left, int right, long pivot) {
        int leftPointer = left - 1;
        int rightPointer = right;

        while (true) {
            while (leftPointer < right && array[++leftPointer] < pivot);

            while (rightPointer > left && array[--rightPointer] > pivot);

            if(leftPointer >= rightPointer) {
                break;
            } else {
                swap(leftPointer, rightPointer);
            }
        }
        swap(leftPointer, right);
        return leftPointer;
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
     * Сложность: O(n * log n)
     * Эфективный алгоритм сортировки основанный на рекурсии, в связи с чем
     * требует большого объема оперативной памяти для храненеия временных данных.
     */
    public void mergeSort() {
        long[] workSpace = new long[length];
        recursionMergeSort(workSpace, 0, length - 1);
    }

    private void recursionMergeSort(long[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound != upperBound) {
            int mid = (lowerBound + upperBound) / 2;
            recursionMergeSort(workSpace, lowerBound, mid);
            recursionMergeSort(workSpace, mid + 1, upperBound);
            merge(workSpace, lowerBound, mid + 1, upperBound);
        }
    }

    private void merge(long[] workSpace, int lowPointer, int highPointer, int upperBound) {
        int elementIndex = 0;
        int loverBound = lowPointer;
        int mid = highPointer - 1;
        int cycleCounter = upperBound - loverBound + 1;

        while (lowPointer <= mid && highPointer <= upperBound) {
            if (array[lowPointer] < array[highPointer]) {
                workSpace[elementIndex++] = array[lowPointer++];
            } else {
                workSpace[elementIndex++] = array[highPointer++];
            }
        }

        while (lowPointer <= mid) {
            workSpace[elementIndex++] = array[lowPointer++];
        }

        while (highPointer <= upperBound) {
            workSpace[elementIndex++] = array[highPointer++];
        }

        for (elementIndex = 0; elementIndex < cycleCounter; elementIndex++) {
            array[loverBound + elementIndex] = workSpace[elementIndex];
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
     * Сложность: В общем случае O pow(log N, 2)
     * Алгоритм Шелла. Схож по скорости работы с быстрой сортировкой,
     * отлично подходит для сортировки массивов средней длины.
     */
    public void shellSort() {
        int innerPointer;
        int outerPointer;
        long temp;
        int baseValue = 1;

        final int ARRAY_DIVIDE_QUANTIFICATION = 3;

        while (baseValue <= length / ARRAY_DIVIDE_QUANTIFICATION) {
            baseValue = baseValue * ARRAY_DIVIDE_QUANTIFICATION + 1;
        }

        while (baseValue > 0) {
            for (outerPointer = baseValue; outerPointer < length; outerPointer++) {
                temp = array[outerPointer];
                innerPointer = outerPointer;

                while (innerPointer > baseValue - 1 && array[innerPointer - baseValue] >= temp) {
                    array[innerPointer] = array[innerPointer - baseValue];
                    innerPointer -= baseValue;
                }
                array[innerPointer] = temp;
            }
            baseValue = (baseValue - 1) / ARRAY_DIVIDE_QUANTIFICATION;
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

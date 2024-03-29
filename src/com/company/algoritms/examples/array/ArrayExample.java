package com.company.algoritms.examples.array;

import com.company.algoritms.AlgorithmUtils;
import com.company.algoritms.enums.ExampleType;
import com.company.algoritms.examples.Example;

public class ArrayExample implements Example {
    private static final int MAX_LENGTH = 10;

    private final ExampleType type;

    public ArrayExample(ExampleType type) {
        this.type = type;
    }

    public void showExample() {
        showSimpleExample();
        showBinarySearch();
        selectSort();
        insertSort();
    }

    private void showSimpleExample() {
        SimpleArray demo = new SimpleArray(MAX_LENGTH);
        AlgorithmUtils.fillCollectionWithRandomNumbers(demo, MAX_LENGTH);

        demo.display();

        int testValue = 11;
        if (demo.find(testValue)) {
            System.out.println("Found " + testValue);
        } else {
            System.out.println("Can't find " + testValue);
        }

        try {
            long testInt = demo.get(1);
            demo.delete(testInt);
            demo.display();
        } catch (Exception error) {
            error.printStackTrace();
        }
    }


    private void showBinarySearch() {

        SimpleArray bubbleSort = new SimpleArray(MAX_LENGTH);
        AlgorithmUtils.fillCollectionWithRandomNumbers(bubbleSort, MAX_LENGTH);
        bubbleSort.bubbleSort();

        System.out.println(bubbleSort.binarySearch(10));
        System.out.println(bubbleSort.findWithUseRecursion(10));

        bubbleSort.display();
    }

    private void selectSort() {
        SimpleArray selectSort = new SimpleArray(MAX_LENGTH);
        AlgorithmUtils.fillCollectionWithRandomNumbers(selectSort, MAX_LENGTH);
        selectSort.selectSort();

        selectSort.display();
    }

    private void insertSort() {
        SimpleArray insertSort = new SimpleArray(MAX_LENGTH);
        AlgorithmUtils.fillCollectionWithRandomNumbers(insertSort, MAX_LENGTH);
        insertSort.insertSort();

        insertSort.display();
    }

    public ExampleType getType() {
        return type;
    }
}
